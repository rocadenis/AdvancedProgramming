package Lab2.Homework;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Clasa care reprezinta un depozit in cadrul unei probleme logistice.
 */
public class Depot {
    private String name;
    private Set<Vehicle> vehicles;

    /**
     * Constructor pentru a initializa un nou depozit cu un nume dat.
     * 
     * @param name numele depozitului
     */
    public Depot(String name) {
        this.name = name;
        this.vehicles = new HashSet<>();
    }

    /**
     * Returneaza numele depozitului.
     * 
     * @return numele depozitului
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adauga un vehicul in depozit.
     * 
     * @param vehicle vehiculul de adaugat
     */
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    /**
     * Returneaza un tablou de vehicule disponibile in depozit.
     * 
     * @return tablou de vehicule disponibile in depozit
     */
    public Vehicle[] getVehicles() {
        return this.vehicles.toArray(new Vehicle[0]);
    }

    /**
     * Verifica daca obiectul specificat este egal cu acest depozit.
     * 
     * @param obj obiectul de comparat
     * @return true daca obiectele sunt egale, false in caz contrar
     */
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

    /**
     * Returneaza un cod hash pentru acest depozit.
     * 
     * @return cod hash pentru acest depozit
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, vehicles);
    }

    /**
     * Returneaza o reprezentare de sir de caractere a acestui depozit.
     * 
     * @return reprezentarea de sir de caractere a acestui depozit
     */
    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
