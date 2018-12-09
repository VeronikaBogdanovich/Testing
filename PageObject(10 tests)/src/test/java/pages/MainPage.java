package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private final WebDriverWait wait;
    private WebDriver driver;

    //BABIES
    @FindBy(xpath = "//div[@class='grid__item medium--one-fifth search-flight__continue']/a")
    private WebElement Continue;

    @FindBy(xpath = "//div[@class='field js-fields field--has-help field--active']")
    private WebElement OpenPassengersDropdown;

    @FindBy(xpath = "//div[@data-type='infants']/button[@class='js-increment-increase increment-field__button increment-field__increase']")
    private WebElement AddBabies;

    @FindBy(className = "passenger-inline-error")
    private WebElement babiesErrorText;

    //EMPTY FIELDS
    @FindBy(xpath = "//ul[@class='widget__inline__error_listing']")
    private WebElement errors;

    @FindBy(xpath = "//div[@class='grid__item medium--one-third']/form")
    private WebElement Search;

    //AIRPORTS
    @FindBy(xpath = "//input[@name='Departure airport']")
    private WebElement departute;

    @FindBy(xpath = "//input[@name='Arrival airport']")
    private WebElement arrival;

    @FindBy(xpath = "//h3[@class='location__global__heading--no-results']")
    private WebElement errorAirport;

    //BAGGAGE
    @FindBy(xpath = "//a[@data-link='MANAGE']")
    private WebElement headerManageLink;

    @FindBy(xpath = "//a[@data-link='MANAGE:Baggage']")
    private WebElement headerManageBaggageLink;

    @FindBy(xpath = "//a[@data-link='MANAGE:Baggage:Baggage calculator:Baggage calculator']")
    private WebElement baggageCalculator;

    @FindBy(xpath = "//li[@id='tab1']")
    private WebElement manage;

    @FindBy(xpath = "//input[@name='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//p[@class='field__error js-error show']")
    private WebElement errorLastName;

    //STATUS
    @FindBy(xpath = "//li[@id='tab3']")
    private WebElement status;

    @FindBy(xpath = "//label[@for='flight-status-number-radio']")
    private WebElement typeOfEnter;

    @FindBy(xpath = "//label[@for='check-flight__flight-number-status']")
    private WebElement numberLabel;

    @FindBy(xpath = "//input[@name='Flight number']")
    private WebElement numberInput;

    @FindBy(xpath = "//*[@id=\"panel3\"]/div/div/div/section/div[4]/div[2]/div[2]/div/div[2]/button")
    private WebElement checkStatus;

    @FindBy(xpath = "//span[@role='alert']")
    private WebElement errorStatus;

    //PASSENGERS
    @FindBy(xpath = "//div[@data-type='adults']/button")
    private WebElement addAdults;

    //DATE
    @FindBy(xpath = "//label[@for='search-flight-date-picker--depart']")
    private WebElement departingDate;

    @FindBy(xpath = "//label[@for='search-flight-date-picker--return']")
    private WebElement returningDate;

    @FindBy(xpath = "//td[@class='ek-datepicker__day']")
    private List<WebElement> availableDates;

    @FindBy(xpath = "//h2[@class='ek-datepicker__header-text']")
    private WebElement dateError;

    //CAR PAGE
    @FindBy(xpath = "//a[@data-name='Car rentals']")
    private WebElement rental;

    // HOTELS PAGE
    @FindBy(xpath = "//a[@data-name='Hotels']")
    private WebElement hotels;


    public MainPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }


    //DATE
    public MainPage addDepartingDate(int numberOfDaysFromNow){
        wait.until(ExpectedConditions.elementToBeClickable(departingDate)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ek-datepicker__day']")));
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    public MainPage addReturningDate(int numberOfDaysFromNow){
        wait.until(ExpectedConditions.elementToBeClickable(returningDate)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ek-datepicker__day']")));
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    //PASSENGERS
    public MainPage addPassengers(int num) {
        for (int i = 0; i < num; i++){
            wait.until(ExpectedConditions.elementToBeClickable(addAdults)).click();
        }


        return this;
    }

    //RUSSIAN
    public MainPage goToManageTab() {
        manage.click();
        return this;
    }

    public MainPage enterLastName() {
        lastName.sendKeys("Вероника");
        return this;
    }

    //STATUS
    public MainPage goToStatusTab(){
        status.click();
        return this;
    }

    public MainPage chooseTypeOfEnter(){
        typeOfEnter.click();
        return this;
    }

    public MainPage goToEnterNumber(){
        numberLabel.click();
        return this;
    }

    public MainPage enterNumber(String number){
        numberInput.sendKeys(number);
        return this;
    }

    public MainPage goToPageWithStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(checkStatus)).click();
        return this;
    }

    //AIRPORTS
    public MainPage enterAirports(String departure, String arrive) {
        wait.until(ExpectedConditions.visibilityOf(departute)).sendKeys(departure);
        wait.until(ExpectedConditions.visibilityOf(arrival)).sendKeys(arrive);
        return this;
    }

    //EMPTY FIELDS
    public MainPage clickToContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
        return this;
    }

    public MainPage searchRaces() {
        Search.click();
        return this;
    }


    //BABIES
    public MainPage openNewPassengerDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(OpenPassengersDropdown)).click();
        return this;
    }

    public MainPage addInfants(int times) {
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(AddBabies)).click();
        }
        return this;
    }


    //ERRORS
    public String getBabiesError() {
        return wait.until(ExpectedConditions.visibilityOf(babiesErrorText))
                .getText();
    }

    public String getEmptyFieldsError() {
        return errors.getText();
    }

    public String getAirportError() {
        return wait.until(ExpectedConditions.visibilityOf(errorAirport)).getText();
    }

    public String getLastNameError() {
        return errorLastName.getText();
    }

    public String getStatusError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='alert']")));

        return errorStatus.getText();
    }

    public String getValueError(){
        wait.until(ExpectedConditions.attributeToBe(addAdults, "aria-disabled", "true"));
        return addAdults.getAttribute("aria-disabled");
    }

    public String getDateError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='ek-datepicker__header-text']")));

        return dateError.getText();
    }


    //OPEN PAGE
    public MainPage openManageMenu() {
        headerManageLink.click();
        return this;
    }

    public MainPage openManageBaggageMenu() {
        headerManageBaggageLink.click();
        return this;
    }

    public MainPage openBaggageCalculator() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        baggageCalculator.click();
        return this;
    }

    public MainPage openHotelBooking() {
        hotels.click();
        return this;
    }

    public MainPage openCarRental(){
      wait.until(ExpectedConditions.elementToBeClickable(rental)).click();
      return this;
    }
}