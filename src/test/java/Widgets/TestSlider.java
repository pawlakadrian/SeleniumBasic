package Widgets;

import Helpers.MoveObj;
import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestSlider extends MoveObj {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    @DisplayName("Test slider")
    void moveSlider() {
        driver.get("http://automation-practice.emilos.pl/slider.php");

        WebElement sliderHandle = driver.findElement(By.cssSelector("#custom-handle"));

        moveObj("right", 50);
    }
}
