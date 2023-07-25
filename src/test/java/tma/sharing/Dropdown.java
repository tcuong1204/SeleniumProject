package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

        // Select value
        Select element = new Select(driver.findElement(By.id("oldSelectMenu")));

        element.selectByIndex(1);
        Thread.sleep(2000);

        element.selectByValue("6"); // Select white color
        Thread.sleep(2000);

        element.selectByVisibleText("Yellow");
        Thread.sleep(2000);

        System.out.print("Current selected option: ");
        List<WebElement> selectedOption = element.getAllSelectedOptions();
        for (WebElement select: selectedOption) {
            System.out.print(select.getText() + ", ");
        }

        System.out.print("\nAll options: ");
        List<WebElement> options = element.getOptions();
        for (WebElement option: options) {
            System.out.print(option.getText() + ", ");
        }


        // Select multiple options
        element = new Select(driver.findElement(By.id("cars")));
        System.out.println("\nThis is multiselect: " + element.isMultiple());
        element.selectByIndex(0);
        Thread.sleep(1000);
        element.selectByIndex(1);
        Thread.sleep(1000);
        element.selectByIndex(3);
        Thread.sleep(1000);
        element.deselectAll();

        element.selectByVisibleText("Volvo");
        Thread.sleep(1000);
        element.selectByVisibleText("Audi");
        Thread.sleep(1000);
        element.deselectByValue("volvo");
        Thread.sleep(1000);


        // Select option in new style Dropdown menu (not in <select></select> tag)
        // With an option allowed
        driver.findElement(By.id("withOptGroup")).click();
        driver.findElement(By.xpath("//*[text()=\"A root option\"]")).click();

        // With multiple option allowed
        driver.findElement(By.xpath("//*[text()=\"Select...\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()=\"Green\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()=\"Black\"]")).click();
        Thread.sleep(2000);

        // Clear all selected options
        driver.findElement(By.xpath("(//*[@class=\" css-2b097c-container\"])[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[2]/div[1]")).click(); // Click on X button to clear
        Thread.sleep(2000);


        driver.quit();

    }

}
