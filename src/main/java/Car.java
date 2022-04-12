enum Type {
    SEDAN,
    COUPE,
    CABRIO
}

public class Car {

    String name;
    int maxSpeed;
    double engine;
    int horsePower;
    Type type;

    public Car(String name, Type type, int maxSpeed, double engine, int horsePower) {
        this.name=name;
        this.maxSpeed=maxSpeed;
        this.engine=engine;
        this.horsePower=horsePower;
        this.type=type;

    }

    public String toString(){
        return name + " " + type + " " + maxSpeed + " " + engine + " " + horsePower;
    }
}


