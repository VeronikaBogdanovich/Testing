import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/veronikabogdanovich/Documents/Angular-testing/node_modules/protractor/node_modules/webdriver-manager/selenium/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // go to the webpage and select "Find races"
        driver.get("https://www.emirates.com/ru");

        // insert in take off input our text
        WebElement buttonContinue = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#panel0 > div > div > div > section > div:nth-child(4) > div:nth-child(1) > div.grid__item.medium--one-fifth.search-flight__continue > a")));
        buttonContinue.click();

//         Click 8 times on add adult passenger button to make maximum of adults
        WebElement addPasengers = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tcm\\3a 69-13437")));
        addPasengers.click();


        WebElement addBabies = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#panel0 > div > div > div > section > div:nth-child(4) > div.search-flight--hidden-container.grid > div.grid__item.medium--one-third.search-flight__passengers > div.js-dropdown.dropdown-container.dropdown-container--has-help.show > div > div.dropdown > section > div:nth-child(7) > button.js-increment-increase.increment-field__button.increment-field__increase")));
        addBabies.click();

        // Compare actual value with expected
        String actual = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("passenger-inline-error"))).getText();
        String expected = "Максимальное число пассажиров (Младенцы), для которых вы можете забронировать билеты, — 1.";

        System.out.println(actual.equals(expected) ? "Expected equals actual" : "Expected not equal actual");
        driver.close();
    }
}
