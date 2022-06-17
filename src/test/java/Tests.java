import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class Tests {
    private List<Car> cars;

    @BeforeEach
    public void Setup() {

        Path p = Paths.get("src/main/assets/Testdata.json");
        JsonParser parser = new JsonParser(p.toAbsolutePath());
        this.cars = parser.parse();
    }

    @Test
    public void Test1() {
        log.info("Start Test1");
        Car carWithMaxHorsePower = cars.get(0);
        for (Car current : cars) {
            if (current.getHorsePower() > carWithMaxHorsePower.getHorsePower()) {
                carWithMaxHorsePower = current;
            }
        }
        assertEquals(carWithMaxHorsePower.getHorsePower(), 350);
        log.info("Test1 passed");
    }
    
    @Test
    public void Test2() {
        log.info("Start Test2");
        ArrayList<Car> sedans = new ArrayList<Car>();
        for (Car current : cars) {
            if (current.getType() == Type.SEDAN) {
                sedans.add(current);
            }
        }
        assertEquals(sedans.size(), 4);
        log.info("Test2 passed");
    }

    @Test
    public void Test3() {
        log.info("Start Test3");
        ArrayList<Car> bigEngines = new ArrayList<Car>();
        for (Car current : cars) {
            if (current.getEngine() > 1.6) {
                bigEngines.add(current);
            }
        }
        for (Car current : bigEngines) {
            assertTrue(current.getEngine() > 1.8);
        }
        log.info("Test3 passed");
    }
}