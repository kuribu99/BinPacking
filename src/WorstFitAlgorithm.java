
import java.util.LinkedList;

public class WorstFitAlgorithm extends Algorithm {

    public WorstFitAlgorithm() {
        super(Algorithm.Factory.WORST_FIT);
    }

    protected WorstFitAlgorithm(String algorithmName) {
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
