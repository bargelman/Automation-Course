package lesson13.classExercise_PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
    @FindBy(id = "occupation")
    public WebElement txt_occupation;
    @FindBy(id = "age")
    public WebElement txt_age;
    @FindBy(id = "location")
    public WebElement txt_location;
    @FindBy(css = "input[value='Click Me']")
    public WebElement btn_clickMe;

    public void form(String occupation, String age, String location){
        txt_occupation.sendKeys(occupation);
        txt_age.sendKeys(age);
        txt_location.sendKeys(location);
        btn_clickMe.click();
    }
}
