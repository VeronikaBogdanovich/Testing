package pages;

import entity.Race;
import exceptions.TooManyBabiesException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private static String URL_MATCH = "/";
    private WebDriver driver;

    /**
     * Button "Continue"
     */
    @FindBy(css = "#panel0 > div > div > div > section > div:nth-child(4) > div:nth-child(1) > div.grid__item.medium--one-fifth.search-flight__continue > a")
    private WebElement bContinue;

    @FindBy(css = "[id=\"\\39 5528ef3-10ab-4f78-a8d0-d41a56dafd6f\"]")
    private WebElement iAirportFrom;

    @FindBy(css = "other selector")
    private WebElement iAirportTo;

    @FindBy(css = "#tcm\\3a 69-13437")
    private WebElement bOpenPassengersDropdown;

    @FindBy(xpath = "//*[@id=\"panel0\"]/div/div/div/section/div[4]/div[2]/div[1]/div[1]/div/div[2]/section/div[5]/button[1]")
    private WebElement bAddBabies;

    @FindBy(className = "passenger-inline-error")
    private WebElement babiesErrorText;

    @FindBy(xpath = "//*[@id=\"panel0\"]/div/div/div/section/div[4]/div[2]/div[3]/form/button")
    private WebElement bFindRaces;

    public MainPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException("This is not the page you are expected");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void waitForVisibility(WebElement element) throws Error {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void findRace(Race race) throws TooManyBabiesException {
        chooseAirports(race.airportFrom, race.airportTo);
        bContinue.click();

        setDate(race.dateFrom, race.dateTo);
        setPassengers(race.adults, race.children, race.babies);
        setClass(race._class);

        bFindRaces.click();
    }

    private void chooseAirports(String airportFrom, String airportTo) {
//        if (airportFrom != null && airportFrom.length() > 0) {
//            iAirportFrom.sendKeys(airportFrom);
//        }
//
//        if (airportTo != null && airportTo.length() > 0) {
//            iAirportTo.sendKeys(airportTo);
//        }
    }

    private void setDate(String dateFrom, String dateTo) {
        // unnecessary for my test
    }

    private void setPassengers(int adults, int children, int babies) throws TooManyBabiesException {
        bOpenPassengersDropdown.click();    // open dropdown

        if (adults > 0) {
            // add adults
        }

        if (children > 0) {
            // add children
        }

        if (babies > 0) {
            for (int i = 0; i < babies; i++) {
                waitForVisibility(bAddBabies);
                bAddBabies.click();
            }

            if (checkBabiesError()) {
                throw new TooManyBabiesException(babiesErrorText.getText());
            }
        }
    }

    private void setClass(int _class) {
        // unnecessary for my test
    }

    private boolean checkBabiesError() {
        try {
            babiesErrorText.getText();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}