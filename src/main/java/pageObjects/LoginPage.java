package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

import java.util.Properties;

public class LoginPage {

    private WebDriver driver;
    private Properties properties;

    @FindBy(xpath = "//form[@id='userForm']//h2")
    WebElement label_welcome;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement textbox_username;

    @FindBy(id = "password")
    WebElement textbox_password;
    @FindBy(id = "login")
    WebElement button_login;

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to perform login using the provided username and password
    public void login(String username, String password) {

        // Click the username input field and enter the username
        textbox_username.click();
        textbox_username.sendKeys(username);
        Reporter.log("Username entered successfully", true);

        // Click the password input field and enter the password
        textbox_password.click();
        textbox_password.sendKeys(password);
        Reporter.log("Pasword entered successfully", true);

        button_login.click();
    }

    // Method to verify the login by returning the current URL
    public String verifyLogin() {
        return driver.getCurrentUrl();
    }
}
