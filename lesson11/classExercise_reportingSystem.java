package lesson11;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.fail;

public class classExercise_reportingSystem {
    WebDriver driver;

    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
    }

    @AfterClass
    public void closer() {
        driver.quit();
    }
    @AfterMethod
    public void refresh() {driver.navigate().refresh();}

    @Attachment(value = "Page ScreenShot" , type = "Image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(priority = 0, description = "Bar Gelman BMI Values")
    @Description("Test description: BMI Test for Bar Gelman")
    public void test01() {
        final String weight = "75";
        final String height = "184";
        sendValues(weight, height);
        bmiCalculator(weight, height);
        verifyBmi(bmiCalculator(weight, height));
    }

    @Test(priority = 1, description = "Shir Biton BMI Values")
    @Description("Test description: BMI Test for Shir Biton")
    public void test02() {
        final String weight = "55";
        final String height = "168";
        sendValues(weight,height);
        bmiCalculator(weight, height);
        verifyBmi(bmiCalculator(weight, height));
    }

    @Test(priority = 2, description = "Nir Peled BMI Values")
    @Description("Test description: BMI Test for Nir Peled")
    public void test03() {
        final String weight = "80";
        final String height = "173";
        sendValues(weight, height);
        bmiCalculator(weight, height);
        verifyBmi(bmiCalculator(weight, height));
    }

        @Step("BMI values")
    public void sendValues(String weight, String height) {
        driver.findElement(By.id("weight")).sendKeys(weight);
        driver.findElement(By.id("hight")).sendKeys(height);
        driver.findElement(By.cssSelector("#calculate_data")).click();
    }

        @Step("BMI Calculator")
    public int bmiCalculator(String weight, String height) {
        double mathHeight = Float.parseFloat(height) * Float.parseFloat(height) / 10000;
        double bmiCal = Math.floor(Double.parseDouble(weight) / (mathHeight));
        return (int) bmiCal;
    }

        @Step("Verify BMI")
    public void verifyBmi(int bmiCal) {
        String expected = Integer.toString(bmiCal);
        String actual = driver.findElement(By.xpath("//input[@id='bmi_result']")).getAttribute("value");
        try {
            Assert.assertEquals(actual, expected);

        }
        catch (AssertionError e){
            saveScreenshot(driver);
            fail("Assert Failed" + e);

        }
    }
}