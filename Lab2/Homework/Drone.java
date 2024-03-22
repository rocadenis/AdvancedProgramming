package Lab2.Homework;

/**
 * Clasa care reprezinta o drona.
 */
public class Drone extends Vehicle {
    private int maxFlightDuration;

    /**
     * Constructor pentru a initializa o noua drona cu un ID dat si o durata maxima de zbor data.
     * 
     * @param id ID-ul dronei
     * @param maxFlightDuration durata maxima de zbor a dronei
     */
    public Drone(String id, int maxFlightDuration) {
        super(id);
        this.maxFlightDuration = maxFlightDuration;
    }

    /**
     * Returneaza o reprezentare de sir de caractere a acestei drone.
     * 
     * @return reprezentarea de sir de caractere a acestei drone
     */
    @Override
    public String toString() {
        return "Drone{" +
                "maxFlightDuration=" + maxFlightDuration +
                '}';
    }

    /**
     * Returneaza durata maxima de zbor a acestei drone.
     * 
     * @return durata maxima de zbor a acestei drone
     */
    public int getMaxFlightDuration() {
        return this.maxFlightDuration;
    }
}
