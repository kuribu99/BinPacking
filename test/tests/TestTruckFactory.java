/*
 */
package tests;

import data.Truck;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kong My
 */
public class TestTruckFactory {

    @Test
    public void TestMake() {
        Random rand = new Random();
        Truck.Factory factory;
        Truck truck;

        for (int loadLimit = 1; loadLimit < 1000; loadLimit += rand.nextInt(25)) {
            factory = new Truck.Factory(loadLimit);
            truck = factory.make();

            assertEquals(0, truck.getCurrentLoad());
            assertEquals(0, truck.getParcels().size());
            assertEquals(loadLimit, factory.getLoadLimit());
            assertEquals(loadLimit, truck.getLoadLimit());
            assertEquals(loadLimit, truck.getRemainingLoad());
            assertFalse(truck.isFull());
        }
    }

}
