package lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Test;
import org.w3c.dom.Document;


public class classExercise_External_Files {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterClass
    public void closerSession() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
    @Test
    public void test01(){
        driver.get(getData("url"));
        driver.findElement(By.id("weight")).sendKeys(getData("Weight"));
        driver.findElement(By.id("hight")).sendKeys(getData("Height"));
        driver.findElement(By.id("calculate_data")).click();
        String actual = driver.findElement(By.id("bmi_result")).getAttribute("value");
        System.out.println(actual);
        Assert.assertEquals(actual, getData("expectedResult"));
    }
    public static String getData (String tagXml) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        assert doc != null;
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(tagXml).item(0).getTextContent();
    }
}
