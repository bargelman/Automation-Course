package lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeExercise_InterviewQuestion_Loudev {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://loudev.com/");
    }
    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
    @Test
    public void test01() {
        driver.findElement(By.xpath("//div[@id='ms-aloha']//div[@class='ms-selectable']//span[contains(text(),'elem 6')]")).click();
//        driver.findElement(By.xpath("//div[@id='ms-aloha']//div[@class='ms-selectable']//span[contains(text(),'elem 12')]")).click();
//        driver.findElement(By.xpath("//div[@id='ms-aloha']//div[@class='ms-selectable']//span[contains(text(),'elem 19')]")).click();
        Support.verifyElements(driver);
    }
}

