package Helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class MoveObj extends TestBase {
    public void moveObj(WebElement objToMove, String direction, int distance) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(objToMove).build().perform();

        for (int i = 0; i < distance; i++) {
            if (Objects.equals(direction, "right")) {
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }
        actions.release(objToMove);
    }
}
