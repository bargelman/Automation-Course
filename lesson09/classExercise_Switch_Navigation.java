package lesson09;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class classExercise_Switch_Navigation {
    WebDriver driver;

    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_switch_navigation.html");

    }
    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test01_Alert(){
        driver.findElement(By.id("btnAlert")).click();
        Alert alert = driver.switchTo().alert();
        String alertMsg01 = alert.getText();
        System.out.println(alertMsg01);
        alert.accept();
        String alertMsg02 = driver.findElement(By.id("output")).getText();
        Assert.assertEquals(alertMsg02 , "Alert is gone.");
    }
    @Test
    public void test02_Prompt() throws InterruptedException {
        driver.findElement(By.id("btnPrompt")).click();
        Alert alert = driver.switchTo().alert();
        String alertMsg01 = alert.getText();
        System.out.println(alertMsg01);
        String name = "Bar Gelman";
        alert.sendKeys(name);
        Thread.sleep(2000);
        alert.accept();
        String alertMsg02 = driver.findElement(By.id("output")).getText();
        Assert.assertEquals(alertMsg02 , name);
    }
    @Test
    public void test03_ConfirmBox(){
        driver.findElement(By.id("btnConfirm")).click();
        Alert alert = driver.switchTo().alert();
        String alertValue = alert.getText();
        alert.accept();
        System.out.println(alertValue);
        String alertOutput01 = driver.findElement(By.id("output")).getText();
        Assert.assertEquals(alertOutput01 , "Confirmed.");
        driver.findElement(By.id("btnConfirm")).click();
        alert.dismiss();
        String alertOutput02 = driver.findElement(By.id("output")).getText();
        Assert.assertEquals(alertOutput02 , "Rejected!");
    }
    @Test
    public void test04_iFrame(){
//        WebElement iFrame = driver.findElement(By.cssSelector("iframe[src='ex_switch_newFrame.html']"));
//        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(0);
        String iFrameText = driver.findElement(By.id("iframe_container")).getText();
        System.out.println(iFrameText);
        Assert.assertEquals(iFrameText, "This is an IFrame !");
        driver.switchTo().defaultContent();
        String mainTitle = driver.findElement(By.id("title")).getText();
        Assert.assertEquals(mainTitle, "Switch and Navigate");
    }
    @Test
    public void test05_newTab(){
        String oldPage = driver.getWindowHandle();
        driver.findElement(By.id("btnNewTab")).click();
        Set<String> winHandles = driver.getWindowHandles();
        for (String winHandle: winHandles){
            driver.switchTo().window(winHandle);
        }
        String newPageText = driver.findElement(By.id("new_tab_container")).getText();
        System.out.println(newPageText);
        Assert.assertEquals(newPageText, "This is a new tab");
        driver.close();
        driver.switchTo().window(oldPage);
        String mainTitle = driver.findElement(By.id("title")).getText();
        Assert.assertEquals(mainTitle, "Switch and Navigate");
    }
    @Test
    public void test06_newWindow(){
        String oldWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Open New Window")).click();
        List<String> newWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindow.get(1));
        String newWindowText = driver.findElement(By.id("new_window_container")).getText();
        System.out.println(newWindowText);
        Assert.assertEquals(newWindowText, "This is a new window");
        driver.close();
        driver.switchTo().window(oldWindow);
        String mainTitle = driver.findElement(By.id("title")).getText();
        Assert.assertEquals(mainTitle, "Switch and Navigate");
    }
}



