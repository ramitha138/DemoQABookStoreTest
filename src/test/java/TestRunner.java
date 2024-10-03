import org.testng.annotations.Test;
import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import testBase.BaseSetup;
import testBase.ReadProperties;

import java.io.IOException;
import java.util.Properties;

public class TestRunner extends BaseSetup {

    private LoginPage loginPage;
    private BookStorePage bookStorePage;

    static Properties properties;

    public TestRunner() {
        ReadProperties readPropertyFile = new ReadProperties();
        try {
            properties = readPropertyFile.loadProperties();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    @Test(priority = 1)
    public void loginPage(){

        String username = properties.getProperty("login.username");
        String password = properties.getProperty("login.password");

        try {
            loginPage = new LoginPage(driver);
            loginPage.login(username, password);

        } catch (IllegalArgumentException e) {
            System.out.println("Exception : " + e);
        }
    }

    @Test(priority = 2)
    public void bookStorePage(){

        try {

        bookStorePage = new BookStorePage(driver);

        bookStorePage.clickBookStoreManuButton();
        bookStorePage.searchBook(properties.getProperty("bookStore.bookTitle"));
        bookStorePage.updateRows(properties.getProperty("bookStore.rownumber"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception : " + e);
        }
    }
}
