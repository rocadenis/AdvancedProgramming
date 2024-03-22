package Lab2.Homework;

import java.util.Objects;

/**
 * Clasa care reprezinta un client.
 */
public class Client {
    private String id;

    /**
     * Constructor pentru a initializa un nou client cu un ID dat.
     * 
     * @param id ID-ul clientului
     */
    public Client(String id) {
        this.id = id;
    }

    /**
     * Returneaza ID-ul clientului.
     * 
     * @return ID-ul clientului
     */
    public String getId() {
        return this.id;
    }

    /**
     * Verifica daca obiectul specificat este egal cu acest client.
     * 
     * @param obj obiectul de comparat
     * @return true daca obiectele sunt egale, false in caz contrar
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Client)) {
            return false;
        } else {
            Client other = (Client)obj;
            return this.getId().equals(other.getId());
        }
    }

    /**
     * Returneaza o reprezentare de sir de caractere a acestui client.
     * 
     * @return reprezentarea de sir de caractere a acestui client
     */
    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                '}';
    }

    /**
     * Returneaza un cod hash pentru acest client.
     * 
     * @return cod hash pentru acest client
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
