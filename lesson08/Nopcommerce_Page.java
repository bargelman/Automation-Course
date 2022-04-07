package lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Nopcommerce_Page {
    WebDriver driver;
    @Deprecated @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void closeSession() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test01_navigate(){
        driver.findElement(By.linkText("Electronics")).click();
        driver.findElement(By.xpath("//div[@class='picture']/a")).click();
    }
    @Test
    public void test02_filter() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select filter = new Select(dropDown);
        filter.selectByVisibleText("Price: Low to High");
        Thread.sleep(2000);
    }
    @Test
    public void test03_count(){
        List<WebElement> products = driver.findElements(By.className("item-box"));
        Assert.assertEquals(products.size(), 3);
    }
    @Test
    public void test04_productNames(){
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("products-wrapper")));

        String[] products = {"Leica T Mirrorless Digital Camera", "Nikon D5500 DSLR", "Apple iCam"};
        List<WebElement> name = driver.findElements(By.xpath("//div[@class='details']/h2/a"));
        for (int i = 0; i < name.size(); i++) {
            Assert.assertEquals(products[i], name.get(i).getText());
        }
    }
    @Test
    public void test05_rate(){
        SoftAssert softAssert = new SoftAssert();
        String[] products = {"Leica T Mirrorless Digital Camera", "Nikon D5500 DSLR", "Apple iCam"};
        List<WebElement> rate = driver.findElements(By.xpath("//div[@class='rating']/div"));
        for (int i = 0; i < rate.size(); i++) {
            String[] star1 = rate.get(i).getAttribute("style").split(" ");
            String[] star2 = star1[1].split("%");
            String star3 = star2[0];
            int rating = Integer.parseInt(star3);
            softAssert.assertTrue(rating >= 60, "bla bla bla");
            softAssert.assertAll();

            }
        }
    }


