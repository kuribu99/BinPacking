package data;

import java.util.LinkedList;

public class Truck {

    // Factory for truck to make trucks based on load limit
    // This allows truck with consistent load limit
    public static class Factory {

        private final int loadLimit;

        public Factory(int loadLimit) {
            this.loadLimit = loadLimit;
        }

        public int getLoadLimit() {
            return loadLimit;
        }

        public Truck make() {
            return new Truck(loadLimit);
        }

    }

    // Fields
    private final LinkedList<Parcel> list;
    private final int loadLimit;
    private int currentLoad;

	// Initialize truck
    public Truck(int loadLimit) {
        this.loadLimit = loadLimit;
        this.currentLoad = 0;
        this.list = new LinkedList<>();
    }

	// Get truck load limit
    public int getLoadLimit() {
        return loadLimit;
    }

	// Get current load in the truck
    public int getCurrentLoad() {
        return currentLoad;
    }

	// Get remaining load available in the truck
    public int getRemainingLoad() {
        return loadLimit - currentLoad;
    }

	// If truck is full, remaining load is 0	
    public boolean isFull() {
        return getRemainingLoad() == 0;
    }

	// Get parcel list
    public LinkedList<Parcel> getParcels() {
        return list;
    }

	// Add parcel to current load
    public boolean addParcel(Parcel p) {
        if (canFit(p) && list.add(p)) {
            currentLoad += p.getWeight();
            return true;
        }
        else {
            return false;
        }
    }

	// If remaining load is larger than parcel weight, the truck can fit in more parcel
    public boolean canFit(Parcel p) {
        return getRemainingLoad() >= p.getWeight();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
		// Display trucks
        builder.append("Truck => ");

		// Display parcels		
        for (Parcel parcel : list) {
            builder.append("[")
                    .append(parcel.getWeight())
                    .append("] ");
        }
        return builder.toString();
    }

}
