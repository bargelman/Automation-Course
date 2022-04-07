package lesson11.todoApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class todoTests extends todoMethods {
    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://todomvc.com/examples/react");
    }

    @AfterClass
    public void closer() throws InterruptedException {
        driver.quit();
    }

    @BeforeMethod
    public void before() {
        createItem("AAA");
        createItem("BBB");
        createItem("CCC");
        createItem("DDD");
    }

    @AfterMethod
    public void after() {
        filterAll();
//        deleteAllMissions();
        deleteAllMissions2();
    }

    @Test(priority = 0)
    public void createMissions() {

        String actual = Integer.toString(missionsList().size());
        String expected = driver.findElement(By.tagName("strong")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void filterCompleted() {
        int counterBefore = missionsList().size();
        goToCompleted(2);
        int counterAfter = missionsList().size();
        String counter = Integer.toString(counterBefore - counterAfter);
        String expected = driver.findElement(By.tagName("strong")).getText();
        Assert.assertEquals(counter, expected);
    }

    @Test(priority = 2)
    public void filterActive() {
        goToCompleted(1);
        goToActive();
        Assert.assertEquals(missionsList().size(), 3);
    }

    @Test(priority = 3)
    public void clearCompletedMission() {
        goToCompleted(1);
        clearCompleted();
        filterAll();
        Assert.assertEquals(missionsList().size(), 3);
    }

    @Test(priority = 4)
    public void renameMission() {
        rename(2 , "Buy some beers");
    }

    @Test(priority = 5)
    public void MissionDeleted() {
        deleteFirstMission();
        Assert.assertEquals(missionsList().size(), 3);
    }
}
