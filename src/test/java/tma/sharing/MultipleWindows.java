package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        String currentTab = driver.getWindowHandle();

        // Handle Tab
//        driver.findElement(By.id("tabButton")).click(); // Open new tab
//        for (String tab: driver.getWindowHandles()) {
//            if (!tab.equals(currentTab)) {
//                driver.switchTo().window(tab);
//            }
//        }
//
//        String expText = "This is a sample page";
//        String actText = driver.findElement(By.id("sampleHeading")).getText();
//        if (actText.equals(expText)) {
//            System.out.println("Test complected");
//        } else {
//            System.out.println("Test failed");
//        }
//
//        driver.quit();


        // Handle window same as tab
        driver.findElement(By.id("windowButton")).click(); // Open new tab
        for (String window: driver.getWindowHandles()) {
            if (!window.equals(currentTab)) {
                driver.switchTo().window(window);
            }
        }

        String expText = "This is a sample page";
        String actText = driver.findElement(By.id("sampleHeading")).getText();
        if (actText.equals(expText)) {
            System.out.println("Test complected");
        } else {
            System.out.println("Test failed");
        }

        driver.switchTo().window(currentTab);

        driver.quit();

    }

}
