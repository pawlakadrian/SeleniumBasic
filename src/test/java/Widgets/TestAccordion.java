package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class TestAccordion extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test Accordion")
    void openAndPrintAccordionValue() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> sections = driver.findElements(By.cssSelector(".ui-accordion-header"));
        logger.info("Get all headers to click later");

        System.out.println(driver.findElement(By.cssSelector(".ui-accordion-content-active p")).getText());
        logger.info("Print text from Section 1");

        sections.get(1).click();
        logger.info("Click on section 2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-4 p")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-4 p")).getText());

        sections.get(2).click();
        logger.info("Click on section 3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-6 p")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-6 p")).getText());

        sections.get(3).click();
        logger.info("Click on section 4");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-8 p")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-8 p")).getText());
    }
}
