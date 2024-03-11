package Lab2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Depot {
    private String name;
    private Set<Vehicle> vehicles;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Depot(String name) {
        this.name = name;
        this.vehicles = new HashSet();
    }

    public String getName() {
        return this.name;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public Vehicle[] getVehicles() {
        return (Vehicle[])this.vehicles.toArray(new Vehicle[0]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Depot)) {
            return false;
        } else {
            Depot other = (Depot)obj;
            return this.getName().equals(other.getName());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vehicles);
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
