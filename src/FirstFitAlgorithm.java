
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

        Truck newTruck = null;

        // Parcel label
        ParcelLoop:
        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            // Truck label
            TruckLoop:
            for (Truck truck : trucks) {
                if (truck.canFit(parcel)) {
                    executionStack.add(
                            String.format(
                                    "\tAdded to truck with load (%d/%d)",
                                    truck.getCurrentLoad(),
                                    loadLimit));
                    truck.addParcel(parcel);

                    // Continue parcel loop
                    continue ParcelLoop;
                }
            }

            executionStack.add("\tAdded to new truck");

            newTruck = factory.make();
            newTruck.addParcel(parcel);
            trucks.add(newTruck);
        }
    }

}
