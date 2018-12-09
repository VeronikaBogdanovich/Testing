package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaggagePage {
    private final WebDriver driver;

    @FindBy(id = "MainContent_ctl03_txtDepartureCity-suggest")
    private WebElement departureInput;

    @FindBy(id = "MainContent_ctl03_txtArrivalCity-suggest")
    private WebElement arrivalInput;

    @FindBy(xpath = "//select[@id='MainContent_ctl03_ddlTravelClass']")
    private WebElement classSelect;

    @FindBy(xpath = "//select[@id='MainContent_ctl03_ddlTier']")
    private WebElement membershipSelect;

    @FindBy(id = "MainContent_ctl03_imgSubmit")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div[4]/div/div/div[2]/div[3]/div[2]/span[1]")
    private WebElement weight;

    public BaggagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BaggagePage inputDeparture(String name) {
        departureInput.sendKeys(name);
        return this;
    }

    public BaggagePage inputArrival(String name) {
        arrivalInput.sendKeys(name);
        return this;
    }

    public BaggagePage inputClass(int number) {
        classSelect.click();

        String selector = "//select[@id='MainContent_ctl03_ddlTravelClass']/option[" + number + "]";
        driver.findElement(By.xpath(selector)).click();

        return this;
    }

    public BaggagePage inputMembership(int number) {
        membershipSelect.click();

        String selector = "//select[@id='MainContent_ctl03_ddlTier']/option[" + number + "]";
        driver.findElement(By.xpath(selector)).click();

        return this;
    }

    public BaggagePage search() {
        searchButton.click();
        return this;
    }

    public String getBaggageWeight() {
        return weight.getText();
    }
}
