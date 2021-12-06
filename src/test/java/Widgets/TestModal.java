package Widgets;

import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
        String name = "Adrian";
        inputName.sendKeys(name);

        inputEmail.clear();
        String email = "apawlak1@sii.pl";
        inputEmail.sendKeys(email);

        inputPass.clear();
        String password = "password";
        inputPass.sendKeys(password);

        WebElement createAnAccountBtn = driver.findElement(By.xpath("//*[contains(text(), 'Create an account')]"));
        createAnAccountBtn.click();

        WebElement newUserFromTable = driver.findElement(By.cssSelector("#users tbody tr:last-child"));
        logger.info(String.valueOf(newUserFromTable.getText()));
        assertThat(newUserFromTable.getText(), equalTo(name + " " + email + " " + password));
        logger.info("Assertion for new user in table");
    }
}
