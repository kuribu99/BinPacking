package algorithms;

import data.Parcel;
import data.Truck;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class EnhancedBestFitAlgorithm extends Algorithm {

    public EnhancedBestFitAlgorithm() {
        super(Factory.ENHANCED_BEST_FIT);
    }
    
    protected EnhancedBestFitAlgorithm(String algorithmName) {
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
        Truck bestTruck;

        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            bestTruck = null;
            
            for (int i = parcel.getWeight(); i < loadLimit; i++) {
                currentQueue = truckRemainingLoadMap.get(i);

                // If the queue is not empty, use the first truck
                if (currentQueue.size() > 0) {
                    bestTruck = currentQueue.remove();
                    executionStack.add(
                            String.format(
                                    "---Added to truck with load (%d/%d)",
                                    bestTruck.getCurrentLoad(),
                                    loadLimit));
                    bestTruck.addParcel(parcel);
                    break;
                }
            }

            // If no truck was suitable, create new one
            if (bestTruck == null) {
                executionStack.add("---Added to new truck");

                bestTruck = factory.make();
                bestTruck.addParcel(parcel);
                trucks.add(bestTruck);
            }

            // Update the location of best truck
            int newRemainingLoad = bestTruck.getRemainingLoad();
            if (newRemainingLoad > 0) {
                truckRemainingLoadMap.get(newRemainingLoad).add(bestTruck);
            }
        }
    }

}
