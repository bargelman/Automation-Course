package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeExercise02 {
    WebDriver driver;

    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test() {
        driver.get("https://www.google.co.il/");
        driver.get("https://www.bing.com/");
        driver.navigate().back(); // Go to previous page
        System.out.println("The title of courant Web is:  " + driver.getTitle());
        if (driver.getPageSource().contains("bubble")){
            System.out.println("Exist");
        }else {
            System.out.println("Not Exist");
        }
    }
    @AfterClass
    public void closer(){
        driver.quit();
    }
}
