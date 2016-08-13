package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Data {

    private final LinkedList<Parcel> parcels;
    private int truckLoadLimit;
    private boolean success;

    protected Data() {
        parcels = new LinkedList<>();
        truckLoadLimit = 0;
        success = false;
    }

    public static Data read(String fileName) throws FileNotFoundException, FileFormatException {
        Data data = new Data();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.useDelimiter("[\\D]+");
            if (!scanner.hasNext()) {
                throw new FileFormatException();
            }

            data.truckLoadLimit = Integer.parseInt(scanner.next());

            int weight;
            while (scanner.hasNext()) {
                weight = Integer.parseInt(scanner.next());

                // Invalid data
                if (weight > data.truckLoadLimit) {
                    throw new FileFormatException();
                }

                data.parcels.add(new Parcel(weight));
            }

            data.success = true;
        }

        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public LinkedList<Parcel> getParcels() {
        return parcels;
    }

    public int getTruckLoadLimit() {
        return truckLoadLimit;
    }

    public static class Generator {

        private static final Random rand = new Random();

        public static final int DATA_BALANCED = 1;
        public static final int DATA_LOW = 2;
        public static final int DATA_HIGH = 3;
        public static final int DATA_CENTER = 4;
        public static final int DATA_EDGE = 5;

        public static double nextLimitOneGaussian() {
            double value;

            do {
                value = rand.nextGaussian() / 2;

            } while (value < -1f || value > 1f);

            return value;
        }

        public static double nextAbsLimitOneGaussian() {
            return Math.abs(nextLimitOneGaussian());
        }

        public static List<Integer> getDistributedData(int dataType, int maxValue, int count) {
            List<Integer> data = new LinkedList<>();
            int max = maxValue - 1; // To reduce range from [1, maxValue] to [0, maxValue - 1]
            double mid = 0.5 * max; // Reference to midpoint

            switch (dataType) {
                case DATA_BALANCED:
                    for (int i = 0; i < count; i++) {
                        // nextInt is [0, maxValue), so we +1 to make it [1, maxValue]
                        data.add(1 + rand.nextInt(maxValue));
                    }
                    break;

                case DATA_LOW:
                    for (int i = 0; i < count; i++) {
                        // Absolute normal distribution returns [0, 1]
                        // So we multiply by max to distribute it to [0, max]
                        // And +1 to make it [1, maxValue]
                        data.add(1 + ((int) (max * nextAbsLimitOneGaussian())));
                    }
                    break;

                case DATA_HIGH:
                    for (int i = 0; i < count; i++) {
                        // Absolute normal distribution returns [0, 1]
                        // Use 1-[0, 1] to inverse the distribution
                        // Then we multiply by max to distribute it to [0, max]
                        // And +1 to make it [1, maxValue]
                        data.add(1 + ((int) (max * (1 - nextAbsLimitOneGaussian()))));
                    }
                    break;

                case DATA_CENTER:
                    for (int i = 0; i < count; i++) {
                        // Directly use normal distribution with Mean = mid and SD = mid
                        data.add(1 + (int) (mid + mid * nextLimitOneGaussian()));
                    }
                    break;

                case DATA_EDGE:
                    for (int i = 0; i < count; i++) {
                        // Normal distribution returns [0, 1]
                        // Use 1-[0, 1] to inverse the distribution
                        // Then use inversed normal distribution with Mean = mid and SD = mid
                        data.add(1 + (int) (mid - mid * nextLimitOneGaussian()));
                    }
                    break;

            }

            return data;
        }

        public static Data generate(int dataType, int loadLimit, int numberParcels) {
            Data data = new Data();
            data.truckLoadLimit = loadLimit;

            List<Integer> distributedData = getDistributedData(dataType, loadLimit, numberParcels);

            for (int i : distributedData) {
                data.parcels.add(new Parcel(i));
            }

            data.success = true;

            return data;
        }

    }
}
