package lesson09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class homeExercise_Synchronization {
    WebDriver driver;


    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
    }
    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Deprecated @Test
    public void test01_ExplicitWait(){
        driver.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish2"))).getText();
        System.out.println(text);
        Assert.assertEquals(text , "My Rendered Element After Fact!");
    }
    @Test
    public void test02_Sleep() throws InterruptedException {
        driver.findElement(By.id("hidden")).click();
         Thread.sleep(3000);
        WebElement hidden = driver.findElement(By.cssSelector("div[id='loading1'][style='display: none;']"));
        System.out.println(hidden);
    }
    @Deprecated @Test
    public void test03_implicitWait(){
        driver.findElement(By.id("btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.id("message")).isDisplayed());
        System.out.println(driver.findElement(By.id("message")).getText());
    }
}
