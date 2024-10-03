import org.testng.annotations.Test;
import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import testBase.BaseSetup;
import testBase.ReadProperties;

import java.io.IOException;
import java.util.Properties;

public class TestRunner extends BaseSetup {

    // Instance of pages
    private LoginPage loginPage;
    private BookStorePage bookStorePage;

    // Properties object to hold configuration
    private static Properties properties;

    // Constructor to initialize properties
    public TestRunner() {
        ReadProperties readPropertyFile = new ReadProperties();
        try {
            properties = readPropertyFile.loadProperties();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
        super();
    }

    @Test(priority = 1)
    public void loginPage(){

        String username = properties.getProperty("login.username");
        String password = properties.getProperty("login.password");

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @Test(priority = 2)
    public void bookStorePage(){

        bookStorePage = new BookStorePage(driver);

        bookStorePage.clickBookStoreMenuButton();
        bookStorePage.searchBook(properties.getProperty("bookStore.bookTitle"));
        bookStorePage.updateRows(properties.getProperty("bookStore.rownumber"));
    }
}
