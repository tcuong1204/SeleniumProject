package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to element
        WebElement element = driver.findElement(By.id("see-book-Understanding ECMAScript 6"));
        js.executeScript("arguments[0].scrollIntoView();", element);

        // Scroll to position
        js.executeScript("window.scroll(0, 200)");

        // Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Scroll to top
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

        driver.quit();

    }

}
