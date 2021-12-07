package Interactions;

import Helpers.TestBase;
import Widgets.TestAccordion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestSortable extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test sortable table")
    void sortable() {
        driver.get("https://seleniumui.moderntester.pl/sortable.php");

        Actions actionProvider = new Actions(driver);

        ArrayList<Integer> listShuffled = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        Collections.shuffle(listShuffled);

        logger.info("shuffled array: {}", listShuffled);

        for (int i = 0; i < listShuffled.size(); ++i) {
            int lookingNumber = listShuffled.get(i);

            WebElement elem = driver.findElement(By.xpath("//li[text()='Item " + lookingNumber + "']"));

            WebElement elemOfArray = driver.findElements(By.cssSelector(".ui-sortable-handle")).get(i);

            if(elem != elemOfArray){
                actionProvider.clickAndHold(elem).dragAndDrop(elem, elemOfArray).perform();
            }
        }
    }
}
