
import java.io.Serializable;

public class Parcel implements Serializable {

    private final int weight;

    public Parcel(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}
