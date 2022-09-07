import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class TestBase {
    protected List<iCar> cars;
    private DateTime startDate;

    @BeforeEach
    public void Setup() {
        this.startDate = new DateTime();
        Path p = Paths.get("src/main/assets/Testdata.json");
        JsonParser parser = new JsonParser(p.toAbsolutePath());
        this.cars = parser.parse();
    }

    @AfterEach
    public void Close() {
        DateTime endDate = new DateTime();
        Seconds diff = Seconds.secondsBetween(startDate, endDate);
        log.info("Duration of the test execution in seconds: " + Integer.toString(diff.getSeconds()));
    }
}
