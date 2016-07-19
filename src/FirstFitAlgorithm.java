
import java.util.LinkedList;

public class FirstFitAlgorithm extends Algorithm {

    public FirstFitAlgorithm() {
        super(Factory.FIRST_FIT);
    }

    @Override
    public void execute(Data data, LinkedList<String> executionStack, LinkedList<Truck> trucks, Truck.Factory factory) {
        Truck newTruck = null;

        // Parcel label
        ParcelLoop:
        for (Parcel parcel : data.getParcels()) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            // Truck label
            TruckLoop:
            for (Truck truck : trucks) {
                if (truck.canFit(parcel)) {
                    truck.addParcel(parcel);
                    executionStack.add(
                            String.format(
                                    "\tAdded to truck with load (%d/%d)",
                                    truck.getCurrentLoad(),
                                    factory.getLoadLimit()));

                    // Continue parcel loop
                    continue ParcelLoop;
                }
            }

            newTruck = factory.make();
            newTruck.addParcel(parcel);
            trucks.add(newTruck);

            executionStack.add("\tAdded to new truck with load (%d/%d)");
        }
    }

}
