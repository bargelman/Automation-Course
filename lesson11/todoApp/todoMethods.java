package lesson11.todoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class todoMethods {
    protected WebDriver driver;
    protected Actions actions;

    public void createItem(String mission){
        driver.findElement(By.className("new-todo")).sendKeys(mission);
        String click = Keys.chord(Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys(click);
    }
    public void filterAll(){
        driver.findElement(By.linkText("All")).click();
    }
    public List<WebElement> missionsList(){
        return driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
    }
    public void deleteFirstMission(){
        WebElement deleteMissionX = driver.findElement(By.tagName("button"));
        actions.moveToElement(missionsList().get(0)).moveToElement(deleteMissionX).click().build().perform();
    }
    public void deleteAllMissions(){
        int numberOfMissions = missionsList().size();
        for (int i = 0; i < numberOfMissions; i++) {
            deleteFirstMission();
        }
    }
    public void deleteAllMissions2(){
        int numberOfMissions = missionsList().size();
        for (int i = 0; i < numberOfMissions; i++) {
            WebElement element = driver.findElement(By.xpath("//li[1]//div"));
            actions.moveToElement(element).build().perform();
            driver.findElement(By.xpath("//li[1]//div[1]//button[1]")).click();
        }
    }
    public void goToCompleted(int index){ // index > 0
        driver.findElement(By.xpath("//li["+index+"]//div[1]//input[1]")).click();
        driver.findElement(By.linkText("Completed")).click();
    }
    public void goToActive(){
        driver.findElement(By.linkText("Active")).click();
    }
    public void clearCompleted(){
        driver.findElement(By.className("clear-completed")).click();
    }
    public void rename(int index, String newName) {
        WebElement element = driver.findElement(By.xpath("//li["+index+"]//div"));
        actions.moveToElement(element).doubleClick().doubleClick().build().perform();
        String delete = Keys.chord(Keys.DELETE);
        actions.sendKeys(delete).perform();
        actions.sendKeys(newName);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
