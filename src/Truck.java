
import java.util.Iterator;
import java.util.LinkedList;

public class Truck {

    Iterator<String> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    protected Truck(int loadLimit) {
        this.loadLimit = loadLimit;
        this.currentLoad = loadLimit;
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

    public LinkedList<Parcel> getParcels() {
        return list;
    }

    public boolean addParcel(Parcel p) {
        if (canFit(p) && list.add(p)) {
            currentLoad -= p.getWeight();
            return true;
        } else {
            return false;
        }
    }

    public boolean canFit(Parcel p) {
        return currentLoad >= p.getWeight();
    }

}
