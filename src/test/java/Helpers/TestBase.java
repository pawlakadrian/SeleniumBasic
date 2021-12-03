package Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected WebDriver driver;

    static ChromeOptions options = new ChromeOptions();

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        logger.debug("Webdriver initialized");
    }

    @BeforeEach
    void setup() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "src" + File.separator + "download");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.debug("Set properties to chrome driver");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.debug("Browser closed properly");
    }
}
