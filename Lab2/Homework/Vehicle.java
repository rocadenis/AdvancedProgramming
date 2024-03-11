package Lab2.Homework;

/**
 * Clasa abstracta care reprezinta un vehicul.
 */
public abstract class Vehicle {
    private String id;

    /**
     * Constructor pentru a initializa un nou vehicul cu un ID dat.
     * 
     * @param id ID-ul vehiculului
     */
    public Vehicle(String id) {
        this.id = id;
    }

    /**
     * Returneaza ID-ul vehiculului.
     * 
     * @return ID-ul vehiculului
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returneaza o reprezentare de sir de caractere a acestui vehicul.
     * 
     * @return reprezentarea de sir de caractere a acestui vehicul
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                '}';
    }
}
