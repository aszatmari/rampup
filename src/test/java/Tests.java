import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class Tests {
    private List<Car> cars;

    @BeforeEach
    public void Setup() {
        JsonParser parser = new JsonParser("C:\\Users\\aszatmar\\Documents\\GIT\\CarTest\\src\\main\\assets\\TestData.json");
        this.cars = parser.parse();
    }

    @Test
    public void Test1() {
        log.info("Start Test1");
        Car carWithMaxHorsePower = this.cars.get(0);
        for(Car current : this.cars){
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
        for(Car current : this.cars){
            if (current.getType() == Type.SEDAN){
                sedans.add(current);
            }
        }
        assertEquals (sedans.size(), 4);
        log.info("Test2 passed");
    }

    @Test
    public void Test3() {
        log.info("Start Test3");
        ArrayList<Car> bigEngines = new ArrayList<Car>();
        for(Car current : this.cars){
            if (current.getEngine() > 1.6){
                bigEngines.add(current);
            }
        }
        for (Car current : bigEngines){
            assertTrue (current.getEngine() > 1.8);
        }
        log.info("Test3 passed");
    }
}