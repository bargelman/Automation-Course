package Mid_Term_Exam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mid_Exam {
    private WebDriver driver;
    final String name = "Bar";
    final String lastName = "Gelman";
    String couponNum;

    @BeforeClass
    public void starter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/pizza/");

    }
    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test01_pizzaPrice(){
        String startPrice = driver.findElement(By.xpath("//span[@class='ginput_total ginput_total_5']")).getText();
        Assert.assertEquals(startPrice , "$7.50");
    }
    @Test
    public void test02_myDetails(){

        driver.findElement(By.id("input_5_22_3")).sendKeys(name);
        driver.findElement(By.id("input_5_22_6")).sendKeys(lastName);
    }
    @Test
    public void test03_comboBox_Choice(){
        WebElement comboBox = driver.findElement(By.cssSelector("#input_5_21"));
        Select myChoice = new Select(comboBox);
        myChoice.selectByIndex(1);
    }
    @Test
    public void test04_newPizzaPrice(){
        String updatedPrice = driver.findElement(By.className("ginput_total_5")).getText();
        Assert.assertEquals(updatedPrice, "$10.50");
    }
    @Test
    public void test05_coupon(){
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@src='coupon.html']"));
        driver.switchTo().frame(iFrame);
        couponNum = driver.findElement(By.id("coupon_Number")).getText();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("input_5_20")).sendKeys(couponNum);
    }
    @Test
    public void test06_submitOrder(){
        driver.findElement(By.id("gform_submit_button_5")).click();
    }
    @Test
    public void test07_prompt(){
        String promptMassage = driver.switchTo().alert().getText();
        Assert.assertEquals(promptMassage, name + " " + lastName + " " + couponNum);
        driver.switchTo().alert().accept();
    }

}
