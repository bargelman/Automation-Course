package lesson12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class classExercise_dataDrivenTesting {
    WebDriver driver;

    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }

    @AfterClass
    public void closer() {
        driver.quit();
    }
    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
        driver.get("https://www.wikipedia.org/");
    }

    @DataProvider(name = "data-provider")
    public Object[][] getDataObject(){
        return new Object[][]{
                {"Israel", "Israel"},{"Automation", "Automation"}, {"BlahBlah", "Search results"}
        };
    }
    @Test(dataProvider = "data-provider")
    public void test01 (String search, String expected) throws InterruptedException {
        driver.findElement(By.id("searchInput")).sendKeys(search);
        driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();
        Thread.sleep(2000);
        String title = driver.findElement(By.id("firstHeading")).getText();
        Assert.assertEquals(title, expected);

    }
}
