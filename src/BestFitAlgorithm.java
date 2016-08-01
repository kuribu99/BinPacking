
import java.util.LinkedList;

public class BestFitAlgorithm extends Algorithm {

    public BestFitAlgorithm() {
        super(Factory.BEST_FIT);
    }

    protected BestFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    public Truck getBestFitTruck(LinkedList<Truck> trucks, Parcel parcel) {
        int parcelWeight = parcel.getWeight();

        Truck bestTruck = null; // Best fit truck
        int minLoad = Integer.MAX_VALUE;    // Minimum load after adding parcel

        int currentRemainingLoad;  // Variable to store current truck's remaining load after adding parcel

        for (Truck truck : trucks) {
            currentRemainingLoad = truck.getRemainingLoad() - parcelWeight;

            // Directly end if best fit
            if (currentRemainingLoad == 0) {
                return truck;

            } // Only do if truck load can fit parcel
            else if (currentRemainingLoad > 0) {

                // If load after parcel is minimum, set as best
                if (currentRemainingLoad < minLoad) {
                    bestTruck = truck;
                    minLoad = currentRemainingLoad;
                }
            }
        }

        return bestTruck;
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        Truck bestTruck;

        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            bestTruck = getBestFitTruck(trucks, parcel);

            if (bestTruck != null) {
                executionStack.add(
                        String.format(
                                "\tAdded to truck with load (%d/%d)",
                                bestTruck.getCurrentLoad(),
                                loadLimit));
                bestTruck.addParcel(parcel);
            } else {
                executionStack.add("\tAdded to new truck");

                bestTruck = factory.make();
                bestTruck.addParcel(parcel);
                trucks.add(bestTruck);
            }
        }
    }

}
