
import java.util.LinkedList;
import java.util.PriorityQueue;

public class WorstFitAlgorithm extends Algorithm {

    public WorstFitAlgorithm() {
        super(Algorithm.Factory.WORST_FIT);
    }

    protected WorstFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        Truck worstTruck;

        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            worstTruck = getWorstFitTruck(trucks, parcel);

            if (worstTruck != null) {
                executionStack.add(
                        String.format(
                                "---Added to truck with load (%d/%d)",
                                worstTruck.getCurrentLoad(),
                                loadLimit));
                worstTruck.addParcel(parcel);
            }
            else {
                executionStack.add("---Added to new truck");

                worstTruck = factory.make();
                worstTruck.addParcel(parcel);
                trucks.add(worstTruck);
            }
        }
    }

    public Truck getWorstFitTruck(LinkedList<Truck> trucks, Parcel parcel) {
        int parcelWeight = parcel.getWeight();

        Truck worstTruck = null; // Wrost fit truck
        int maxLoad = Integer.MIN_VALUE;    // Minimum load after adding parcel

        int currentRemainingLoad;  // Variable to store current truck's remaining load after adding parcel

        for (Truck truck : trucks) {
            currentRemainingLoad = truck.getRemainingLoad() - parcelWeight;

            // Only do if truck load can fit parcel
            if (currentRemainingLoad >= 0) {

                // If load after parcel is minimum, set as best
                if (currentRemainingLoad > maxLoad) {
                    worstTruck = truck;
                    maxLoad = currentRemainingLoad;
                }
            }
        }

        return worstTruck;
    }

}
