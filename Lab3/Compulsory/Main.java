package Lab3.Compulsory;

public class Main {
    public static void main(String[] args) {
        // Crearea unei calatorii
        Trip trip = new Trip("Paris", "Vara");

        // Adaugarea atractiilor în calatorie
        Statue eiffelTower = new Statue("Turnul Eiffel");
        trip.addAttraction(eiffelTower);

        Church notreDame = new Church("Notre Dame", 10.0);
        trip.addAttraction(notreDame);

        Concert concert = new Concert("Concert Rock", 25.0);
        //trip.addAttraction(concert);

        // Vizitarea atractiilor din calatorie
        for (Visitable attraction : trip.getAttractions()) {
            attraction.visit();
        }

        // Obtinerea pretului de intrare pentru un concert
        System.out.println("Pretul pentru " + concert.getName() + ": $" + concert.getEntranceFee());
    }
}
 