package Basic;

import Helpers.TableSearch;
import Helpers.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWindowsTabs extends TableSearch {
    private Logger logger = LoggerFactory.getLogger(TestAlerts.class);

    @BeforeEach
    public void setUpTest() {
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
    }

    @Test
    @DisplayName("Test Windows/Tabs")
    void testWindows() {
        String winHandleBefore = driver.getWindowHandle();
        logger.info("Store current window");

        driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        logger.info("Click on button: new browser window");

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        logger.info("Switch to new window");

        searchSpecifiedData();
        logger.info("Execute test from 4th exercise on the newly opened window");

        driver.close();
        logger.info("Close new window");

        driver.switchTo().window(winHandleBefore);
        logger.info("Switch back to original browser");

        //todo: click new message window
        //todo: switch to
        //todo: print text
        //todo: close window
        //todo: click new browser tab
        //todo: switch to
        //todo: execute test from 4th exercise
        //todo: close tab
    }
}
