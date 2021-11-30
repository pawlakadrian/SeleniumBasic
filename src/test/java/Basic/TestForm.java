package Basic;

import Helpers.TestBase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestForm extends TestBase {
    private Logger logger = LoggerFactory.getLogger(TestForm.class);

    @Test
    @DisplayName("Test formularza")
    void testForm() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        logger.info("Open seleniumui.moderntester.pl website");

        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("Adrian");
        logger.info("Fill first name with: {}", "Adrian");


        WebElement lastName = driver.findElement(By.cssSelector("#inputLastName3"));
        lastName.sendKeys("Pawlak");
        logger.info("Fill last name with: {}", "Pawlak");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail3"));
        email.sendKeys("apawlak1@sii.pl");
        logger.info("Fill email with: {}", "apawlak1@sii.pl");


        List<WebElement> sexRadio = driver.findElements(By.cssSelector(".form-check [name='gridRadiosSex']"));
        Random random = new Random();
        int sexRadioIndex = random.nextInt(sexRadio.size());
        sexRadio.get(sexRadioIndex).click();
        logger.info("Select random radio sex");

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("30");
        logger.info("Fill age with: {}", "30");

        List<WebElement> yearOfExp = driver.findElements(By.cssSelector(".form-check [name='gridRadiosExperience']"));
        int yearOfExpIndex = random.nextInt(yearOfExp.size());
        yearOfExp.get(yearOfExpIndex).click();
        logger.info("Fill random year of experience");

        WebElement profession = driver.findElement(By.cssSelector("#gridCheckAutomationTester"));
        profession.click();
        logger.info("Select profession: {}", "Automation Tester");

        Select continents = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        List<WebElement> continentsList = driver.findElements(By.cssSelector(".form-check [name='gridRadiosExperience']"));
        int continentsIndex = random.nextInt(continentsList.size());
        continents.selectByIndex(continentsIndex);
        logger.info("Select random continent");

        WebElement seleniumCommands1 = driver.findElement(By.cssSelector(".custom-select [value='switch-commands']"));
        WebElement seleniumCommands2 = driver.findElement(By.cssSelector(".custom-select [value='wait-commands']"));
        seleniumCommands1.click();
        seleniumCommands2.click();
        logger.info("Select selenium commands: {}", seleniumCommands1, seleniumCommands2);

        WebElement uploadFile = driver.findElement(By.cssSelector("#chooseFile"));
        logger.info("Select button to choose upload: {}", uploadFile);
        File file = new File("src/resources/sample.pdf");
        uploadFile.sendKeys(file.getAbsolutePath());
        logger.info("Provide file to upload: {}", file.getAbsolutePath());

        //---------------------
        File dir = new File("src" + File.separator + "download");
        logger.info("Directory to download new files: {}", dir);
        int actualDirFiles;

        if (dir != null && dir.length() > 0) {
            actualDirFiles = dir.listFiles().length;
        } else {
            actualDirFiles = 0;
        }

        //---------------------
        WebElement downloadBtn = driver.findElement(By.linkText("Test File to Download"));
        downloadBtn.click();
        logger.info("Click downlad button: {}", downloadBtn);
        Thread.sleep(3000);

        //---------------------
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        submitBtn.click();
        logger.info("Send filled form: {}", submitBtn);

        //---------------------
        int dirFilesIsIncr = dir.listFiles().length;
        logger.info("Check number of files in directory: {}", dirFilesIsIncr);

        assertThat(actualDirFiles + 1, equalTo(dirFilesIsIncr));
        logger.info("Assect that is new file in directory");

        //---------------------
        WebElement validateMsg = driver.findElement(By.cssSelector("#validator-message"));
        logger.info("Validate message: {}", validateMsg.getText());
        String msgToValidate = "Form send with success";
        assertThat(validateMsg.getText(), equalTo(msgToValidate));
        logger.info("Assert validation message");
    }
}
