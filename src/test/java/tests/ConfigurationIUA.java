package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ConfigurationIUA extends TestRunner {
    @BeforeClass
    public void openPage() {
        Configuration.timeout = 10000;
        open("https://www.i.ua/");
    }
    @AfterClass(description = "Quit WebDriver", alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
