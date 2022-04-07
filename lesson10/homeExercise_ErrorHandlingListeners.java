package lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.class)
public class homeExercise_ErrorHandlingListeners {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
        driver.manage().window().maximize();

    }
    @AfterClass
    public void closerSession() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.id("btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("checkbox"));
    }
}
