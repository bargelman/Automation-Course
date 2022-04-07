package lesson10;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Interview_Question_Ver02_D {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.random.org/");
        driver.manage().window().maximize();
        calc(driver, rand(driver));

        Thread.sleep(1500);
        driver.quit();
    }
    public static String rand (WebDriver driver) throws InterruptedException {
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//input[@value='100']")).clear();
        driver.findElement(By.xpath("//input[@value='100']")).sendKeys("20");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//span[@style='font-size:100%;font-weight:bold;']")).getText();
    }
    public static void calc (WebDriver driver, String rand) throws InterruptedException {
        driver.get("http://juliemr.github.io/protractor-demo/");
        WebElement staticDropdown = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(staticDropdown);
        int randomNumber = Integer.parseInt(rand);
        int counter = 0;
        for (int i = randomNumber - 1; i >=0 ; i--) {
            driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(rand);
            dropdown.selectByVisibleText("*");
            driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(Integer.toString((i)));
            driver.findElement(By.id("gobutton")).click();
            Thread.sleep(2000);
        }
        for (int j = 1; j <= randomNumber; j++) {
            String strResult = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText();
            int result = Integer.parseInt(strResult);
            counter += result;
        }
        System.out.println("The random number is " + randomNumber);
        System.out.println("The result is: " + counter);
    }
}



