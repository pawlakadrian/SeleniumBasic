package Basic;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestAlerts extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestAlerts.class);
    String url = "https://seleniumui.moderntester.pl/alerts.php";

    @Test
    @DisplayName("Test Simple Alert Pop up")
    void testSimpleAlert() {
        driver.get(url);
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();
        assertThat(driver.findElement(By.cssSelector("#simple-alert-label")).getText(), equalTo("OK button pressed"));
        logger.info("Test Simple Alert");
    }

    @Test
    @DisplayName("Test Prompt Alert box")
    void testPromptAlert() {
        driver.get(url);
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Lord Vader");
        alert.accept();
        assertThat(driver.findElement(By.cssSelector("#prompt-label")).getText(), equalTo("Hello Lord Vader! How are you today?"));
        logger.info("Test Prompt Alert box");
    }

    @Test
    @DisplayName("Test Confirm Alert box")
    void testConfirmAlert() {
        driver.get(url);
        WebElement btnConfirmAlert = driver.findElement(By.cssSelector("#confirm-alert"));
        btnConfirmAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertThat(driver.findElement(By.cssSelector("#confirm-label")).getText(), equalTo("You pressed OK!"));
        logger.info("Test Confirm Alert box - pressed OK");

        btnConfirmAlert.click();
        alert.dismiss();
        assertThat(driver.findElement(By.cssSelector("#confirm-label")).getText(), equalTo("You pressed Cancel!"));
        btnConfirmAlert.click();
        logger.info("Test Confirm Alert box - pressed cancel");
    }

    @Test
    @DisplayName("Test Delayed alert")
    void testDelayedAlert() {
        driver.get(url);
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertThat(driver.findElement(By.cssSelector("#delayed-alert-label")).getText(), equalTo("OK button pressed"));
        logger.info("Test Delayed alert");
    }
}
