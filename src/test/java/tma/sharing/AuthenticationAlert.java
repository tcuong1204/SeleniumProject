package tma.sharing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticationAlert {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Way 1
        // URL: https://the-internet.herokuapp.com/basic_auth
        String username = "admin", password = "admin";
        String url = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.navigate().to(url);


    }

}
