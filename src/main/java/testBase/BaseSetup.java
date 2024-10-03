package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSetup {

    protected WebDriver driver;
    private static Properties properties;
    String driverPath = properties.getProperty("base.driver.dir");

    public BaseSetup() {
        ReadProperties readPropertyFile = new ReadProperties();
        try {
            properties = readPropertyFile.loadProperties();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
        super();
    }

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-cache");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
        /*WebDriver*/ driver = new ChromeDriver(options);

        driver.get(properties.getProperty("base.url"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
