package algorithms;

import data.Truck;
import data.Parcel;
import java.util.Collections;
import java.util.LinkedList;

public class BestFitDecrAlgorithm extends BestFitAlgorithm {

    public BestFitDecrAlgorithm() {
        super(Factory.BEST_FIT_DECR);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        // Duplicate parcels
        LinkedList<Parcel> duplicateList = new LinkedList<>(parcels);
        
        // Sort parcels from largest to smallest weight
        Collections.sort(duplicateList);
        
        // Execute original algorithm using sorted parcels
        super.execute(loadLimit, duplicateList, executionStack, trucks, factory);
    }

}
