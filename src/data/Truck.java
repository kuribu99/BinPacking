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

    public Truck(int loadLimit) {
        this.loadLimit = loadLimit;
        this.currentLoad = 0;
        this.list = new LinkedList<>();
    }

    public int getLoadLimit() {
        return loadLimit;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public int getRemainingLoad() {
        return loadLimit - currentLoad;
    }

    public boolean isFull() {
        return getRemainingLoad() == 0;
    }

    public LinkedList<Parcel> getParcels() {
        return list;
    }

    public boolean addParcel(Parcel p) {
        if (canFit(p) && list.add(p)) {
            currentLoad += p.getWeight();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean canFit(Parcel p) {
        return getRemainingLoad() >= p.getWeight();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Truck => ");

        for (Parcel parcel : list) {
            builder.append("[")
                    .append(parcel.getWeight())
                    .append("] ");
        }
        return builder.toString();
    }

}
