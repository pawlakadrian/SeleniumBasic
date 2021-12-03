package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TestMenu extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test Menu")
    void testMenu() {
        driver.get("https://seleniumui.moderntester.pl/menu-item.php");

        WebElement musicBtn = driver.findElement(By.cssSelector("#ui-id-9"));
        WebElement jazzBtn = driver.findElement(By.cssSelector("#ui-id-13"));
        WebElement modernBtn = driver.findElement(By.cssSelector("#ui-id-16"));

        Actions actions = new Actions(driver);
        actions.moveToElement(musicBtn).moveToElement(jazzBtn).moveToElement(modernBtn).click();
    }
}
