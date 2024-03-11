package Lab2;
import java.util.*;

public class Problem {
    private Set<Depot> depots = new HashSet<>();
    private Set<Client> clients = new HashSet<>();
    private Map<String, Integer> travelTimes = new HashMap<>();

    public Problem() {
        // Constructorul va inițializa structurile de date necesare
    }

    public void addDepot(Depot depot) {
        this.depots.add(depot);
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Vehicle[] getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Depot depot : this.depots) {
            vehicles.addAll(Arrays.asList(depot.getVehicles()));
        }
        return vehicles.toArray(new Vehicle[0]);
    }

    public void allocateClients() {
        for (Depot depot : this.depots) {
            Vehicle[] depotVehicles = depot.getVehicles();
            for (Client client : this.clients) {
                if (depotVehicles.length > 0) {
                    Vehicle vehicle = depotVehicles[0];
                    allocateClientToVehicle(client, vehicle);
                }
            }
        }
    }

    private void allocateClientToVehicle(Client client, Vehicle vehicle) {
        System.out.println("Clientul alocat " + client.getId() + " la vehiculul " + vehicle.getId());
    }

    public void addRandomTravelTime(String location1, String location2) {
        Random random = new Random();
        int travelTime = random.nextInt(180); // Generăm un timp aleatoriu între 0 și 180 de minute
        addTravelTime(location1, location2, travelTime);
    }




    public void addTravelTime(String location1, String location2, int travelTime) {
        String key1 = "depot-" + location2;
        String key2 = location1 + "-depot";
        String key3 = location1 + "-" + location2;
        String key4 = location2 + "-" + location1;

        travelTimes.put(key1, Math.min(travelTime, 180));
        travelTimes.put(key2, Math.min(travelTime, 180));
        travelTimes.put(key3, Math.min(travelTime, 180));
        travelTimes.put(key4, Math.min(travelTime, 180));
    }


    // Metodă pentru a calcula timpul de călătorie între ldepot-client viceversa
    @SuppressWarnings("unused")
    public static String travel(Problem problem, String depot, String s, String depot1, String s1) {
        // Declarați și inițializați variabila pentru timpul de călătorie
        int travelTime = 0;

        // Verificați dacă locațiile sunt depot-uri sau clienți
        String locationType1;
        if (depot.equals("Depot")) {
            locationType1 = "depot";
        } else {
            locationType1 = "client";
        }

        String locationType2;
        if (depot1.equals("Depot")) {
            locationType2 = "depot";
        } else {
            locationType2 = "client";
        }
         travelTime = (int) (Math.random() * 181);

        return String.valueOf(travelTime);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "travelTimes=" + travelTimes +
                '}';
    }
}
