package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        speedMenuOptions.get(getRandomValue(speedMenuOptions)).click();
        String actualValueInInput = driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText();
        logger.info("Actual selected speed is: {}", actualValueInInput);


        //Select a file
        WebElement btnOpenSelectAFile = driver.findElement(By.cssSelector("#files-button"));
        btnOpenSelectAFile.click();
        logger.info("Click on button to open menu with select a file");

        WebElement listFileMenu = driver.findElement(By.cssSelector("#files-menu"));
        wait.until(ExpectedConditions.visibilityOfAllElements(listFileMenu));
        logger.info("Wait for list of all elements from file menu");

//        List<WebElement> fileMenuOptions = driver.findElements(By.cssSelector("#files-menu .ui-menu-item"));
//        fileMenuOptions.;
        WebElement selectedOption = driver.findElement(By.xpath("//*[text()='Some unknown file']"));
        selectedOption.click();
        String actualValueInInputFile = driver.findElement(By.cssSelector("#files-menu .ui-selectmenu-text")).getText();
        logger.info("Actual selected files is: {}", actualValueInInputFile);

//        WebElement SelectAFile = driver.findElement(By.xpath("//div[text()='Some unknown file']"));
//        logger.info("Select 'Some unknown file' option as file {}", SelectAFile.getText());

    }

    int getRandomValue(List<WebElement> availableOptions) {
        Random rnd = new Random();
        int searchingNumber = rnd.nextInt(availableOptions.size());
        return searchingNumber;
    }
}
