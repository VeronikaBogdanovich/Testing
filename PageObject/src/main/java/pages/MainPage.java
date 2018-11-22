package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='widget__tab-wrapper widget--items4']")
    private WebElement content;

    @FindBy(xpath = "//div[@class='grid__item medium--one-fifth search-flight__continue']/a")
    private WebElement Continue;

    @FindBy(xpath = "//div[@class='field js-fields field--has-help field--active']")
    private WebElement OpenPassengersDropdown;

    @FindBy(xpath = "//div[@data-type='infants']/button")
    private WebElement AddBabies;

    @FindBy(className = "passenger-inline-error")
    private WebElement babiesErrorText;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String maxCountOfBabies() {
        scrollToContent();
        clickToContinue();
        clickToAddNewPassenger();
        addInfants();
        return babiesErrorText.getText();
    }
    private MainPage scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", content);
        return this;
    }

    private MainPage clickToContinue() {
        Continue.click();
        return this;
    }

    private MainPage clickToAddNewPassenger() {
        OpenPassengersDropdown.click();
        return this;
    }

    private MainPage addInfants() {
        AddBabies.click();
        return this;
    }



    }