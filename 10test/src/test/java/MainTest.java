import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;
import steps.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private WebDriver driver;
    private MainPageSteps mainPageSteps;
    private BaggagePageSteps baggagePageSteps;
    private HotelsPageSteps hotelsPageSteps;
    private RentalPageSteps rentalPageSteps;
    private BookingPageSteps bookingPageSteps;
    private WebDriverWait wait;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

    @BeforeMethod
    public void openPage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://www.emirates.com/en");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        mainPageSteps = new MainPageSteps(new MainPage(driver, wait));
        baggagePageSteps = new BaggagePageSteps(new BaggagePage(driver));
        hotelsPageSteps = new HotelsPageSteps(new HotelsPage(driver, wait));
        rentalPageSteps = new RentalPageSteps(new RentalPage(driver, wait));
        bookingPageSteps = new BookingPageSteps(new BookingPage(driver, wait));
    }

    @Test
    public void findWhenNumberOfInfantIsMoreThanAdults() {
        String expectedError = "You can book for max 1 Lap Infant";

        Assert.assertEquals(mainPageSteps.checkMaxCountOfBabies(2), expectedError);
    }

    @Test
    public void findWhenAllFieldsAreEmpty() {
        String expectedError = "Please choose a departure airport\n" +
                "Please choose an arrival airport\n" +
                "Please choose a departure date\n" +
                "Please choose a return date";

        Assert.assertEquals(mainPageSteps.checkWhatHappenWhenAllFieldsAreEmpty(), expectedError);
    }

    @Test
    public void findAirport() {
        String expectedError = "No results found";

        Assert.assertEquals(mainPageSteps.enterWithNotValidAriport(), expectedError);
    }

    @Test
    public void tryToEnterLastNameWhenWriteRussianLetters() {
        String expectedError = "Special characters not allowed";

        Assert.assertEquals(mainPageSteps.checkWhatHappenWhenEnterSpecialSymbols(), expectedError);
    }

    @Test
    public void maxWeightInKilos() {
        String expected = "40kgs";
        String actual;

        mainPageSteps.goToBaggagePage();
        baggagePageSteps.inputData("Moscow (DME)", "Paris (CDG)", 6, 3);

        actual = baggagePageSteps.getBaggageWeight();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkThatHotelsStayInRightCity() {
        String expectedCity = "Барселона";
        String actual;

        mainPageSteps.goToHotelsPage();
        hotelsPageSteps.findHotel("Barcelona");

        DriverManage.wait(1000);


        Set<String> tabs = driver.getWindowHandles();
        driver.switchTo().window(tabs.toArray()[1].toString());
        DriverManage.waitForPageLoadComplete(driver, 30);

        actual = bookingPageSteps.checkCityName();

         Assert.assertTrue(actual.contains(expectedCity));
    }

    @Test
    public void checkStatusOfFlightWhichDoesNotExist() {
        String expectedError = "There is an error on this page:";
        Assert.assertEquals(mainPageSteps.checkStatusOfFlights(), expectedError);
    }

    @Test
    public void checkMaxCountOfPassengersOnBoard() {
        String expectedError = "true";
        Assert.assertEquals(expectedError, mainPageSteps.checkMaxCountOfPassengers());
    }

    @Test
    public void checkWhatHappenWhenDepartureDateIsLaterThanReturnDate() {
        String expectedError = "When would you like to return?";
        Assert.assertEquals(mainPageSteps.enterDepartureDateWhichLaterThanReturnDate(), expectedError);
    }

    @Test
    public void checkThatCarsInRightLocation() {
        String expected = "86100 Châtellerault, France";
        String actual;

        mainPageSteps.goToRentalPage();

        DriverManage.wait(1000);

        Set<String> tabs = driver.getWindowHandles();
        driver.switchTo().window(tabs.toArray()[1].toString());
        DriverManage.waitForPageLoadComplete(driver, 30);

        actual = rentalPageSteps.checkLocation();

        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
