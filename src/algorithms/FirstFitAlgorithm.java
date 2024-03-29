package algorithms;

import data.Truck;
import data.Parcel;
import java.util.LinkedList;

public class FirstFitAlgorithm extends Algorithm {

    public FirstFitAlgorithm() {
        super(Factory.FIRST_FIT);
    }

    protected FirstFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        // Variables that will be reused in loop
        Truck firstTruck;

        // Stores truck that are not full in another list
        LinkedList<Truck> nonFullTrucks = new LinkedList<>();

        // Create a loop to move parcels into trucks		
        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            // Get first fit truck from helper method
            firstTruck = getFirstFitTruck(nonFullTrucks, parcel);

            // If there are suitable truck, add to the truck
            if (firstTruck != null) {
                executionStack.add(
                        String.format(
                                "---Added to truck with load (%d/%d)",
                                firstTruck.getCurrentLoad(),
                                loadLimit));
                
                firstTruck.addParcel(parcel);
                
                // Remove from list if it is full
                if (firstTruck.isFull()) {
                    nonFullTrucks.remove(firstTruck);
                }
            }
            else {
                executionStack.add("---Added to new truck");

                // Create a new truck to add parcel
                firstTruck = factory.make();
                firstTruck.addParcel(parcel);
                trucks.add(firstTruck);
                
                // Add to the list if it is not full
                if (!firstTruck.isFull()) {
                    nonFullTrucks.add(firstTruck);
                }
            }
        }
    }

    // Loop to find a truck that fits
    public Truck getFirstFitTruck(LinkedList<Truck> trucks, Parcel parcel) {
        for (Truck truck : trucks) {
            if (truck.canFit(parcel)) {
                return truck;
            }
        }
        return null;
    }

}
