package algorithms;

import data.Parcel;
import data.Truck;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class EnhancedWorstFitAlgorithm extends Algorithm {

    public EnhancedWorstFitAlgorithm() {
        super(Factory.ENHANCED_WORST_FIT);
    }
    
    protected EnhancedWorstFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        // Create a map that stores stack of truck based on their remaining load
        Map<Integer, Queue<Truck>> truckRemainingLoadMap = new HashMap<>();
        for (int i = 1; i < loadLimit; i++) {
            truckRemainingLoadMap.put(i, new LinkedList<>());
        }

        Queue<Truck> currentQueue;
        Truck worstTruck;
        int parcelWeight;

        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            worstTruck = null;
            parcelWeight = parcel.getWeight();
            for (int i = loadLimit - 1; i >= parcelWeight; i--) {
                currentQueue = truckRemainingLoadMap.get(i);

                // If the queue is not empty, use the first truck
                if (currentQueue.size() > 0) {
                    worstTruck = currentQueue.remove();
                    executionStack.add(
                            String.format(
                                    "---Added to truck with load (%d/%d)",
                                    worstTruck.getCurrentLoad(),
                                    loadLimit));
                    worstTruck.addParcel(parcel);
                    break;
                }
            }

            // If no truck was suitable, create new one
            if (worstTruck == null) {
                executionStack.add("---Added to new truck");

                worstTruck = factory.make();
                worstTruck.addParcel(parcel);
                trucks.add(worstTruck);
            }

            // Update the location of best truck
            int newRemainingLoad = worstTruck.getRemainingLoad();
            if (newRemainingLoad > 0) {
                truckRemainingLoadMap.get(newRemainingLoad).add(worstTruck);
            }
        }
    }

}