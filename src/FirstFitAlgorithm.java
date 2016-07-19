
import java.util.LinkedList;

public class FirstFitAlgorithm extends Algorithm {

    public FirstFitAlgorithm() {
        super(Factory.FIRST_FIT);
    }

    @Override
    public Result execute(Data data) {
        LinkedList<String> executionStack = new LinkedList<>();
        LinkedList<Truck> trucks = new LinkedList<>();
        Truck.Factory factory = new Truck.Factory(data.getTruckLoadLimit());

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

        return new Result(algorithmName,
                executionStack.toArray(new String[]{}),
                trucks.toArray(new Truck[]{}));
    }

}
