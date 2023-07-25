package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstDemo {


    public static void main(String[] args) throws InterruptedException {

        // Declare for WebDriver

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form"); // Go to url

        // Uncomment code below to use Firefox driver
        // System.setProperty("webdriver.firefox.driver", "src/main/resources/webdriver/geckodriver");
        // WebDriver driver = new FirefoxDriver();


        // Select locators
        // By.id
        driver.findElement(By.id("firstName")).sendKeys("standard_user");
        driver.findElement(By.id("firstName")).clear();
        Thread.sleep(2000);

        // By.className
        driver.findElement(By.className("form-control")).sendKeys("admin_user");;
        Thread.sleep(2000);

        // By.name
        System.out.println(driver.findElement(By.name("gender")).getText());
        Thread.sleep(2000);

        // By.name
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("standard_user");
        Thread.sleep(2000);

        // By.tagName
        System.out.println(driver.findElement(By.tagName("h5")).getText());
        Thread.sleep(2000);

        // By.xPath
        driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys("012345678");
        Thread.sleep(2000);
        driver.navigate().back();

        // Navigate to another page for test other types
        driver.navigate().to("https://demoqa.com/broken");

        // By.linkText
        driver.findElement(By.linkText("Click Here for Valid Link")).click();
        Thread.sleep(2000);
        driver.navigate().back();

        // By.partialLinkText
        driver.findElement(By.partialLinkText("Click Here")).click();
        Thread.sleep(2000);
        driver.navigate().back();


        // WebDriver commands
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.manage().window().maximize();
        driver.manage().window().minimize();


        // Close window
        driver.close();


    }


}
