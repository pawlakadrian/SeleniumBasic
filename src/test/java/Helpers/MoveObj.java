package Helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class MoveObj extends TestBase {
    public void moveObj(String direction, int distance) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < distance; i++) {
            if (direction == "right") {
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }
    }
}
