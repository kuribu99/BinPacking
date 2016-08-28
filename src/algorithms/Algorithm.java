package algorithms;

import data.Data;
import data.Parcel;
import data.Truck;
import java.util.LinkedList;

public abstract class Algorithm {

    public static class Factory {

        // Defined algorithms
        public static final String FIRST_FIT = "First Fit";
        public static final String BEST_FIT = "Best Fit";
        public static final String WORST_FIT = "Worst Fit";
        public static final String FIRST_FIT_DECR = "First Fit Decreasing";
        public static final String BEST_FIT_DECR = "Best Fit Decreasing";
        public static final String WORST_FIT_DECR = "Worst Fit Decreasing";

        protected Factory() {

        }

		// Select algorithms
        public static Algorithm make(String algorithmName) {
            switch (algorithmName) {
                case FIRST_FIT:
                    return new FirstFitAlgorithm();

                case BEST_FIT:
                    return new BestFitAlgorithm();

                case WORST_FIT:
                    return new WorstFitAlgorithm();

                case FIRST_FIT_DECR:
                    return new FirstFitDecrAlgorithm();

                case BEST_FIT_DECR:
                    return new BestFitDecrAlgorithm();

                case WORST_FIT_DECR:
                    return new WorstFitDecrAlgorithm();

                default:
                    return null;
            }
        }
    }

    // Fields
    protected final String algorithmName;

    public Algorithm(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

	// Execute data
    public Result execute(Data data) {
        LinkedList<String> executionStack = new LinkedList<>();
        LinkedList<Truck> trucks = new LinkedList<>();
        Truck.Factory factory = new Truck.Factory(data.getTruckLoadLimit());

        long startTime = System.currentTimeMillis();

        // Execute based on child class implementation
        execute(
                data.getTruckLoadLimit(),
                data.getParcels(),
                executionStack,
                trucks,
                factory);

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        return new Result(
                algorithmName,
                data.getTruckLoadLimit(),
                executionStack.toArray(new String[]{}),
                trucks.toArray(new Truck[]{}),
                timeTaken);
    }

	// Abstract method of execute data
    public abstract void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory);

    public static class Result {

		// Defined data to be displayed in the result 
        private final String algorithmName;
        private final int loadLimit;
        private final String[] executionStack;
        private final Truck[] trucks;
        private final long timeTaken;

		// Initialize data
        protected Result(String algorithmName, int loadLimit, String[] executionStacks, Truck[] trucks, long timeTaken) {
            this.algorithmName = algorithmName;
            this.loadLimit = loadLimit;
            this.executionStack = executionStacks;
            this.trucks = trucks;
            this.timeTaken = timeTaken;
        }

		// Get algorithm name		
        public String getAlgorithmName() {
            return algorithmName;
        }

		// Get load limit of truck		
        public int getLoadLimit() {
            return loadLimit;
        }

		// Get execution stack		
        public String[] getExecutionStack() {
            return executionStack;
        }

		// Get truck		
        public Truck[] getTrucks() {
            return trucks;
        }

		// Get time taken for execution	
        public long getTimeTaken() {
            return timeTaken;
        }

    }

}
