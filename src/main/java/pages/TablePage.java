package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TablePage extends BasePage{

    @FindBy(css= "tbody tr")
    private List<WebElement> rows;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public TablePage searchSpecifiedDataInTable(String mountainName, int mountainHeight) {
        for (WebElement row : rows) {
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());
            int rank = Integer.parseInt(row.findElement(By.cssSelector("th")).getText());
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String mountain = row.findElements(By.cssSelector("td")).get(1).getText();

            if (state.contains(mountainName) && height > mountainHeight) {
                System.out.println("Rank: " + rank + ", peak: " + peak + ", mountain: " + mountain);
            }
        }
        return this;
    }
}
