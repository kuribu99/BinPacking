
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

    public abstract void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory);

    public static class Result {

        private final String algorithmName;
        private final int loadLimit;
        private final String[] executionStack;
        private final Truck[] trucks;
        private final long timeTaken;

        protected Result(String algorithmName, int loadLimit, String[] executionStacks, Truck[] trucks, long timeTaken) {
            this.algorithmName = algorithmName;
            this.loadLimit = loadLimit;
            this.executionStack = executionStacks;
            this.trucks = trucks;
            this.timeTaken = timeTaken;
        }

        public String getAlgorithmName() {
            return algorithmName;
        }

        public int getLoadLimit() {
            return loadLimit;
        }

        public String[] getExecutionStack() {
            return executionStack;
        }

        public Truck[] getTrucks() {
            return trucks;
        }

        public long getTimeTaken() {
            return timeTaken;
        }

    }

}
