import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class Tests extends TestBase {

    @Test
    @Tag("REGRESSION")
    public void Test1() {
        log.info("Start Test1");
        iCar carWithMaxHorsePower = cars.get(0);
        for (iCar current : cars) {
            if (current.getHorsePower() > carWithMaxHorsePower.getHorsePower()) {
                carWithMaxHorsePower = current;
            }
        }
        assertEquals(carWithMaxHorsePower.getHorsePower(), 350);
        log.info("Test1 passed");
    }

    @Test
    @Tag("REGRESSION")
    public void Test2() {
        log.info("Start Test2");
        ArrayList<iCar> sedans = new ArrayList<iCar>();
        for (iCar current : cars) {
            if (current.getType() == Type.SEDAN) {
                sedans.add(current);
            }
        }
        assertEquals(sedans.size(), 4);
        log.info("Test2 passed");
    }

    @Test
    @Tag("REGRESSION")
    public void Test3() {
        log.info("Start Test3");
        ArrayList<iCar> bigEngines = new ArrayList<iCar>();
        for (iCar current : cars) {
            if (current.getEngine() > 1.6) {
                bigEngines.add(current);
            }
        }
        for (iCar current : bigEngines) {
            assertTrue(current.getEngine() > 1.8);
        }
        log.info("Test3 passed");
    }

    @Test
    @Tag("REGRESSION")
    public void Test4() {
        log.info("Start Test4");
        for (iCar current : cars) {
            if (current.getHorsePower() >= 200) {
                assertTrue(current instanceof LuxuryCar);
            }
        }
        log.info("Test4 passed");
    }
}