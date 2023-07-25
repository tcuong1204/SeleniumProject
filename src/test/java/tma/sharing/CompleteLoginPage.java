package tma.sharing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompleteLoginPage {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("");

    }

}
