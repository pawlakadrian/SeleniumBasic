package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TableSearch extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    public void searchSpecifiedData() {
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        logger.info("Get all rows from table");

        for (WebElement row : rows) {
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());
            int rank = Integer.parseInt(row.findElement(By.cssSelector("th")).getText());
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String mountain = row.findElements(By.cssSelector("td")).get(1).getText();

            if (validatorData(state, height)) {
                System.out.println("Rank: " + rank + ", peak: " + peak + ", mountain: " + mountain);
            }
        }
        logger.info("Run validator to search specified mountains");
    }

    boolean validatorData(String state, int height) {
        String lookingMountain = "Switzerland";
        int lookingHigh = 4000;

        if (state.contains(lookingMountain) && height > lookingHigh) {
            return true;
        }
        return false;
    }
}
