package algorithms;

import data.Truck;
import data.Parcel;
import java.util.Collections;
import java.util.LinkedList;

public class FirstFitDecrAlgorithm extends FirstFitAlgorithm {

    public FirstFitDecrAlgorithm() {
        super(Factory.FIRST_FIT_DECR);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        LinkedList<Parcel> duplicateList = new LinkedList<>(parcels);
        Collections.sort(duplicateList);
        super.execute(loadLimit, duplicateList, executionStack, trucks, factory);
    }

}
