package lesson06;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class homeExercise01 {
    WebDriver driver;
    final String expectedTitleName = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    final String expectedUrl = "https://www.imdb.com/";


    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Make the page on full screen mode.
        driver.get("https://imdb.com/");

    }
    @Test
    public void test01_Title(){
        driver.navigate().refresh(); // Refresh the page
        String webTitle = driver.getTitle();
        System.out.println("The web title is: " + webTitle);
        if (webTitle.equals(expectedTitleName)){
            System.out.println("Title Test Pass");
        }else {
            System.out.println("Title Test Failed");
        }
    }
    @Test
    public void test02_Url(){
        driver.navigate().refresh(); // Refresh the page
        String webUrl= driver.getCurrentUrl();
        System.out.println("The Web URL is: " + webUrl);

        if (webUrl.equals(expectedUrl)){
            System.out.println("URL Test Pass");
        }else {
            System.out.println("URL Test Failed");
        }

    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
