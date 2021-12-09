package DemoQA;

import Helpers.GetRandomNumber;
import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Demoqa extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(Demoqa.class);

    @Test
    @DisplayName("Test form from demoqa site")
    @RepeatedTest(10)
    public void shouldFillDemoQaForm() {
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement hideAdv = driver.findElement(By.id("adplus-anchor"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", hideAdv);
        logger.info("Hide advertising");

        //-----------------
        sendKeysToForm("Ma");
        logger.info("Send 'Ma' keys to input");

        chooseOption(driver.findElement(By.cssSelector("#react-select-2-option-0")));
        logger.info("Chose option 'Math'");

        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value__label")).getText(), equalTo("Maths"));
        logger.info("Assertion: selected value is already in input");
        //-----------------
        sendKeysToForm("c");
        logger.info("Send 'c' key to input");

        List<WebElement> chooseOptionsWithC = driver.findElements(By.cssSelector(".subjects-auto-complete__option"));
        String choosenElementWithC = chooseRandomOption(chooseOptionsWithC);
        logger.info("Select random value to input");

        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(1) .subjects-auto-complete__multi-value__label")).getText(), equalTo("Maths"));
        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(2) .subjects-auto-complete__multi-value__label")).getText(), equalTo(choosenElementWithC));
        logger.info("Assertion to check all selected values are in input");
        //-------------------
        sendKeysToForm("a");
        logger.info("Send 'a' key to input");

        List<WebElement> chooseOptionsWithA = driver.findElements(By.cssSelector(".subjects-auto-complete__option"));
        String choosenElementWithA = chooseRandomOption(chooseOptionsWithA);
        logger.info("Select random value to input");

        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(1) .subjects-auto-complete__multi-value__label")).getText(), equalTo("Maths"));
        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(2) .subjects-auto-complete__multi-value__label")).getText(), equalTo(choosenElementWithC));
        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(3) .subjects-auto-complete__multi-value__label")).getText(), equalTo(choosenElementWithA));
        logger.info("Assertion to check all three element are in input");

        //-----------------
        driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(3) .subjects-auto-complete__multi-value__remove")).click();
        logger.info("Remove last element from input");
        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(1) .subjects-auto-complete__multi-value__label")).getText(), equalTo("Maths"));
        assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(2) .subjects-auto-complete__multi-value__label")).getText(), equalTo(choosenElementWithC));
        logger.info("Assertion to check that the left two element are still in input");
        //-----------------
        driver.findElement(By.cssSelector(".subjects-auto-complete__indicators")).click();
        logger.info("Remove all elements from input");

        checkInputIsEmpty();
        logger.info("Check input is empty");
    }

    void sendKeysToForm(String keys) {
        WebElement subjectInput = driver.findElement(By.cssSelector("#subjectsInput"));
        subjectInput.sendKeys(keys);
    }

    void chooseOption(WebElement element) {
        element.click();
    }

    String chooseRandomOption(List<WebElement> listAvailableOptions) {
        int randomOption = GetRandomNumber.getRandomValue(listAvailableOptions);
        String elementToMatch = listAvailableOptions.get(randomOption).getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".subjects-auto-complete__menu")));

        wait.until(ExpectedConditions.elementToBeClickable(listAvailableOptions.get(randomOption)));
        listAvailableOptions.get(randomOption).click();

        return elementToMatch;
    }

    boolean checkInputIsEmpty() {
        return driver.findElement(By.cssSelector(".subjects-auto-complete__placeholder")) != null;
    }
}
