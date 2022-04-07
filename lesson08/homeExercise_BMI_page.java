package lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeExercise_BMI_page {
    WebDriver driver;
    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
    }
    @AfterClass
    public void closer(){
        driver.quit();
    }
    @Test
    public void test01() {
        String weight = "75";
        String height = "184";
        driver.findElement(By.id("weight")).sendKeys(weight);
        driver.findElement(By.id("hight")).sendKeys(height);
        driver.findElement(By.cssSelector("#calculate_data")).click();
        double mathHeight = Float.parseFloat(height) * Float.parseFloat(height)/10000;
        double bmiCal = Math.floor(Double.parseDouble(weight)/(mathHeight));
        int bmiCalc = (int)bmiCal;
        String expected = Integer.toString(bmiCalc);
        String actual = driver.findElement(By.xpath("//input[@id='bmi_result']")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void test02(){
        Assert.assertFalse(driver.findElement(By.id("new_input")).isDisplayed());
            int height = driver.findElement(By.xpath("//input[@id='calculate_data']")).getSize().getHeight();
            int width = driver.findElement(By.xpath("//input[@id='calculate_data']")).getSize().getWidth();
            int x = driver.findElement(By.cssSelector("#calculate_data")).getLocation().getX();
            int y = driver.findElement(By.cssSelector("#calculate_data")).getLocation().getY();
            System.out.println("height: " + height + "px");
            System.out.println("width: " + width + "px");
            System.out.println("X :" + x + "px");
            System.out.println("Y :" + y + "px");
            Assert.assertTrue(driver.findElement(By.id("calculate_data")).isEnabled(), "The Button is Disable!!");
            Assert.assertTrue(driver.findElement(By.cssSelector("#calculate_data")).isDisplayed(), "The Button is Hidden!");
            Assert.assertFalse(driver.findElement(By.xpath("//input[@id='calculate_data']")).isSelected(), "The button is Selected!");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id='calculate_data']")).getTagName(), "input");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id='calculate_data']")).getDomAttribute("value"), "Calculate BMI");
    }
}
