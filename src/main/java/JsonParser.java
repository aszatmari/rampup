import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    private final Path path;

    public JsonParser(Path path) {
        this.path = path;
    }

    public List<Car> parse() {
        List<Car> cars = new ArrayList<Car>();
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(this.path);

            // convert JSON array to list of cars
            cars = new Gson().fromJson(reader, new TypeToken<List<Car>>() {
            }.getType());

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cars;
    }
}
