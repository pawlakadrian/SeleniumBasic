package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestTooltip extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    @DisplayName("Test read tooltip")
    void readTooltip() {
        driver.get("https://seleniumui.moderntester.pl/tooltip.php");
        logger.info("Open site: https://seleniumui.moderntester.pl/tooltip.php");

        WebElement elementWithTooltip = driver.findElement(By.cssSelector("#age"));
        String actualTooltip = elementWithTooltip.getAttribute("title");
        logger.info("Get tooltip element");

        assertThat(actualTooltip, equalTo("We ask for your age only for statistical purposes."));
        logger.info("Assertion tooltip text");
    }
}
