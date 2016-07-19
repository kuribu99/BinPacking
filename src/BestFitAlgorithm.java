
import java.util.LinkedList;

public class BestFitAlgorithm extends Algorithm {

    public BestFitAlgorithm() {
        super(Factory.BEST_FIT);
    }

    protected BestFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
