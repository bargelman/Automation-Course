package lesson13.classExercise_PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {
    WebDriver driver;
    LoginPage login;
    FormPage form;
    ClickPage click;


    @BeforeClass
    public void starter() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/webdriveradvance.html");
        login = PageFactory.initElements(driver, LoginPage.class);
        form = PageFactory.initElements(driver, FormPage.class);
        click = PageFactory.initElements(driver, ClickPage.class);
    }

    @AfterClass
    public void closer() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test(priority = 0)
    public void setLoginPage(){
        login.login("selenium", "webdriver");
    }
    @Test(priority = 1)
    public void setForm(){
        form.form("Engineer", "35", "New - York");
    }
    @Test(priority = 2)
    public void verifyClickButton() throws InterruptedException {
        click.button();
    }
}
