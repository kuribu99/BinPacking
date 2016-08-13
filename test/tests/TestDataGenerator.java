/*
 */
package tests;

import data.Data;
import data.Parcel;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kong My
 */
public class TestDataGenerator {

    @Test
    public void TestNextLimitOneGaussian() {
        double output;

        for (int i = 0; i < 10000; i++) {
            output = Data.Generator.nextLimitOneGaussian();
            if (output < -1f || output > 1f) {
                fail("limitOne fail to limit value: " + output);
            }
        }
    }

    @Test
    public void TestGenerate() {
        Random rand = new Random();
        Data data;

        // Test every data type
        for (int dataType = 5; dataType <= 5; dataType++) {

            // Generate random load limit
            for (int loadLimit = 10; loadLimit <= 5000; loadLimit += rand.nextInt(25) + 1) {

                data = Data.Generator.generate(dataType, loadLimit, 1000);

                for (Parcel p : data.getParcels()) {
                    if (p.getWeight() <= 0 || p.getWeight() > loadLimit) {
                        fail("Invalid parcel weight: " + p.getWeight()
                                + " when generating data type = " + dataType
                                + " and load limit = " + loadLimit);
                    }
                }

            }

        }
    }

}
