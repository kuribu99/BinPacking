
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

            // Truck label
            TruckLoop:
            for (Truck truck : trucks) {
                if (truck.canFit(parcel)) {
                    truck.addParcel(parcel);

                    // Continue parcel loop
                    continue ParcelLoop;
                }
            }

            newTruck = factory.make();
            newTruck.addParcel(parcel);
            trucks.add(newTruck);
        }
    }

}
