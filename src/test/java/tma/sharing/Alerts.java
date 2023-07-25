package tma.sharing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    public static void main(String[] args) throws InterruptedException {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        // Simple alert
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);

        // Confirmation alert
        driver.findElement(By.id("confirmButton")).click();
        alert.accept();
        Thread.sleep(2000);

        driver.findElement(By.id("confirmButton")).click();
        alert.dismiss();
        Thread.sleep(2000);

        // Prompt alert
        driver.findElement(By.id("promtButton")).click();
        alert.sendKeys("I'm sending something to alert");
        alert.accept();
        Thread.sleep(2000);

        driver.quit();

    }

}
