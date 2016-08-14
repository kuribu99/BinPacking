
import algorithms.Algorithm;
import data.Data;
import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 */
/**
 *
 * @author Kong My
 */
public class AlgorithmExecutor {

    public static void main(String[] args) throws Exception {

        String[] algorithms = new String[]{
            Algorithm.Factory.FIRST_FIT,
            Algorithm.Factory.BEST_FIT,
            Algorithm.Factory.WORST_FIT,
            Algorithm.Factory.FIRST_FIT_DECR,
            Algorithm.Factory.BEST_FIT_DECR,
            Algorithm.Factory.WORST_FIT_DECR
        };

        String[] dataTypes = new String[]{
            Data.Generator.DATA_BALANCED,
            Data.Generator.DATA_LOW,
            Data.Generator.DATA_HIGH,
            Data.Generator.DATA_CENTER,
            Data.Generator.DATA_EDGE
        };

        int[] parcelNumbers = new int[]{
            1000,
            10000,
            // Warning: here onwards take a lot of time
            50000,
            100000
        };

        // Number of repetition to get average
        int numberOfRepetition = 100;

        // Create file writer to write as CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Output.csv"))) {
            // Write header first
            writer.write(getCsvHeader());
            writer.newLine();

            // Variables to be used later
            Algorithm algo;
            Algorithm.Result result;

            System.out.println("--- Starting all execution ---");
            for (String algorithm : algorithms) {

                // Create the algorithm to be used
                algo = Algorithm.Factory.make(algorithm);

                for (String dataType : dataTypes) {
                    for (int parcelNumber : parcelNumbers) {
                        long avgTime = 0;
                        int avgTruck = 0;

                        // Repeat to get average
                        for (int i = 0; i < numberOfRepetition; i++) {

                            // Execute the algorithm
                            result = algo.execute(Data.Generator.generate(dataType, 10, parcelNumber));

                            // Accumulate
                            avgTime += result.getTimeTaken();
                            avgTruck += result.getTrucks().length;
                        }

                        // Get average
                        avgTime /= numberOfRepetition;
                        avgTruck /= numberOfRepetition;

                        writer.write(toCsvRow(algorithm, dataType, parcelNumber, avgTime, avgTruck));
                        writer.newLine();
                    }
                }
                System.out.println("...Done with " + algorithm);
            }

            writer.flush();
        }
        System.out.println("--- Completed all execution ---");
    }

    private static String getCsvHeader() {
        String[] strings = new String[]{
            "Algorithm name",
            "Data distribution",
            "Number of parcels",
            "Average time taken (ms)",
            "Average number of truck used"
        };

        return String.join(",", strings);
    }

    private static String toCsvRow(String algorithm, String dataType, int parcelNumber, long avgTime, int avgTruck) {
        String[] strings = new String[]{
            algorithm,
            dataType,
            String.valueOf(parcelNumber),
            String.valueOf(avgTime),
            String.valueOf(avgTruck)
        };

        return String.join(",", strings);
    }

}
