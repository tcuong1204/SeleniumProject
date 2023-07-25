package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        // Use frame(element)
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        // Use frame(index)
//        int size = driver.findElements(By.tagName("iframe")).size();
//        System.out.println("Frame size: " + size);
//        driver.switchTo().frame(0);
//        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
//        driver.switchTo().defaultContent();

        // Use frame(nameOrId)
        driver.switchTo().frame("frame2"); // frame2 is id of frame
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        driver.quit();


    }

}
