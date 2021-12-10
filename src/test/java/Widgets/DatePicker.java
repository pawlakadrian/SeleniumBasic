package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.ThreadLocalRandom;

public class DatePicker extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(DatePicker.class);

    public int checkActualYear() {
        int displayedYear = Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getText());
        logger.info("Actual year: {} ", displayedYear);
        return displayedYear;
    }

    public int checkActualMonth() {
        String displayedMonth = driver.findElement(By.xpath("//td[@class = ' '][1]")).getAttribute("data-month");
        logger.info("Actual month (showing minus 1 because of numering list): {} ", displayedMonth);
        return Integer.parseInt(displayedMonth);
    }

    public void selectDay(int expectedDay, int expectedMonth) {
        driver.findElement(By.xpath("//td[not(contains(@class, 'ui-datepicker-other-month'))]//a[contains(@class, 'ui-state-default')][text()=" + expectedDay + "]")).click();
    }

    public void moveToDate(int expectedYear, int expectedMonth, int expectedDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#datepicker")));
        driver.findElement(By.cssSelector("#datepicker")).click();
        logger.info("Open datepicker");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-calendar")));

        while (expectedYear != checkActualYear()) {
            WebElement nextMonthBtn = driver.findElement(By.cssSelector(".ui-datepicker-next"));
            WebElement prevMonthBtn = driver.findElement(By.cssSelector(".ui-datepicker-prev"));
            logger.info("Get next and prev month buttons");

            logger.info("expectedYear " + expectedYear);
            logger.info("checkActualYear() " + checkActualYear());

            if (expectedYear > checkActualYear()) {
                nextMonthBtn.click();
                logger.info("Click next month");
            } else if (expectedYear < checkActualYear()) {
                prevMonthBtn.click();
                logger.info("Click prev month");
            }
        }

        while ((expectedMonth - 1) != checkActualMonth()) {
            WebElement nextMonthBtn = driver.findElement(By.cssSelector(".ui-datepicker-next"));
            WebElement prevMonthBtn = driver.findElement(By.cssSelector(".ui-datepicker-prev"));
            logger.info("Get next and prev month buttons");

            if ((expectedMonth - 1) > checkActualMonth()) {
                nextMonthBtn.click();
                logger.info("Click next month");
            } else if ((expectedMonth - 1) < checkActualMonth()) {
                prevMonthBtn.click();
                logger.info("Click prev month");
            }
        }

        selectDay(expectedDay, expectedMonth);
        logger.info("Select a day: {}", expectedDay);
    }

    public String selectedDateInInput() {
        return driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");
    }

    @Test
    void testDatePicker() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        LocalDate localDate = LocalDate.now();

        moveToDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        logger.info("Select today date");
        logger.info("Selected date: {}", selectedDateInInput());
        System.out.println("##################");

        LocalDate monthLater = localDate.plusMonths(1);
        moveToDate(monthLater.getYear(), monthLater.getMonthValue(), 1);
        logger.info("Select 1st day from next month");
        logger.info("Selected date: {}", selectedDateInInput());
        System.out.println("##################");

        LocalDate nextYear = localDate.plusYears(1);
        int nextYearToClick = nextYear.getYear();
        moveToDate(nextYear.getYear(), 1, 31);
        logger.info("Last day from January in next year");
        logger.info("Selected date: {}", selectedDateInInput());
        System.out.println("##################");

        moveToDate(nextYearToClick, 1, 31);
        logger.info("Select same day again");
        logger.info("Selected date: {}", selectedDateInInput());
        System.out.println("##################");

        LocalDate randomDayPrevMonthStart = LocalDate.of(localDate.getYear(), Month.from(localDate.minusMonths(1)), 1);
        LocalDate lastDayOfMonth = randomDayPrevMonthStart.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate shuffledDateFromPrevMonth = between(randomDayPrevMonthStart.toEpochDay(), lastDayOfMonth.toEpochDay());
        moveToDate(shuffledDateFromPrevMonth.getYear(), shuffledDateFromPrevMonth.getMonthValue(), shuffledDateFromPrevMonth.getDayOfMonth());
        logger.info("Random day from previous month");
        logger.info("Selected date: {}", selectedDateInInput());
        System.out.println("##################");

        LocalDate prevYear = localDate.minusYears(1);
        LocalDate lastYearBegin = LocalDate.of(prevYear.getYear(), Month.JANUARY, 1);
        LocalDate lastYearEnd = LocalDate.of(prevYear.getYear(), 12, 31);
        LocalDate shuffledDateFromPrevYear = between(lastYearBegin.toEpochDay(), lastYearEnd.toEpochDay());
        moveToDate(shuffledDateFromPrevYear.getYear(), shuffledDateFromPrevYear.getMonthValue(), shuffledDateFromPrevYear.getDayOfMonth());
        logger.info("Random date from last year");
        logger.info("Selected date: {}", selectedDateInInput());
        System.out.println("##################");
    }

    public static LocalDate between(long start, long end) {
        long randomDay = ThreadLocalRandom.current().nextLong(start, end);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }
}

