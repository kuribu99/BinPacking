/*
 */
package algorithms;

import data.Parcel;
import data.Truck;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Kong My
 */
public class EnhancedWorstFitDecrAlgorithm extends EnhancedWorstFitAlgorithm {

    public EnhancedWorstFitDecrAlgorithm() {
        super(Factory.ENHANCED_WORST_FIT_DECR);
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
