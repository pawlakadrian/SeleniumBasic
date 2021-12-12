package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage extends BasePage{

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement email;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexRadio;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearOfExperience;

    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> professionList;

    @FindBy(css = "#selectContinents option")
    private List<WebElement> continentsElements;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement fileInput;

    @FindBy(xpath = "//a[contains(text(), 'Test File to Download')]")
    private WebElement downloadFileBtn;

    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement sendButton;

    @FindBy(id = "validator-message")
    private WebElement validationMsg;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public FormPage setRandomSex() {
        getRandomElement(sexRadio).click();
        return this;
    }

    public FormPage setAge(String age) {
        this.age.sendKeys(age);
        return this;
    }

    public FormPage setRandomYearOfExperience() {
        getRandomElement(yearOfExperience).click();
        return this;
    }

    public FormPage setProfession(String profession) {
        getOptionWithString(professionList, profession);
        return this;
    }

    public FormPage selectRandomContinents() {
        getRandomElement(continentsElements).click();
        return this;
    }

    public FormPage selectSeleniumCommands(String firstSelect, String secondSelect) {
        Select select = new Select(seleniumCommands);
        select.selectByVisibleText(firstSelect);
        select.selectByVisibleText(secondSelect);
        return this;
    }

    public FormPage uploadFile(String urlToFile) {
        fileInput.sendKeys(urlToFile);
        return this;
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }

    public FormPage send() {
        sendButton.click();
        return this;
    }
}
