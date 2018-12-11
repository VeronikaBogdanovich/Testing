package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HotelsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='product-block-wrapper']")
    private WebElement secondContent;

    @FindBy(xpath = "//a[@data-name='Hotels']")
    private WebElement hotels;

    @FindBy(id = "seldcity1_txtAutoComplete")
    private WebElement cityInput;

    @FindBy(xpath = "//div[@class='lp-widget__button-holder']")
    private WebElement findHotelsButton;

    @FindBy(xpath = "//ul[@class='eol-dropdown-list__item-ct']/li[1]")
    private WebElement chooseCity;


    public HotelsPage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = webDriverWait;
    }

    public HotelsPage enterCity(String name) {
        // wait for page is load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("seldcity1_txtAutoComplete")))
                .sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(chooseCity)).click();
        return this;
    }

    public HotelsPage findHotels() {
        sleep();
        findHotelsButton.click();
        return this;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
