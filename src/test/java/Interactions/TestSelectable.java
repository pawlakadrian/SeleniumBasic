package Interactions;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestSelectable extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestSelectable.class);

    @Test
    @DisplayName("Select specified items")
    void selectItems() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        logger.info("Open website: https://seleniumui.moderntester.pl/selectable.php");

        Actions actionProvider = new Actions(driver);

        actionProvider.keyDown(Keys.CONTROL).build().perform();
        List<WebElement> listOfItems = driver.findElements(By.cssSelector(".ui-widget-content"));
        listOfItems.get(0).click();
        listOfItems.get(2).click();
        listOfItems.get(3).click();
        logger.info("Select items: 1,3,4");

        WebElement validateText = driver.findElement(By.cssSelector("#select-result"));
        assertThat(validateText.getText(), equalTo("#1 #3 #4"));
        logger.info("Validate selected items");
    }
}
