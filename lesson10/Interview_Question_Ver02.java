package lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class Interview_Question_Ver02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.random.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        random_page.randomNumber(driver);
        driver.quit();

    }
}

class random_page {
    public static void randomNumber(WebDriver driver) throws InterruptedException {
        WebElement iFrame = driver.findElement(By.cssSelector("iframe[longdesc='https://www.random.org/integers/']"));
        driver.switchTo().frame(iFrame);

        WebElement maxNumber = driver.findElement(By.xpath("//input[@value='100']"));
        maxNumber.clear();
        maxNumber.sendKeys("10");
        driver.findElement(By.xpath("//input[@value='Generate']")).click();
        Thread.sleep(1500);
        String randomNumber = driver.findElement(By.xpath("//span[@style='font-size:100%;font-weight:bold;']")).getText();
        driver.switchTo().defaultContent();
        System.out.println("The Random Number is: " + randomNumber);

        driver.navigate().to("http://juliemr.github.io/protractor-demo/");

        WebElement staticDropdown = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(staticDropdown);

        int counter = 0;
        int randNum = Integer.parseInt(randomNumber);

        for (int i = randNum; i > 0; i--) {
            if (i != randNum - 1){
                for (int j = randNum - 1; j >= 0; j--) {

                    driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(Integer.toString(i));
                    dropdown.selectByVisibleText("*");
                    driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(Integer.toString(j));
                    driver.findElement(By.id("gobutton")).click();
                    Thread.sleep(3000);
                    String strResult = driver.findElement(By.tagName("h2")).getText();
                    int result = Integer.parseInt(strResult);
                    counter += result;
            }
                break;
            }
        }
        System.out.println("The Result for Number: " + randomNumber + " is: " + counter);
    }
}



