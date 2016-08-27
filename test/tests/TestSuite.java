package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    tests.TestTruckFactory.class,
    tests.TestAlgorithms.class,
    tests.TestDataGenerator.class
})
public class TestSuite {

}
