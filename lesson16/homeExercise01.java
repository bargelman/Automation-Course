package lesson16;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeExercise01 {
    String city = "Ashdod,IL";
    final String key = "db207bffe4095bc21b79a1da5e9c5a01";
    final String url = "https://api.openweathermap.org/data/2.5/weather";
    String unit = "&units=metric";

    public RequestSpecification httpRequest;
    public Response response;

    final  String expectedContentType = "json";
    final int expectedStatusCode = 200;

    @BeforeClass
    public void startSession(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        response = httpRequest.get("?q="+ city + "&appid=" + key + unit);
    }
    @Test
    public void test01_openWeatherMapResponseBody(){
        System.out.println("<<==========> Jason Format <<============>>");
        System.out.println(response.getBody().asString());
        System.out.println("<<============> Readable Jason Format <=========>>");
        response.prettyPrint();
    }
    @Test
    public void test02_openWeatherMapResponseStatus(){
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Status code: " + response.getStatusCode());
    }
    @Test
    public void test03_openWeatherMapResponseDate(){
        System.out.println(response.getHeader("Date"));
    }
    @Test
    public void test04_verifyContentType(){
        String[] arrContentType = response.getContentType().split(" ");
        String[] arrContentType2 = arrContentType[0].split("/");
        String actualContentType = arrContentType2[1].substring(0,4);
        Assert.assertEquals(actualContentType, expectedContentType);
    }
    @Test
    public void test05_verifyCodeStatus(){
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }



}
