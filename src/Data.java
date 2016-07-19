
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
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

    public static Data generate(int loadLimit, int numberParcels) {
        Random rand = new Random();
        Data data = new Data();
        data.truckLoadLimit = loadLimit;

        for (int i = 0; i < numberParcels; i++) {
            data.parcels.add(new Parcel(rand.nextInt(loadLimit) + 1));
        }

        data.success = true;

        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public LinkedList<Parcel> getParcels() {
        return parcels;
    }

    protected int getTruckLoadLimit() {
        return truckLoadLimit;
    }

}
