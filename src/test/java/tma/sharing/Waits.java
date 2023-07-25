package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        // Wait methods
        // Implicit wait: Loaded all elements on web page
        System.out.println("Implicit wait");
        getCurrentDateTime();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getCurrentDateTime();
        System.out.println("Wait complected");

        // Explicit Wait: wait for a specific element on the page until the given condition is satisfied
        System.out.println("Explicit wait");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        getCurrentDateTime();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        getCurrentDateTime();

        // Fluent wait
        System.out.println("Fluent wait");
        driver.navigate().refresh();
        getCurrentDateTime();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
        			.withTimeout(Duration.ofSeconds(10))
        			.pollingEvery(Duration.ofSeconds(2))
        			.ignoring(NoSuchElementException.class);
        WebElement element = fluentWait.until(e -> e.findElement(By.id("visibleAfter")));
        getCurrentDateTime();

    }

    static void getCurrentDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }

}
