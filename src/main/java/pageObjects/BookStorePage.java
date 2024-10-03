package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import java.time.Duration;

public class BookStorePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-2' and position()=2]")
    WebElement Menu_BookStore;

    @FindBy(xpath = "//input[@id='searchBox']")
    WebElement textbox_search;

    @FindBy(xpath = "//div[@class='rt-tbody']/div")
    WebElement table_columns;
    @FindBy(xpath = "//select[@aria-label='rows per page']")
    WebElement dropdown_rows;

    // Constructor to initialize the WebDriver and WebDriverWait
    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to click the Book Store menu button
    public void clickBookStoreMenuButton() {
        wait.until(ExpectedConditions.visibilityOf(Menu_BookStore));
        Menu_BookStore.click();
        Reporter.log("Book Store menu button clicked successfully", true);
    }

    // Method to search for a book by its name
    public void searchBook(String bookName) {

        wait.until(ExpectedConditions.elementToBeClickable(textbox_search));
        textbox_search.click();
        textbox_search.sendKeys(bookName);
        textbox_search.sendKeys(Keys.ENTER);
        Reporter.log("Search keword entered successfully", true);
    }

    // Method to update the number of rows displayed in the table
    public void updateRows(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdown_rows));
        Select rowsDropdown = new Select(dropdown_rows);
        rowsDropdown.selectByValue(value);
        Reporter.log("Successfully selected :"+value+"Rows option", true);
        Assert.assertEquals("5", value, "The rows per page value does not match the expected value!");
    }
}
