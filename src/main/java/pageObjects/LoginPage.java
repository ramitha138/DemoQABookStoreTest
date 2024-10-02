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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


/*    public String validateLoginPage(*//*String welcomeMessage*//*) {
        return label_welcome.getText();
     }*/

    public void login(String username, String password) {

        textbox_username.click();
        textbox_username.sendKeys(username);
        Reporter.log("Username entered successfully", true);

        textbox_password.click();
        textbox_password.sendKeys(password);
        Reporter.log("Pasword entered successfully", true);

        button_login.click();
    }

    public String verifyLogin() {
        return driver.getCurrentUrl();
    }
}
