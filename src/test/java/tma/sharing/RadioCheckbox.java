package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class RadioCheckbox {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

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


        // Checkbox
        String cbxLocationForCheck = "//span[text()=\"Replace\"]//parent::label//child::span[@class=\"rct-checkbox\"]";
        String cbxLocationForValidate = "//span[text()=\"Replace\"]//parent::label//child::input";

        driver.navigate().to("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//button[@title=\"Expand all\"]")).click(); // Expand all checkboxes
        element = driver.findElement(By.xpath(cbxLocationForCheck.replace("Replace", "Desktop"))); // Select Desktop checkbox, it will select all children in it
        element.click();

        // Validation
        String[] cbxChecked = {"Desktop", "Notes", "Commands"};
        for (String checkbox: cbxChecked) {
            if (driver.findElement(By.xpath(cbxLocationForValidate.replace("Replace", checkbox))).isSelected()) {
                System.out.println("Checkbox " + checkbox + " has selected");
            } else {
                System.out.println("Checkbox " + checkbox + " not selected");
            }
        }

        // Same as radio, it also has isDisplayed(), isEnabled()

        driver.quit();

    }


}
