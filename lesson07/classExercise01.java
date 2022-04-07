package lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class classExercise01 {
    WebDriver driver;

    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://Selenium.dev");
    }
    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test01(){
        String str = driver.findElement(By.id("selenium_logo")).getText();
        System.out.println(str);
        String str1 = driver.findElement(By.xpath("//*[@id='selenium_logo']")).getText();
        System.out.println(str1);
        String str2 = driver.findElement(By.xpath("(//*[@data-name='Selenium Logo'])")).getText();
        System.out.println(str2);
        String str3 = driver.findElement(By.xpath("//span[@class='navbar-logo']//*[name()='svg']")).getText();
        System.out.println(str3);
        String str4 = driver.findElement(By.cssSelector("#selenium_logo")).getText();
        System.out.println(str4);

    }
    @Test
    public void test02(){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int numLinks = links.size();
        System.out.println("The number of links on Web page is: " + numLinks);
    }
    @Test
    public void test03(){
        List<WebElement> linkSelenium = driver.findElements(By.partialLinkText("Selenium"));
        int numLinkSelenium = linkSelenium.size();
        System.out.println("The number of 'Selenium' links on Web page is: " + numLinkSelenium);
    }
    @Test
    public void test04(){
        List<WebElement> linkselenium = driver.findElements(By.partialLinkText("selenium"));
        int numLinkselenium = linkselenium.size();
        System.out.println("The number of 'selenium' links on Web page is: " + numLinkselenium);
    }
}
