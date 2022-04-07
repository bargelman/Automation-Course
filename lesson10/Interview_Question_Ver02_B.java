package lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Interview_Question_Ver02_B {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.random.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        super_calculator.calculator(driver, wait);
        driver.quit();
    }
}

class super_calculator {
    public static void calculator(WebDriver driver , WebDriverWait wait) throws InterruptedException {
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        WebElement maxNumber = driver.findElement(By.xpath("//input[@value='100']"));
        maxNumber.clear();
        maxNumber.sendKeys("10");
        driver.findElement(By.xpath("//input[@value='Generate']")).click();
        Thread.sleep(1500);
        String strRandomNumber = driver.findElement(By.xpath("//span[@style='font-size:100%;font-weight:bold;']")).getText();
        driver.switchTo().defaultContent();
        System.out.println("The Random Number is: " + strRandomNumber);

        driver.navigate().to("http://juliemr.github.io/protractor-demo/");
        int intRandomNumber = Integer.parseInt(strRandomNumber);
        WebElement staticDropdown = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("*");
        int counter = 0;
        for (int i = (intRandomNumber - 1); i >= 0; i--) {
            driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(strRandomNumber);
            driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(Integer.toString(i));
            driver.findElement(By.id("gobutton")).click();
            wait.until(ExpectedConditions.textToBe(By.tagName("h2"), Integer.toString(intRandomNumber * i)));

        }
        for (int j = 1; j <= intRandomNumber; j++) {
            counter += Integer.parseInt(driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText());
        }
        System.out.println("The Result for Number: " + strRandomNumber + " is: " + counter);
    }
}
