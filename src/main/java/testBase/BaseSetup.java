package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSetup {

    // Protected WebDriver instance to be used in derived classes
    protected WebDriver driver;
    private static Properties properties;
    // Properties to hold configuration details
    String driverPath = properties.getProperty("base.driver.dir");

    // Constructor to initialize properties and driver path
    public BaseSetup() {
        ReadProperties readPropertyFile = new ReadProperties();
        try {
            properties = readPropertyFile.loadProperties();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
        super();
    }

    // Setup method to initialize the WebDriver before tests
    @BeforeTest
    public void setup() {
        // Configure Chrome options for the WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-cache");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");

        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
        driver = new ChromeDriver(options);

        driver.get(properties.getProperty("base.url"));
    }

    // Teardown method to quit the WebDriver after tests
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
