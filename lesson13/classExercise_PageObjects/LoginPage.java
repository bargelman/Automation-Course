package lesson13.classExercise_PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username2")
    public WebElement txt_userName;
    @FindBy(name = "password2")
    public WebElement txt_password;
    @FindBy(id = "submit")
    public WebElement btn_submit;

    public void login(String username, String password){
        txt_userName.sendKeys(username);
        txt_password.sendKeys(password);
        btn_submit.click();
    }
}
