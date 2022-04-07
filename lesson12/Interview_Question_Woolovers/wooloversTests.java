package lesson12.Interview_Question_Woolovers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
public class wooloversTests extends wooloversMethods {
    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wooloverslondon.com/");
    }

    @AfterClass
    public void closer() throws InterruptedException {
//        Thread.sleep(3000);
        driver.quit();
    }
    @Test(priority = 0)
    public void popupsCloser(){
        popup1();
        popup2();
    }
    @Test(priority = 1)
    public void newIn(){
        newInSection();
    }
    @Test(priority = 2)
    public void currency() throws InterruptedException {
        changeCurrency();
    }
    @Test(priority = 3)
    public void gender() throws InterruptedException {
        filterGender();
    }
    @Test(priority = 4)
    public void prise() throws InterruptedException {
        sortByPrise();
    }
    @Test(priority = 5)
    public void verify() throws InterruptedException {
        verifyPrise();
    }
}
