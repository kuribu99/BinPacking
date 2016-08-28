package data;

import java.io.Serializable;

public class Parcel implements Serializable, Comparable<Parcel> {

    private final int weight;

	//Initialize parcel
    public Parcel(int weight) {
        this.weight = weight;
    }

	//Get parcel weight	
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Parcel o) {
        // If other has higher weight, result will be positive number
        // Positive number will be order behind
        return o.weight - weight;
    }

}
