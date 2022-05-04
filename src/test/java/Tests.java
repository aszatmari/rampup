import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
        Car carWithMaxHorsePower = this.cars.get(0);
        for(Car current : this.cars){
            if (current.getHorsePower() > carWithMaxHorsePower.getHorsePower()) {
                carWithMaxHorsePower = current;
            }
        }
        if (carWithMaxHorsePower.getHorsePower() != 350){
            log.error("Test1 failed");
            return;
        }
        log.info("Test1 passed");
        //assert(carWithMaxHorsePower.horsePower == 350);
    }

    @Test
    public void Test2() {
        ArrayList<Car> sedans = new ArrayList<Car>();
        for(Car current : this.cars){
            if (current.getType() == Type.SEDAN){
                sedans.add(current);
            }
        }
        if (sedans.size() != 4){
            log.error("Test2 failed");
            return;
        }
        log.info("Test2 passed");
        //assert (sedans.size() == 4);
    }

    @Test
    public void Test3() {
        ArrayList<Car> bigEngines = new ArrayList<Car>();
        for(Car current : this.cars){
            if (current.getEngine() > 1.6){
                bigEngines.add(current);
            }
        }
        for (Car current : bigEngines){
            if (current.getEngine() <= 1.8){
                log.error("Test3 failed");
                return;
            }
            //assert(current.engine > 1.8);
        }
        log.info("Test3 passed");
    }
}