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

public class TestDraggable extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestDraggable.class);

    @Test
    @DisplayName("Test drag square around")
    void testDraggable() {
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        logger.info("Open website: https://seleniumui.moderntester.pl/draggable.php");

        WebElement square = driver.findElement(By.id("draggable"));
        logger.info("Get element to move");

        Actions actionProvider = new Actions(driver);
        logger.info("Create action provider");

        actionProvider.clickAndHold(square);
        logger.info("Click and hold on element");
        actionProvider.moveByOffset(500, 0);
        logger.info("Move element to the upper right");
        actionProvider.moveByOffset(0, 250);
        logger.info("Move element to the bottom right");
        actionProvider.moveByOffset(-250, -125);
        logger.info("Move element to the center");
        actionProvider.moveByOffset(-250, 125)
                .build().perform();
        logger.info("Move element to the bottom left");
    }
}
