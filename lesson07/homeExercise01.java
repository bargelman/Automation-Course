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

public class homeExercise01 {
    WebDriver driver;

    @BeforeClass
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");
    }
    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test01(){
        List<WebElement> element01 = new ArrayList<>();
        element01.add(driver.findElement(By.id("locator_id")));
        element01.add(driver.findElement(By.name("locator_name")));
        element01.add(driver.findElement(By.tagName("p")));
        element01.add(driver.findElement(By.className("locator_class")));
        element01.add(driver.findElement(By.linkText("myLocator(5)")));
        element01.add(driver.findElement(By.partialLinkText("Find my")));
        element01.add(driver.findElement(By.cssSelector("input[value='Find my locator (7)']")));
        element01.add(driver.findElement(By.xpath("//button[@class='btn btn-2']")));
        for (WebElement webElement : element01) {
            System.out.println(webElement);
        }
    }
    @Test
    public void test02() {
        List<WebElement> element02 = new ArrayList<>();
        element02.add(driver.findElement(By.id("locator_id")));
        element02.add(driver.findElement(By.name("locator_name")));
        element02.add(driver.findElement(By.tagName("p")));
        element02.add(driver.findElement(By.className("locator_class")));
        element02.add(driver.findElement(By.linkText("myLocator(5)")));
        element02.add(driver.findElement(By.partialLinkText("Find my")));
        element02.add(driver.findElement(By.cssSelector("input[value='Find my locator (7)']")));
        element02.add(driver.findElement(By.xpath("//button[@class='btn btn-2']")));
        for (int i = 0; i < element02.size(); i++) {
            if (element02.get(i).getText().equals("")){
                System.out.println(element02.get(i).getAttribute("value"));
            }else {
                System.out.println(element02.get(i).getText());
            }
        }
    }
}

