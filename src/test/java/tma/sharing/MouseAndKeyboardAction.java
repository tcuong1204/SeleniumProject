package tma.sharing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardAction {

    public static void main(String[] args) {

        // Declare for WebDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/selectable");
        driver.manage().window().maximize();

        // Mouse action

        WebElement element = driver.findElement(By.xpath("//div[text()=\"Selectable\"]"));
        Actions actions = new Actions(driver);
        Action doubleClick = actions
                .doubleClick(element)
//                .contextClick()
                .build();
        doubleClick.perform();

        // Mouse drag and drop
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        Action dragAndDrop = actions
                .dragAndDrop(dragElement, dropElement)
                .build();
        dragAndDrop.perform();

        // Keyboard action
        driver.navigate().to("https://demoqa.com/text-box");
        element = driver.findElement(By.id("userName"));
        element.sendKeys("MyUsername");

        // Select the Current Address using CTRL + A
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        // Copy the Current Address using CTRL + C
        actions.keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        // Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();

        // Paste the Address in the Permanent Address field using CTRL + V
        actions.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        driver.quit();

    }
}
