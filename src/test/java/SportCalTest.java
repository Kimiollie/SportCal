import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportCalTest {
    private SportCal sportCal;

    @BeforeEach
    public void setUp() {
        sportCal = new SportCal();
    }

    @Test
    public void testLogActivity() {
        sportCal.logActivity("Running", 30);
        assertEquals(1, sportCal.activities.size());
    }

    @Test
    public void testViewActivities() {
        sportCal.logActivity("Running", 30);
        sportCal.logActivity("Swimming", 45);
        sportCal.viewActivities();
        assertEquals(2, sportCal.activities.size());
    }

    @Test
    public void testCalculateTotalTime() {
        sportCal.logActivity("Running", 30);
        sportCal.logActivity("Swimming", 45);
        int totalTime = sportCal.calculateTotalTime();
        assertEquals(75, totalTime);
    }
}