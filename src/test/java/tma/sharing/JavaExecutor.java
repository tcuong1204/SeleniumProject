package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaExecutor {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        // Declare for JavaScripExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        // Execute the script
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        jse.executeScript("arguments[0].setAttribute('value', 'MyFirstName')", firstNameElement); // Way 1
        driver.navigate().refresh();
        jse.executeScript("document.getElementById('firstName').setAttribute('value', 'MyFirstName')"); // Way 2

        WebElement maleElement = driver.findElement(By.id("gender-radio-1"));
        jse.executeScript("arguments[0].click();", maleElement); // Way 1
        driver.navigate().refresh();
        jse.executeScript("document.getElementById('gender-radio-1').click()"); // Way 2


        driver.quit();
    }

}
