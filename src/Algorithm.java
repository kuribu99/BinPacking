
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

    public abstract Result execute(Data data);

    public static class Result {

        private final String algorithmName;
        private final String[] executionStack;
        private final Truck[] trucks;

        protected Result(String algorithmName, String[] executionStacks, Truck[] trucks) {
            this.algorithmName = algorithmName;
            this.executionStack = executionStacks;
            this.trucks = trucks;
        }

        public String[] getExecutionStack() {
            return executionStack;
        }

        public Truck[] getTrucks() {
            return trucks;
        }

        public String getResultString() {
            StringBuilder builder = new StringBuilder();

            // Summary
            builder.append("Algorithm used: ")
                    .append(algorithmName)
                    .append("\n");
            builder.append("Number of trucks needed: ")
                    .append(trucks.length)
                    .append("\n");

            // Show trucks
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
