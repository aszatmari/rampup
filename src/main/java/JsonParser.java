import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser {
    private final Path path;

    public JsonParser(Path path) {
        this.path = path;
    }

    public List<iCar> parse() {
        List<HashMap<String, String>> elements;
        List<iCar> cars = new ArrayList<iCar>();
        try {

            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(this.path);
            elements = new Gson().fromJson(reader, new TypeToken<List<HashMap<String, String>>>() {
            }.getType());

            for (HashMap<String, String> element : elements) {
                String name = element.get("name");
                String type = element.get("type");
                int maxSpeed = Integer.parseInt(element.get("maxSpeed"));
                double engine = Double.parseDouble(element.get("engine"));
                int horsePower = Integer.parseInt(element.get("horsePower"));

                if (horsePower >= 200) {
                    cars.add(new LuxuryCar.LuxuryCarBuilder(Type.valueOf(type))
                            .name(name)
                            .maxSpeed(maxSpeed)
                            .engine(engine)
                            .horsePower(horsePower)
                            .build());
                } else {
                    cars.add(new Car.CarBuilder(Type.valueOf(type))
                            .name(name)
                            .maxSpeed(maxSpeed)
                            .engine(engine)
                            .horsePower(horsePower)
                            .build());
                }
            }

            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cars;
    }
}
