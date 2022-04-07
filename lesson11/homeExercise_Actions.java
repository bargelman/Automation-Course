package lesson11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class homeExercise_Actions {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_actions.html");
    }

    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void dragAndDrop() {
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        action.dragAndDrop(source, target).perform();
        String actual = driver.findElement(By.cssSelector("div[id='droppable'] p")).getText();
        String expected = "Dropped!";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void list() throws InterruptedException {
        List<WebElement> list = driver.findElements(By.xpath("//ol[@id='select_items']/li"));
        action.clickAndHold(list.get(0)).clickAndHold(list.get(1));
        Thread.sleep(2000);
        action.build().perform();
        Thread.sleep(2000);
        List<WebElement> mark = driver.findElements(By.tagName("li"));
        for (int i = 0; i < mark.size(); i++) {
            if (!mark.get(i).getAttribute("class").equals("ui-widget-content ui-selectee")) {
                String actual = mark.get(i).getText();
                String expected = "Item ";
                Assert.assertEquals(actual , expected + (i + 1));
            }
        }
    }
    @Test(priority = 2)
    public void doubleClick(){
        WebElement element = driver.findElement(By.id("dbl_click"));
       action.moveToElement(element).doubleClick().perform();
       String actual = driver.findElement(By.id("demo")).getText();
       String expected = "Hello World";
       Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void mouseHover(){
        WebElement element = driver.findElement(By.id("mouse_hover"));
        action.moveToElement(element).perform();
        Assert.assertEquals(element.getAttribute("style"), "background-color: rgb(255, 255, 0);");
    }
    @Test(priority = 4)
    public void scrollDown(){
        ((JavascriptExecutor)driver).executeScript("scrollTo(0, 1000)");
        String actual = driver.findElement(By.id("scrolled_element")).getText();
        Assert.assertEquals(actual, "This Element is Shown When Scrolled");
    }
}
