package Basic;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIframes extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestIframes.class);
    String url = "https://seleniumui.moderntester.pl/iframes.php";

    @Test
    @DisplayName("Test Iframes")
    void testIframes() {
        driver.get(url);
        driver.switchTo().frame("iframe1");
        logger.info("Switch to first iframe");
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Adrian");
        logger.info("Complete the first name");
        driver.findElement(By.cssSelector("#inputSurname3")).sendKeys("Pawlak");
        logger.info("Complete the surname");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        logger.info("Click sign in button");
        driver.switchTo().parentFrame();
        logger.info("Switch to parent frame");

        driver.switchTo().frame("iframe2");
        logger.info("Switch to second iframe");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Adrian");
        logger.info("Complete login");
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys("password");
        logger.info("Complete password");
        Select continents = new Select(driver.findElement(By.cssSelector("#inlineFormCustomSelectPref")));
        continents.selectByVisibleText("Europe");
        logger.info("Select 'Europe' in continents");
        driver.findElement(By.cssSelector("#gridRadios4")).click();
        logger.info("Select '4' in year of experience");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        logger.info("Click sign in button");

        driver.switchTo().parentFrame();
        logger.info("Switch to parent frame");
        driver.findElement(By.cssSelector(".navbar-nav:nth-child(1)")).click();
        logger.info("Click on 'Basic' menu button");
        logger.info("Complete Test Iframes");
    }
}
