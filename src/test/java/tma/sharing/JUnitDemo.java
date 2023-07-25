package tma.sharing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnitDemo {

    WebDriver driver;

    @Test
    public void LoginSuccess() {
        driver.findElement(By.id("userName")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("Admin#123");
        driver.findElement(By.id("login")).click();
        WebElement element = driver.findElement(By.className("main-header"));
        String expText = "Profile";
        try {
            assert expText.equals(element.getText());
            System.out.println("Logged to Homepage");
        } catch (Exception e) {
            System.out.println("Actual result not as expected. Actual: " + element.getText() + ", expected: " + expText);
            e.printStackTrace();
        }


    }

    @Before
    public void initSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com/login");
    }

    @After
    public void cleanup() {
        driver.close();
    }

}
