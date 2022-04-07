package lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeExercise02 {
    String city = "Jerusalem,IL";
    final String key = "db207bffe4095bc21b79a1da5e9c5a01";
    final String url = "https://api.openweathermap.org/data/2.5/weather";
    String unit = "&units=metric";

    public RequestSpecification httpRequest;
    public Response response;
    public JsonPath js;
    public WebDriver driver;

    String expectedCountry = "IL";

    @BeforeClass
    public void startSession(){
//        API
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        response = httpRequest.get("?q="+ city + "&appid=" + key + unit);
        js = response.jsonPath();

//        Selenium
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openweathermap.org/");
    }
    public String flow() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Search city']")).sendKeys("Jerusalem,IL");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class='search-dropdown-menu']/li[1]")).click();
        String uiHumidity = driver.findElement(By.xpath("//div[@class='grid-container grid-4-5']//li[3]")).getText();

        return uiHumidity.substring(9,12);
    }
    @Test
    public void test01_verifyCountry(){
        String actualCountry = js.get("sys.country");
        Assert.assertEquals(actualCountry, expectedCountry);
    }
    @Test
    public void test02_verifyHumidity() throws InterruptedException {
        String humidity = Integer.toString(js.get("main.humidity"));
        Assert.assertEquals(humidity, flow());
    }
    @AfterClass
    public void closer() {
        driver.quit();
    }
}
