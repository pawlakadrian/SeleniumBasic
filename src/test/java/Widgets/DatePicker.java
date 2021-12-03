package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DatePicker extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test Data Picker")
    void selectDateFromDataPicker() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement dataPicker = driver.findElement(By.cssSelector("#datepicker"));
        dataPicker.click();
        //todo: all method
    }
}
