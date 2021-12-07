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

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TestSelectMenu extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test Select Menu")
    void selectMenu() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");

        // Select a speed
        WebElement btnOpenSpeedMenu = driver.findElement(By.cssSelector("#speed-button"));
        btnOpenSpeedMenu.click();
        logger.info("Click on button to open menu with speed");

        WebElement listSpeedMenu = driver.findElement(By.cssSelector("#speed-menu"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(listSpeedMenu));
        logger.info("Wait for list of all elements from speed menu");

        List<WebElement> speedMenuOptions = driver.findElements(By.cssSelector("#speed-menu .ui-menu-item"));
        speedMenuOptions.get(GetRandomNumber.getRandomValue(speedMenuOptions)).click();
        String actualValueInInput = driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText();
        logger.info("Actual selected speed is: {}", actualValueInInput);

        // Select a file
        WebElement btnOpenSelectAFile = driver.findElement(By.cssSelector("#files-button"));
        btnOpenSelectAFile.click();
        logger.info("Click on button to open menu with select a file");

        WebElement listFileMenu = driver.findElement(By.cssSelector("#files-menu"));
        wait.until(ExpectedConditions.visibilityOfAllElements(listFileMenu));
        logger.info("Wait for list of all elements from file menu");

        WebElement selectedOption = driver.findElement(By.xpath("//*[@id='ui-id-8'][text()='Some unknown file']"));
        selectedOption.click();
        String actualValueInInputFile = driver.findElement(By.cssSelector("#files-button .ui-selectmenu-text")).getText();
        logger.info("Actual selected files is: {}", actualValueInInputFile);

        // Select a number
        WebElement btnOpenSelectANumber = driver.findElement(By.cssSelector("#number-button"));
        btnOpenSelectANumber.click();
        logger.info("Click on button to open menu with select a number");

        WebElement listNumbers = driver.findElement(By.cssSelector("#number-menu"));
        wait.until(ExpectedConditions.visibilityOfAllElements(listNumbers));
        logger.info("Wait for list of all elements from numbers menu");

        List<WebElement> numbersList = driver.findElements(By.cssSelector("#number-menu .ui-menu-item-wrapper"));
        numbersList.get(GetRandomNumber.getRandomValue(numbersList)).click();
        String actualValueInInputNumber = driver.findElement(By.cssSelector("#number-button .ui-selectmenu-text")).getText();
        logger.info("Actual selected files is: {}", actualValueInInputNumber);

        // Select a title
        WebElement btnOpenTitleMenu = driver.findElement(By.cssSelector("#salutation-button"));
        btnOpenTitleMenu.click();
        logger.info("Click on button to open menu with titles");

        WebElement listTitleMenu = driver.findElement(By.cssSelector("#salutation-button"));
        wait.until(ExpectedConditions.visibilityOfAllElements(listTitleMenu));
        logger.info("Wait for list of all elements from title menu");

        List<WebElement> titleMenuOptions = driver.findElements(By.xpath("//ul[@id='salutation-menu']/li[not(contains(@class, 'ui-state-disabled'))]"));
        titleMenuOptions.get(GetRandomNumber.getRandomValue(titleMenuOptions)).click();
        String actualValueInInputTitle = driver.findElement(By.cssSelector("#salutation-button .ui-selectmenu-text")).getText();
        logger.info("Actual selected title is: {}", actualValueInInputTitle);
    }
}
