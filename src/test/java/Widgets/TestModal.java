package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestModal extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestAccordion.class);

    @Test
    @DisplayName("Test modal dialog")
    void testModal() {
        driver.get("https://seleniumui.moderntester.pl/modal-dialog.php");

        WebElement createNewUserBtn = driver.findElement(By.cssSelector("#create-user"));
        createNewUserBtn.click();

        driver.switchTo().activeElement();
        WebElement inputName = driver.findElement(By.cssSelector("#name"));
        WebElement inputEmail = driver.findElement(By.cssSelector("#email"));
        WebElement inputPass = driver.findElement(By.cssSelector("#password"));

        inputName.clear();
        inputName.sendKeys("Adrian");

        inputEmail.clear();
        inputEmail.sendKeys("apawlak1@sii.pl");

        inputPass.clear();
        inputPass.sendKeys("password");

        WebElement createAnAccountBtn = driver.findElement(By.xpath("//*[contains(text(), 'Create an account')]"));
        createAnAccountBtn.click();

        List<WebElement> rows = driver.findElements(By.cssSelector("#users tbody tr"));
        System.out.println(rows);

        //todo: assertion to check new row
    }
}
