package Lab2.Homework;

/**
 * Clasa care reprezinta un camion.
 */
public class Truck extends Vehicle {
    private int capacity;

    /**
     * Constructor pentru a initializa un nou camion cu un ID dat și o capacitate dată.
     * 
     * @param id ID-ul camionului
     * @param capacity capacitatea camionului
     */
    public Truck(String id, int capacity) {
        super(id);
        this.capacity = capacity;
    }

    /**
     * Returneaza capacitatea camionului.
     * 
     * @return capacitatea camionului
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Returneaza o reprezentare de sir de caractere a acestui camion.
     * 
     * @return reprezentarea de sir de caractere a acestui camion
     */
    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                '}';
    }
}
