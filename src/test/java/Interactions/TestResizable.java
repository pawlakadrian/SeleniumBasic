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

public class TestResizable extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestResizable.class);

    @Test
    @DisplayName("Test resizable")
    void resize() {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        logger.info("Open website: https://seleniumui.moderntester.pl/resizable.php");

        WebElement square = driver.findElement(By.cssSelector(".ui-icon-gripsmall-diagonal-se"));
        logger.info("Get element to resize");

        Actions actionProvider = new Actions(driver);
        logger.info("Create action provider");

        actionProvider.clickAndHold(square).moveByOffset(10, 0);
        actionProvider.clickAndHold(square).moveByOffset(0, 10);
        actionProvider.clickAndHold(square).moveByOffset(10, 10)
                .build().perform();
        logger.info("Action resize");
    }
}
