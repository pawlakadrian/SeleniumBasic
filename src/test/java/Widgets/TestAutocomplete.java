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
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestAutocomplete extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test search input")
    void testSearchInput() {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement searchInput = driver.findElement(By.cssSelector("#search"));
        searchInput.sendKeys("a");

        List<WebElement> availableOptions = driver.findElements(By.cssSelector(".ui-menu-item"));
        for (WebElement availableOption : availableOptions) {
            logger.info(availableOption.getText());
        }

        int getDrawnNumber = getRandomValue(availableOptions);
        String getNameOfValue = availableOptions.get(getDrawnNumber).getText();
        System.out.println("getNameOfValue " + getNameOfValue);
        availableOptions.get(getDrawnNumber).click();

        assertThat(getNameOfValue, equalTo(driver.findElement(By.cssSelector("#search")).getAttribute("value")));
        //todo: get value from input search to assert
    }

    int getRandomValue(List availableOptions) {
        Random rnd = new Random();
        int searchingNumber = rnd.nextInt(availableOptions.size());
        return searchingNumber;
    }
}
