import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Main {
    WebDriver driver;
    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.emirates.com/en");
    }

    @Test
    public void addBabies() {
        WebElement buttonContinue = driver.findElement(By.xpath("//div[@class='grid__item medium--one-fifth search-flight__continue']/a"));
        buttonContinue.click();

        WebElement addPassengers = driver.findElement(By.xpath("//div[@class='field js-fields field--has-help field--active']"));
        addPassengers.click();

        WebElement addBabies = driver.findElement(By.xpath("//div[@data-type='infants']/button"));
        addBabies.click();

        String actual = driver.findElement(By.className("passenger-inline-error")).getText();
        String expected = "You can book for max 1 Lap Infant";
        Assert.assertEquals(actual, expected);
    }

    @After
    public void close() {
        driver.close();
    }
}