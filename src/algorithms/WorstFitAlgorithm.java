package algorithms;

import data.Parcel;
import data.Truck;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WorstFitAlgorithm extends Algorithm {

    public WorstFitAlgorithm() {
        super(Factory.WORST_FIT);
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

        // Create a map that stores stack of truck based on their remaining load
        // Only stores truck with remaining load of [1, loadLimit - 1]
        Map<Integer, Queue<Truck>> truckRemainingLoadMap = new HashMap<>();
        for (int i = 1; i < loadLimit; i++) {
            truckRemainingLoadMap.put(i, new LinkedList<>());
        }

        // Variables that will be reused in loop		
        Queue<Truck> currentQueue;
        Truck worstTruck;
        int parcelWeight;

        // Create a loop to move parcels into trucks		
        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            worstTruck = null;
            parcelWeight = parcel.getWeight();

            // Create a loop to insert parcels into a queue based on weight of parcel
            // Directly start maximum remaining space (worst fit) and end with truck load which can fit parcel	
            for (int i = loadLimit - 1; i >= parcelWeight; i--) {
                currentQueue = truckRemainingLoadMap.get(i);

                // If the queue is not empty, use the first truck
                if (!currentQueue.isEmpty()) {
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

            // Update the location of the truck
            int newRemainingLoad = worstTruck.getRemainingLoad();
            if (newRemainingLoad > 0) {
                truckRemainingLoadMap.get(newRemainingLoad).add(worstTruck);
            }
        }
    }

}
