package lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class classExercise_controllers {
    WebDriver driver;
    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
    }
    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.name("firstname")).sendKeys("Bar");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gelman");

        WebElement element = driver.findElement(By.id("continents"));
        Select dropDown = new Select(element);
        dropDown.selectByIndex(3);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#sex-1")).click();
        driver.findElement(By.xpath("//input[@id='exp-3']")).click();
        driver.findElement(By.cssSelector("#profession-1")).click();
        driver.findElement(By.xpath("//input[@id='tool-1']")).click();
        driver.findElement(By.cssSelector("#tool-2")).click();
        driver.findElement(By.xpath("//option[@value='swithch']")).click();
//        driver.findElement(By.id("photo")).sendKeys("/Users/bargelman/Desktop/IMG_3720.jpeg");
        // Date Picker DropDown
        driver.findElement(By.className("hasDatepicker")).click();
        Thread.sleep(1000);
        WebElement allDates = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
        List<WebElement> days = allDates.findElements(By.tagName("td"));
        for (WebElement day : days){
            if (day.getText().equals("15")){
                day.click();
                break;
            }
        }
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#submit")).submit();
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
//        System.out.println(url);
        if (url.contains("Bar") && url.contains("Gelman")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        String[] urlArray01 = url.split("%2F");
        String day = urlArray01[1];
        String[] urlArray02 = urlArray01[2].split("&");
        String year =urlArray02[0];
        String[] urlArray03 = urlArray01[0].split("=");
        String month = urlArray03[urlArray03.length-1];
        System.out.println(year + "-" + month + "-" + day);
    }
}
