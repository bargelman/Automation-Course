package lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class interviewQuestion_Chuck_Norris {

    public RequestSpecification httpRequest;
    public Response response;
    public JsonPath jp;
    protected WebDriver driver;

    final String baseUrl = "https://api.chucknorris.io/jokes/";
    String categoriesUrl = "categories";
    String barackObamaUrl = "Barack Obama";
    String charlieSheenUrl = "Charlie Sheen";
    String randomJokeUrl = "random";
    String categoryUrl = "movie";

    @BeforeClass
    public void startSession() {
        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();
    }

    @Test
    public void test01_jokesCategories() {
        jp = getJasonPath(categoriesUrl);
        List<String> categoriesList = jp.getList("$.");
        for (int i = 0; i < categoriesList.size(); i++) {
            System.out.println(categoriesList.get(i));
        }
    }

    @Test
    public void test02_barackObamaVsCharlieSheen() {
        int barackObamaTotalJokes = getTotalJokes("search?query=" + barackObamaUrl);
        int charlieSheenTotalJokes = getTotalJokes("search?query=" + charlieSheenUrl);

        if (barackObamaTotalJokes > charlieSheenTotalJokes) {
            System.out.println("Barack Obama's Total Jokes are more then charlie Sheen's Total Jokes  " + barackObamaTotalJokes + ":" + charlieSheenTotalJokes);
        } else if (charlieSheenTotalJokes > barackObamaTotalJokes) {
            System.out.println("Charlie Sheen's Total Jokes are more then Barack Obama's Total Jokes  " + charlieSheenTotalJokes + ":" + barackObamaTotalJokes);
        } else {
            System.out.println("EVEN!!!");
        }
    }

    @Test
    public void test03_insertToCSV() throws IOException {
        for (int i = 0; i < 10; i++) {
            jp = getJasonPath(randomJokeUrl);
            String url = jp.getString("url");
            String value = jp.getString("value");
            writeCSV(url, value);

        }
    }

    @Test
    public void test04_verifyWithSelenium() {
        jp = getJasonPath("random?category=" + categoryUrl);
        String url = jp.getString("url");
        String value = jp.getString("value");
        initBrowser(url);
        String webJokeText = driver.findElement(By.xpath("//p[@id='joke_value']")).getText();
        Assert.assertEquals(value, webJokeText);
        driver.quit();
    }

    public JsonPath getJasonPath(String value) {
        response = httpRequest.get(value);
        return response.jsonPath();
    }

    public int getTotalJokes(String name) {
        response = RestAssured.given().get(name);
        jp = response.jsonPath();
        return jp.getInt("total");
    }

    public void writeCSV(String url, String value) throws IOException {
        FileWriter pw = new FileWriter("./results.csv", true);
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(',');
        sb.append(value.replace(",", ""));
        sb.append('\n');
        pw.write(sb.toString());
        pw.close();
    }

    public void initBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
