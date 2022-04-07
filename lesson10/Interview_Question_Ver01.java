package lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Interview_Question_Ver01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://juliemr.github.io/protractor-demo/");
        calculator.multiplication_table(driver);
        driver.quit();
    }
}
class calculator {
    public static void multiplication_table(WebDriver driver) throws InterruptedException {
        WebElement staticDropdown = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(staticDropdown);

        for (int i = 3; i > 0; i--) {
            for (int j = 3; j > 0; j--) {
                String firstNum = Integer.toString(i);
                driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(firstNum);
                dropdown.selectByVisibleText("*");
                String secondNum = Integer.toString(j);
                driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(secondNum);
                driver.findElement(By.id("gobutton")).click();
                Thread.sleep(3000);
                String result = driver.findElement(By.tagName("h2")).getText();
                System.out.println(result);
            }
        }
    }
}


