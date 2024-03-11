package Lab2;

public class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String id, int maxFlightDuration) {
        super(id);
        this.maxFlightDuration = maxFlightDuration;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Drone{" +
                "maxFlightDuration=" + maxFlightDuration +
                '}';
    }


    public int getMaxFlightDuration() {
        return this.maxFlightDuration;
    }
}
