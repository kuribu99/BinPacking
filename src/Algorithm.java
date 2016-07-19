
import java.util.LinkedList;

public abstract class Algorithm {

    public static class Factory {

        // Defined algorithms
        public static final String FIRST_FIT = "First Fit";
        public static final String BEST_FIT = "Best Fit";
        public static final String FIRST_FIT_DECR = "First Fit Decreasing";
        public static final String BEST_FIT_DECR = "Best Fit Decreasing";

        protected Factory() {

        }

        public static Algorithm make(String algorithmName) {
            switch (algorithmName) {
                case FIRST_FIT:
                    return new FirstFitAlgorithm();

                case BEST_FIT:
                    return new BestFitAlgorithm();

                case FIRST_FIT_DECR:
                    return new FirstFitDecrAlgorithm();

                case BEST_FIT_DECR:
                    return new BestFitDecrAlgorithm();

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

        // Execute based on child class implementation
        execute(data, executionStack, trucks, factory);

        return new Result(
                algorithmName,
                data.getTruckLoadLimit(),
                executionStack.toArray(new String[]{}),
                trucks.toArray(new Truck[]{}));
    }

    public abstract void execute(Data data, LinkedList<String> executionStack,
            LinkedList<Truck> trucks, Truck.Factory factory);

    public static class Result {

        private final String algorithmName;
        private final int loadLimit;
        private final String[] executionStack;
        private final Truck[] trucks;

        protected Result(String algorithmName, int loadLimit, String[] executionStacks, Truck[] trucks) {
            this.algorithmName = algorithmName;
            this.loadLimit = loadLimit;
            this.executionStack = executionStacks;
            this.trucks = trucks;
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

        public String getResultString() {
            return getResultString(false, false);
        }

        public String getResultString(boolean withTrucks, boolean withExecutionStack) {
            StringBuilder builder = new StringBuilder();

            // Summary
            builder.append("Algorithm used: ")
                    .append(algorithmName)
                    .append("\n");
            builder.append("Load limit of trucks needed: ")
                    .append(loadLimit)
                    .append("\n");
            builder.append("Number of trucks needed: ")
                    .append(trucks.length)
                    .append("\n");

            // Show trucks if needed
            if (withTrucks) {
                builder.append("Details of each truck:\n")
                        .append(getTrucksAsString());
            }

            // Show exection stack if needed
            if (withExecutionStack) {
                builder.append("Execution Stack:\n")
                        .append(getExecutionStackAsString());
            }

            return builder.toString();
        }

        public String getExecutionStackAsString() {
            StringBuilder builder = new StringBuilder();

            for (String stack : executionStack) {
                builder.append("> ")
                        .append(stack.replace("\t", "    "))
                        .append("\n");
            }

            return builder.toString();
        }

        public String getTrucksAsString() {
            StringBuilder builder = new StringBuilder();

            for (Truck truck : trucks) {
                builder.append("Truck => ");

                // Show parcels
                for (Parcel parcel : truck.getParcels()) {
                    builder.append("[")
                            .append(parcel.getWeight())
                            .append("] ");
                }
                builder.append("\n");
            }

            return builder.toString();
        }

    }

}
