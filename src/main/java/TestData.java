import java.util.ArrayList;

public class TestData {
    public static ArrayList<Car> load(){
        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(new Car("Audi", Type.SEDAN, 250, 1.8, 150));
        carList.add(new Car("BMW", Type.CABRIO, 280, 3.0, 230));
        carList.add(new Car("Dacia", Type.SEDAN, 200, 1.2, 90));
        carList.add(new Car("Lada", Type.SEDAN, 160, 1.6, 90));
        carList.add(new Car("Ferrari", Type.COUPE, 300, 4.0, 350));
        carList.add(new Car("Opel", Type.COUPE, 250, 2.0, 180));
        carList.add(new Car("Renault", Type.SEDAN, 200, 1.4, 140));

        return carList;
    }

}
