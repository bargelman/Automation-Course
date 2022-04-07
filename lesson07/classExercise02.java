package lesson07;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class classExercise02 {
    WebDriver driver;
    @BeforeClass
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }
    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test(){
        List<WebElement> webElements = new ArrayList<>();
        webElements.add(driver.findElement(By.className("central-featured-logo")));
        webElements.add(driver.findElement(By.tagName("fieldset")));
        webElements.add(driver.findElement(By.id("searchLanguage")));
        webElements.add(driver.findElement(By.className("footer-sidebar")));
        for (int i = webElements.size() - 1; i >= 0 ; i--) {
            System.out.println(webElements.get(i));
        }
    }
}
