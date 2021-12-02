package Widgets;

import Helpers.MoveObj;
import Helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class TestSlider extends MoveObj {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    @DisplayName("Test slider")
    void moveSlider() {
        driver.get("http://automation-practice.emilos.pl/slider.php");

        WebElement sliderHandle = driver.findElement(By.cssSelector("#custom-handle"));

        moveObj(sliderHandle, "right", 50);
        assertThat(sliderHandle.getText(), equalTo("50"));
        logger.info("Check value is: 50");

        moveObj(sliderHandle, "right", 29);
        assertThat(sliderHandle.getText(), equalTo("80"));
        logger.info("Check value is: 80");

//        moveObj(sliderHandle, "right", 0);
        assertThat(sliderHandle.getText(), equalTo("80"));
        logger.info("Check value is: 80");

        moveObj(sliderHandle, "left", 61);
        assertThat(sliderHandle.getText(), equalTo("20"));
        logger.info("Check value is: 20");

        moveObj(sliderHandle, "left", 21);
        assertThat(sliderHandle.getText(), equalTo("0"));
        logger.info("Check value is: 0");
    }
}
