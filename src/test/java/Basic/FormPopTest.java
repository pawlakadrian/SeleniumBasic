package Basic;

import Helpers.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormPopTest extends TestBase {

    private File file;

    @BeforeEach
    public void openFormPage(){
        file = new File("src/resources/sample.pdf");
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }

    @Test
    public void fillAndSendForm() {
        FormPage formPage = new FormPage(getDriver());

        formPage.setFirstName("Adrian");
        formPage.setLastName("Pawlak");
        formPage.setEmail("apawlak1@sii.pl");
        formPage.setRandomSex();
        formPage.setAge("18");
        formPage.setRandomYearOfExperience();
        formPage.setProfession("Automation Tester");
        formPage.selectRandomContinents();
        formPage.selectSeleniumCommands("Switch Commands", "Wait Commands");
        formPage.uploadFile(file.getAbsolutePath());
        formPage.send();

        String validationMsg = "Form send with success";
        assertThat(validationMsg, equalTo(formPage.getValidationMsg()));
    }
}
