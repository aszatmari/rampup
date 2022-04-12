import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Tests {
    @Test
    public void Test1() {

        ArrayList<Car> c = TestData.load();
        Car carWithMaxHorsePower = c.get(0);
        for(Car current : c){
            if (current.horsePower > carWithMaxHorsePower.horsePower) {
                carWithMaxHorsePower = current;
            }
        }
        assert(carWithMaxHorsePower.horsePower == 350);
    }

    @Test
    public void Test2() {
        ArrayList<Car> c = TestData.load();
        ArrayList<Car> sedans = new ArrayList<Car>();
        for(Car current : c){
            if (current.type == Type.SEDAN){
                sedans.add(current);
            }
        }
        assert (sedans.size() == 4);
    }

    @Test
    public void Test3() {
        ArrayList<Car> c = TestData.load();
        ArrayList<Car> bigEngines = new ArrayList<Car>();
        for(Car current : c){
            if (current.engine > 1.6){
                bigEngines.add(current);
            }
        }
        for (Car current : bigEngines){
            assert(current.engine > 1.8);
        }

    }
}
