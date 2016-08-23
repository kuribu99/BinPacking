/*
 */
package tests;

import algorithms.Algorithm;
import algorithms.Algorithm.Result;
import algorithms.BestFitAlgorithm;
import algorithms.BestFitDecrAlgorithm;
import algorithms.FirstFitAlgorithm;
import algorithms.FirstFitDecrAlgorithm;
import algorithms.WorstFitAlgorithm;
import algorithms.WorstFitDecrAlgorithm;
import data.Data;
import data.FileFormatException;
import data.Truck;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;

/**
 *
 * @author Kong My
 */
public class TestAlgorithms {

    public static int testCaseNumbers = 3;

    @Test
    public void TestFirstFit()
            throws FileNotFoundException, FileFormatException {

        for (int n = 1; n <= testCaseNumbers; n++) {
            String testCaseFileName = String.format("test-cases/#%d.txt", n);
            String expectedResultFileName = String.format("test-cases/#%d-FirstFit.txt", n);

            Algorithm algorithm = new FirstFitAlgorithm();
            runTestCase(testCaseFileName, expectedResultFileName, algorithm);
        }
    }

    @Test
    public void TestBestFit()
            throws FileNotFoundException, FileFormatException {

        for (int n = 1; n <= testCaseNumbers; n++) {
            String testCaseFileName = String.format("test-cases/#%d.txt", n);
            String expectedResultFileName = String.format("test-cases/#%d-BestFit.txt", n);

            Algorithm algorithm = new BestFitAlgorithm();
            runTestCase(testCaseFileName, expectedResultFileName, algorithm);
        }
    }

    @Test
    public void TestWorstFit()
            throws FileNotFoundException, FileFormatException {

        for (int n = 1; n <= testCaseNumbers; n++) {
            String testCaseFileName = String.format("test-cases/#%d.txt", n);
            String expectedResultFileName = String.format("test-cases/#%d-WorstFit.txt", n);

            Algorithm algorithm = new WorstFitAlgorithm();
            runTestCase(testCaseFileName, expectedResultFileName, algorithm);
        }
    }

    @Test
    public void TestFirstFitDecr()
            throws FileNotFoundException, FileFormatException {

        for (int n = 1; n <= testCaseNumbers; n++) {
            String testCaseFileName = String.format("test-cases/#%d.txt", n);
            String expectedResultFileName = String.format("test-cases/#%d-FirstFitDecr.txt", n);

            Algorithm algorithm = new FirstFitDecrAlgorithm();
            runTestCase(testCaseFileName, expectedResultFileName, algorithm);
        }
    }

    @Test
    public void TestBestFitDecr()
            throws FileNotFoundException, FileFormatException {

        for (int n = 1; n <= testCaseNumbers; n++) {
            String testCaseFileName = String.format("test-cases/#%d.txt", n);
            String expectedResultFileName = String.format("test-cases/#%d-BestFitDecr.txt", n);

            Algorithm algorithm = new BestFitDecrAlgorithm();
            runTestCase(testCaseFileName, expectedResultFileName, algorithm);
        }
    }

    @Test
    public void TestWorstFitDecr()
            throws FileNotFoundException, FileFormatException {

        for (int n = 1; n <= testCaseNumbers; n++) {
            String testCaseFileName = String.format("test-cases/#%d.txt", n);
            String expectedResultFileName = String.format("test-cases/#%d-WorstFitDecr.txt", n);

            Algorithm algorithm = new WorstFitDecrAlgorithm();
            runTestCase(testCaseFileName, expectedResultFileName, algorithm);
        }
    }

    
    public static void runTestCase(String testCaseFileName, String expectedResultFileName, Algorithm algorithm)
            throws FileNotFoundException, FileFormatException {

        Data data = Data.read(testCaseFileName);
        Result result = algorithm.execute(data);
        LinkedList<LinkedList<Integer>> expectedResults = readExpectedResultFromFile(expectedResultFileName);
        Truck[] trucks = result.getTrucks();

        assertEquals(algorithm.getAlgorithmName(), result.getAlgorithmName());
        assertEquals(data.getTruckLoadLimit(), result.getLoadLimit());
        assertEquals(expectedResults.size(), trucks.length);

        for (int i = 0; i < trucks.length; i++) {
            LinkedList<Integer> expectedParcels = expectedResults.get(i);
            Truck currentTruck = trucks[i];

            assertEquals(data.getTruckLoadLimit(), currentTruck.getLoadLimit());
            assertEquals(expectedParcels.size(), currentTruck.getParcels().size());

            for (int j = 0; j < currentTruck.getParcels().size(); j++) {
                assertEquals((int) expectedParcels.get(j), currentTruck.getParcels().get(j).getWeight());
            }
        }

    }

    private static LinkedList<LinkedList<Integer>> readExpectedResultFromFile(String expectedResultFileName)
            throws FileNotFoundException {

        LinkedList<LinkedList<Integer>> trucks = new LinkedList<>();
        try (Scanner fileScanner = new Scanner(new FileInputStream(expectedResultFileName))) {
            LinkedList<Integer> parcels;
            String[] splitLines;

            while (fileScanner.hasNextLine()) {
                parcels = new LinkedList<>();
                splitLines = fileScanner.nextLine().split("[\\D]+");

                for (String splits : splitLines) {
                    parcels.add(Integer.parseInt(splits));
                }
                trucks.add(parcels);
            }
        }

        return trucks;
    }

}
