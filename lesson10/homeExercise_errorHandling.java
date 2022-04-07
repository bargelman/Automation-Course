package lesson10;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class homeExercise_errorHandling {
    WebDriver driver;
    WebDriverWait wait;
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
    @AfterMethod
    public void refresh(){
        driver.navigate().refresh();
    }
    @Test
    public void test01_withTryCatch() {
        try {
            driver.findElement(By.id("btn")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("checkbox"));
            System.out.println("test01 Failed - Element exists on screen");
        }
        catch (Exception e){
            System.out.println("test01 Passed - Element does NOT exist on screen");
        }
    }
    @Test
    public void test02() {
        driver.findElement(By.id("btn")).click();
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        if (driver.findElement(By.id("message")).getText().equals("It's gone!")){
            System.out.println("test02 Passed - Element does NOT exist on screen");
        }else {
            System.out.println("test02 Failed - Element exists on screen");
        }
    }
    @Test
    public void test03(){
        driver.findElement(By.id("btn")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        System.out.println("test03 Passed - Element does NOT exist on screen");
    }
    @Test
    public void test04(){
        driver.findElement(By.id("btn")).click();
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        int size = driver.findElements(By.id("checkbox")).size();
        if (size > 0){
            System.out.println("test04 Failed - Element exists on screen");
        }else {
            System.out.println("test04 Passed - Element does NOT exist on screen");
        }
    }
}
