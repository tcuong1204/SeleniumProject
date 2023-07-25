package tma.sharing;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // or
//        options.addArguments("headless"); // or
//        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/radio-button");


        // Check radio state, if enabled, select it
        WebElement element = driver.findElement(By.xpath("//label[@for=\"yesRadio\"]"));
        if (element.isEnabled()) {
            System.out.println("This option can be selected, will select it in next step");
            element.click();

            // Validate
            if (driver.findElement(By.xpath("//*[@id=\"yesRadio\"]")).isSelected()) {
                System.out.println("Selected option");
            }
            else {
                System.out.println("Option not selected");
                // throw new NoSuchElementException("Option unselected as expected");
            }
        }

        // For disable case
        element = driver.findElement(By.xpath("//label[@for=\"noRadio\"]"));
        System.out.println("This option is displayed: " + element.isDisplayed());
        System.out.println("This option is disabled: " + element.isEnabled());

        driver.quit();

    }

}
