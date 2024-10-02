import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import testBase.BaseSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestRunner extends BaseSetup {

    private LoginPage loginPage;
    private BookStorePage bookStorePage;
    private Properties properties;

    public TestRunner() {
        properties = new Properties();
        try {
            // Load the properties file from src/test/resources
            FileInputStream fis = new FileInputStream("src/test/resources/parameters.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void loginPage(){
        String username = properties.getProperty("login.username");
        String password = properties.getProperty("login.password");

        loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void bookStorePage(){

        bookStorePage = new BookStorePage(driver);

        bookStorePage.clickBookStoreManuButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bookStorePage.searchBook("Speaking JavaScript");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bookStorePage.updateRows("5");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
