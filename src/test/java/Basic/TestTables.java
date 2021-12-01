package Basic;

import Helpers.TableSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTables extends TableSearch {
    private Logger logger = LoggerFactory.getLogger(TestAlerts.class);

    @BeforeEach
    public void setUpTest() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
    }

    @Test
    @DisplayName("Test Tables")
    void testTables() {
        searchSpecifiedData();
    }
}
