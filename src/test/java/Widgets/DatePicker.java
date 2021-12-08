package Widgets;

import Helpers.GetRandomNumber;
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
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

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

        //Test: Today
        logger.info("Start: Test today");
        todayDate.click();
        logger.info("Open datapicker");
        String valueFromInput = driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String todayDateFormatted = sdf.format(currentDate);
        logger.info(todayDateFormatted);

        assertThat(todayDateFormatted, equalTo(valueFromInput));
        logger.info("Assert today date in input: {}", todayDateFormatted);

        //Test: 1st day from next month
        logger.info("Start: Test first day from next month");
        nextMonthBtn.click();
        WebElement firstDayOfNextMonth = driver.findElement(By.xpath("//a[text()='1']"));
        logger.info(String.valueOf(firstDayOfNextMonth));
        firstDayOfNextMonth.click();
        valueFromInput = driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");
        logger.info("Assert today date in input: {}", valueFromInput);

        logger.info("Start: Test last day from january in next year");

        //Test: Last day from January in next year
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1); //here n is no.of year you want to increase
        cal.set(Calendar.MONTH, 0);
        int res = cal.getActualMaximum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, res);
        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");

        String formatted = format1.format(cal.getTime());
        System.out.println(formatted);
        driver.findElement(By.cssSelector("#datepicker")).sendKeys("formatted");

        //Test: Random day from previous month
        //Todo: check
        cal.set(Calendar.MONTH, -1);
        res = cal.getActualMaximum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, GetRandomNumber.getRandomNumber(res));
        SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");

        String formatted2 = format2.format(cal.getTime());
        System.out.println(formatted2);
        driver.findElement(By.cssSelector("#datepicker")).clear();
        driver.findElement(By.cssSelector("#datepicker")).sendKeys("formatted2");

        //todo: Random date from last year
    }
    private static final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
