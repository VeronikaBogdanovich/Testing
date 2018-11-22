import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;


public class Main {
        WebDriver driver;
        MainPage mainPage;

        @Before
        public void openPage(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.emirates.com/en");
            mainPage = new MainPage(driver);
        }

        @Test
        public void findWhenNumberOfInfantIsMoreThanAdults(){
            String expectedError = "You can book for max 1 Lap Infant";
            Assert.assertEquals(mainPage.maxCountOfBabies(), expectedError);
        }

        @After
        public void close(){
        driver.close();
        }
}
