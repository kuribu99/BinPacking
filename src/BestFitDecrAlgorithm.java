
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
        
        LinkedList<Parcel> duplicateList = new LinkedList<>(parcels);
        Collections.sort(duplicateList);
        super.execute(loadLimit, duplicateList, executionStack, trucks, factory);
    }

}
