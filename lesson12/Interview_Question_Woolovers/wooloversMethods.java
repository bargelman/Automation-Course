package lesson12.Interview_Question_Woolovers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class wooloversMethods {
    protected WebDriver driver;
    Actions actions;
    Select dropdown;

    public void popup1() {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public void popup2() {
        driver.findElement(By.xpath("//div[@class='glControls']/input[@type='button']")).click();
    }

    public void newInSection() {
        driver.findElement(By.xpath("//li[@class='dropdown hasSubmenu New Arrivals']//a[contains(text(),'New In')]")).click();
    }

    public void changeCurrency() throws InterruptedException {
        driver.findElement(By.xpath("//img[@src='//gepi.global-e.com/content/images/flags/il.png']")).click();
        Thread.sleep(1500); // explicitly wait
        WebElement staticDropdown = driver.findElement(By.id("gle_selectedCurrency"));
        dropdown = new Select(staticDropdown);
        dropdown.selectByValue("USD");
        driver.findElement(By.className("glDefaultBtn")).click();
        driver.switchTo().defaultContent();
    }

    public void filterGender() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("dd-Gender")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-filter-id='160']")).click();
        driver.findElement(By.xpath("//div[@data-filtername='Gender']//div[@class='d-lg-flex filter-group__scroll']/a[1]")).click();
        driver.findElement(By.xpath("//div[@data-filtername='Gender']//div[@class='btn btn-block filter-group__close-btn js-toggle-close-all'][normalize-space()='Done']")).click();
    }

    public void sortByPrise() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("dd-Sort By")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-filtername='Sort By']//div[@class='d-lg-flex filter-group__scroll']/a[2]")).click();
        driver.findElement(By.xpath("//div[@data-filtername='Sort By']//div[@class='btn btn-block filter-group__close-btn js-toggle-close-all'][normalize-space()='Done']")).click();
    }

    public void verifyPrise() throws InterruptedException {
        Thread.sleep(2000);
        WebElement products = driver.findElement(By.id("listing-container"));
        List<WebElement> items = products.findElements(By.tagName("span"));
        double expected = 150.0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().contains("$")){
                String strPrise = items.get(i).getText().substring(2);
                double dblPrise = Double.parseDouble(strPrise);
                Assert.assertTrue(dblPrise < expected, "Price of One or More of the Items is More than Expected!");
            }
        }
    }
}
