package Lab2;
import java.util.Objects;

public class Client {
    private String id;

    public Client(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

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

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
