import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({   TestVolvo.class,
                        TestSaab.class,
                        TestVehicle.class,
                        TestMove.class})
public class VehicleTestSuite {
}
