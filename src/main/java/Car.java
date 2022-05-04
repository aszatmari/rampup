enum Type {
    SEDAN,
    COUPE,
    CABRIO
}

public class Car {

    private final String name;
    private final int maxSpeed;
    private final double engine;
    private final int horsePower;
    private final Type type;

    private Car(CarBuilder builder) {
        this.name = builder.name;
        this.maxSpeed = builder.maxSpeed;
        this.engine = builder.engine;
        this.horsePower = builder.horsePower;
        this.type = builder.type;

    }

    public String getName() {
        return name;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public double getEngine() {
        return engine;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public Type getType() {
        return type;
    }

    public String toString(){
        return name + " " + type + " " + maxSpeed + " " + engine + " " + horsePower;
    }

    public static class CarBuilder
    {
        private String name;
        private int maxSpeed;
        private double engine;
        private int horsePower;
        private final Type type;

        public CarBuilder(Type type){
            this.type = type;
        }

        public CarBuilder name(String name){
            this.name = name;
            return this;
        }

        public CarBuilder maxSpeed(int maxSpeed){
            this.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder engine(double engine){
            this.engine = engine;
            return this;
        }

        public CarBuilder horsePower(int horsePower){
            this.horsePower = horsePower;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}


