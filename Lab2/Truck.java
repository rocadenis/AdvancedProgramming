package Lab2;

public class Truck extends Vehicle {
    private int capacity;

    public Truck(String id, int capacity) {
        super(id);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                '}';
    }
}
