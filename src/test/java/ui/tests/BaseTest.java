package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before
    public void init() {
        setup();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
