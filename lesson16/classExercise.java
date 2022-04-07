package lesson16;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class classExercise {
    Document doc;
    Element logo;
    List<Element> dropDown;
    String Width;
    String Height;
    String firstDropDown;
    @BeforeClass
    public void startSession() throws IOException {
        doc = Jsoup.connect("https://www.ebay.com/").get();
        logo = doc.getElementById("gh-logo");
        dropDown = doc.getElementsByAttributeValue("value" ,"0");

    }
    @Test
    public void verifyWidthLogo(){
        Width = logo.attr("width");
        Assert.assertEquals(Width, "250");
    }
    @Test
    public void verifyHeightLogo(){
        Height = logo.attr("height");
        Assert.assertEquals(Height, "200");
    }
    @Test
    public void verifyDropDown(){
        firstDropDown = dropDown.get(0).text();
        String expected = "All Categories";
        Assert.assertEquals(firstDropDown, expected);
    }
}
