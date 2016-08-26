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

        Truck firstTruck;
        LinkedList<Truck> nonFullTrucks = new LinkedList<>();

        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());
            firstTruck = getFirstFitTruck(nonFullTrucks, parcel);

            if (firstTruck != null) {
                executionStack.add(
                        String.format(
                                "---Added to truck with load (%fd/%d)",
                                firstTruck.getCurrentLoad(),
                                loadLimit));
                firstTruck.addParcel(parcel);
                if (firstTruck.isFull()) {
                    nonFullTrucks.remove(firstTruck);
                }
            }
            else {
                executionStack.add("---Added to new truck");

                firstTruck = factory.make();
                firstTruck.addParcel(parcel);
                trucks.add(firstTruck);
                if (!firstTruck.isFull()) {
                    nonFullTrucks.add(firstTruck);
                }
            }
        }
    }

    public Truck getFirstFitTruck(LinkedList<Truck> trucks, Parcel parcel) {
        for (Truck truck : trucks) {
            if (truck.canFit(parcel)) {
                return truck;
            }
        }
        return null;
    }

}
