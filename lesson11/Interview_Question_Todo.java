package lesson11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Interview_Question_Todo {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://todomvc.com/examples/react");
    }

    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void creatingNewMission() {
        String[] todoList = {"Go to the Market", "Doctor Check", "Visit the parents", "Give food to the dog", "Go drink with the Team"};
        String click = Keys.chord(Keys.ENTER);
        for (int i = 0; i < todoList.length; i++) {
            driver.findElement(By.className("new-todo")).sendKeys(todoList[i]);
            driver.findElement(By.className("new-todo")).sendKeys(click);
        }
    }

    @Test(priority = 1)
    public void delete() {
        WebElement element = driver.findElement(By.xpath("//li[1]//div"));
        actions.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//li[1]//div[1]//button[1]")).click();
    }

    @Test(priority = 2)
    public void rename() {
        WebElement element = driver.findElement(By.xpath("//li[2]//div"));
        actions.moveToElement(element).doubleClick().doubleClick().build().perform();
        String delete = Keys.chord(Keys.DELETE);
        actions.sendKeys(delete).perform();
        actions.sendKeys("Buy some beers :)");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test(priority = 3)
    public void markCompleted() {
        driver.findElement(By.xpath("//li[3]//div[1]//input[1]")).click();
    }

    @Test(priority = 4)
    public void missionFilter() throws InterruptedException {
        driver.findElement(By.linkText("Active")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Completed")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("All")).click();
    }

    @Test(priority = 5)
    public void deleteMission() {
        driver.findElement(By.className("clear-completed")).click();
    }
}
