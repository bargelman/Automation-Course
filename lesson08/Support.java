package lesson08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

class Support {
    public static void verifyElements(WebDriver driver){
//        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='ms-aloha']/div[@class='ms-selectable']/ul[@class='ms-list']/li"));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='ms-aloha']/div[1]/ul/li"));
        for (int i = 0; i < elements.size(); i++) {
            int sum = i+1;
            if(!elements.get(i).getAttribute("class").contains("ms-selected")) {
            // OR : if(!elements.get(i).getAttribute("style").contains("display: none;"))
                System.out.println(elements.get(i).getText() + ": The element on left list is between" + " " + elements.get(2).getText() + "-" + elements.get((elements.size()-1)).getText());
                Assert.assertEquals(elements.get(i).getText(), "elem " + sum);
            }else {
                System.out.println("elem" +" " + sum + ": IS NOT !!! on left list ");
            }
        }
    }
}
