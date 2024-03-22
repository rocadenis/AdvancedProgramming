package Lab2.Homework;

import java.util.*;

/**
 * Clasa care reprezinta o problema logistica.
 */
public class Problem {
    private Set<Depot> depots = new HashSet<>();
    private Set<Client> clients = new HashSet<>();
    private Map<String, Integer> travelTimes = new HashMap<>();

    /**
     * Constructor pentru a initializa o noua problema logistica.
     */
    public Problem() {
        // Constructorul va initializa structurile de date necesare
    }

    /**
     * Adauga un depozit la problema logistica.
     */
    public void addDepot(Depot depot) {
        this.depots.add(depot);
    }

    /**
     * Adauga un client la problema logistica.
     */
    public void addClient(Client client) {
        this.clients.add(client);
    }

    /**
     * Returneaza o lista de vehicule din toate depozitele.
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Depot depot : this.depots) {
            vehicles.addAll(Arrays.asList(depot.getVehicles()));
        }
        return vehicles.toArray(new Vehicle[0]);
    }

    /**
     * Aloca clientii la vehicule Greedy
     */
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

    /**
     * Aloca un client la un vehicul.
     */
    private void allocateClientToVehicle(Client client, Vehicle vehicle) {
        System.out.println("Clientul alocat " + client.getId() + " la vehiculul " + vehicle.getId());
    }

    /**
     * Adauga un timp de calatorie aleatoriu intre doua locatii.
     */
    public void addRandomTravelTime(String location1, String location2) {
        Random random = new Random();
        int travelTime = random.nextInt(180); // Generam un timp aleatoriu intre 0 si 180 de minute
        addTravelTime(location1, location2, travelTime);
    }

    /**
     * Adauga un timp de calatorie intre doua locatii.
     */
    public void addTravelTime(String location1, String location2, int travelTime) {
        String key1 = "depot-" + location2;
        String key2 = location1 + "-depot";

        travelTimes.put(key1, Math.min(travelTime, 180));
        travelTimes.put(key2, Math.min(travelTime, 180));
    }

    /**
     * Metoda pentru a calcula timpul de calatorie intre depozit si client.
     */
    public static String travel(Problem problem, String depot, String s, String depot1, String s1) {
        int travelTime = 0;

        // Verificam daca locatiile sunt depozite sau clienti
        @SuppressWarnings("unused")
        String locationType1;
        
        if (depot.equals("Depot")) {
            locationType1 = "depot";
        } else {
            locationType1 = "client";
        }

        @SuppressWarnings("unused")
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
