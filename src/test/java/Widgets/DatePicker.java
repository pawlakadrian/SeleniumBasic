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

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DatePicker extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test Data Picker")
    void selectDateFromDataPicker() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        WebElement dataPickerCalendar = driver.findElement(By.cssSelector("#ui-datepicker-div"));
        WebElement dataPickerInput = driver.findElement(By.cssSelector("#datepicker"));

        dataPickerInput.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(dataPickerCalendar));

        WebElement nextMonthBtn = driver.findElement(By.cssSelector(".ui-datepicker-next"));
        WebElement prevMonthBtn = driver.findElement(By.cssSelector(".ui-datepicker-prev"));
        WebElement todayDate = driver.findElement(By.cssSelector(".ui-state-highlight"));

        logger.info("Start: Test today");
        todayDate.click();
        logger.info("Open datapicker");
        String valueFromInput = driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = sdf.format(currentDate);
        logger.info(formattedDate);

        assertThat(formattedDate, equalTo(valueFromInput));
        logger.info("Assert today date in input: {}", formattedDate);

        logger.info("Start: Test first day from next month");
        nextMonthBtn.click();
        WebElement firstDayOfNextMonth = driver.findElement(By.xpath("//a[text()='1']"));
        logger.info(String.valueOf(firstDayOfNextMonth));
        firstDayOfNextMonth.click();
        valueFromInput = driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");
        logger.info("Assert today date in input: {}", valueFromInput);

        //todo: last day from january in next year
        logger.info("Start: Test last day from january in next year");

        //todo: Select same day again (same was selected in step 3)
        //todo: Random day from previous month
        //todo: Random date from last year
    }
}
