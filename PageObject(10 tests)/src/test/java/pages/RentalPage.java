package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RentalPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='pickupLocation']")
    private WebElement city;

    @FindBy(xpath = "//li[@id='item-0-0']")
    private WebElement chooseCity;

    @FindBy(xpath = "//input[@id='pickupDate']")
    private WebElement pickUpDate;

    @FindBy(xpath = "//input[@id='returnDate']")
    private WebElement returnDate;

    @FindBy(xpath = "//td[@data-comp-id='ct-calendar-date-true']")
    private List<WebElement> availableDates;

    @FindBy(xpath = "//button[@name='searchCarsFormBtn']")
    private WebElement search;

    @FindBy(xpath = "//p[@class='ct-break-word']")
    private WebElement error;

    public RentalPage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = webDriverWait;
    }

    public RentalPage enterCity(String name){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pickupLocation")));
        city.sendKeys(name);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("item-0-0")));
        chooseCity.click();
        return this;
    }

    public RentalPage enterPickUpDate(int numberOfDaysFromNow){
        pickUpDate.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    public RentalPage enterReturnDate(int numberOfDaysFromNow){
        returnDate.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    public RentalPage clickToSearch(){
        search.click();
        return this;
    }

    public String getError(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ct-break-word")));
        return error.getText();}

}
