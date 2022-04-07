package lesson13.classExercise_PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ClickPage {
    @FindBy(tagName = "button")
    public WebElement btn_clickMe2;

    public void button() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(btn_clickMe2.isDisplayed());
    }
}
