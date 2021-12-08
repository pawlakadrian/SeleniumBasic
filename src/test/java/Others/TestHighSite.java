package Others;

import Helpers.TestBase;
import Widgets.TestAccordion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;

public class TestHighSite extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Scroll to element and take screenshot")
    void takeScreenshot() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement scollBtn = driver.findElement(By.cssSelector("#scroll-button"));

        String btnHighVisibility = driver.findElement(By.cssSelector(".show-button")).getAttribute("style");
        String digits = btnHighVisibility.replaceAll("[^0-9.]", "");

        js.executeScript("window.scrollBy(0," + (digits)+")");
        js.executeScript("window.scrollBy(0,-100)");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#scroll-button"))));

        try {
            takeScreenshot(resolveTestResourcePath("screenshot-submit-button.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Screenshot of submit button was made");
    }
}
