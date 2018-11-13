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
    private WebDriver driver;

    /**
     * Button "Continue"
     */
    @FindBy(css = "div.search-flight__continue > a")
    private WebElement bContinue;

    @FindBy(css = "#tcm\\3a 69-13437")
    private WebElement bOpenPassengersDropdown;

    @FindBy(xpath = "//span[text()='Младенцы']/../../../button[contains(@class, 'increment-field__increase')]")
    private WebElement bAddBabies;

    @FindBy(className = "passenger-inline-error")
    private WebElement babiesErrorText;

    @FindBy(xpath = "//button[contains(text(), 'Искать')]")
    private WebElement bFindRaces;

    public MainPage(WebDriver driver) {
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