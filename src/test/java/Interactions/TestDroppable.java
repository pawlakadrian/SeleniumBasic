package Interactions;

import Basic.TestAlerts;
import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestDroppable extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestDroppable.class);

    @Test
    @DisplayName("Test droppable")
    void moveObjToAnother() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        logger.info("Open website: https://seleniumui.moderntester.pl/droppable.php");

        WebElement square = driver.findElement(By.id("draggable"));
        logger.info("Get element to drop");
        WebElement placeToDrop = driver.findElement(By.id("droppable"));
        logger.info("Get place to drop");
        WebElement assertText = driver.findElement(By.cssSelector("#droppable p"));
        logger.info("Get text to check assertion");

        Actions actionProvider = new Actions(driver);
        logger.info("Create action provider");

        actionProvider.dragAndDrop(square, placeToDrop).build().perform();
        logger.info("Move object to another");

        assertThat(assertText.getText(), equalTo("Dropped!"));
        logger.info("Check assertion");
    }
}
