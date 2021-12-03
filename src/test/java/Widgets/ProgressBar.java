package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBar extends TestBase {

    @Test
    public void shouldWaitForProgressBar() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebElement progressBar = driver.findElement(By.cssSelector(".progress-label"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, "Complete!"));
    }
}
