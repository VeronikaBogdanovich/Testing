import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // go to the webpage and select "Find races"
        driver.get("https://www.emirates.com/ru");
        driver.manage().window().maximize();

        // insert in take off input our text
        By continueSelector = By.cssSelector("#panel0 > div > div > div > section > div:nth-child(4) > div:nth-child(1) > div.grid__item.medium--one-fifth.search-flight__continue > a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueSelector));
        WebElement buttonContinue = driver.findElement(continueSelector);
        buttonContinue.click();

//         Open add passengers dropdown
        By addPassengersSelector = By.cssSelector("#tcm\\3a 69-13437");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addPassengersSelector));
        WebElement addPassengers = driver.findElement(addPassengersSelector);
        addPassengers.click();


//        Add one baby
        By addBabySelector = By.xpath("//*[@id=\"panel0\"]/div/div/div/section/div[4]/div[2]/div[1]/div[1]/div/div[2]/section/div[5]/button[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addBabySelector));
        WebElement addBabies = driver.findElement(addBabySelector);
        addBabies.click();

//         Compare actual value with expected
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("passenger-inline-error")));
        String actual = driver.findElement(By.className("passenger-inline-error")).getText();
        String expected = "Максимальное число пассажиров (Младенцы), для которых вы можете забронировать билеты, — 1.";

        System.out.println(actual.equals(expected) ? "Expected equals actual" : "Expected not equal actual");

//        if we want to wait 5 seconds before browser will be closed, uncomment the line below
//        Thread.sleep(5000);

        driver.close();
    }
}
