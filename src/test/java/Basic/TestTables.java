package Basic;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestTables extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestAlerts.class);
    String url = "https://seleniumui.moderntester.pl/table.php";

    @Test
    @DisplayName("Test Tables")
    void testTables() {
        driver.get(url);
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());
            int rank = Integer.parseInt(row.findElement(By.cssSelector("th")).getText());
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String mountain = row.findElements(By.cssSelector("td")).get(1).getText();

            if (validatorMountains(state, height)) {
                System.out.println("Rank: " + rank + ", peak: " + peak + ", mountain: " + mountain);
            }
        }
    }

    boolean validatorMountains(String state, int height) {
        String lookingMountain = "Switzerland";
        int lookingHigh = 4000;

        if (state.contains(lookingMountain) && height > lookingHigh) {
            return true;
        }
        return false;
    }
}
