package com.duckduck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.duckduck.qa.base.TestBase;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoSerchResultPage extends TestBase
{
	@FindBy(xpath = "//li[contains(@class,'wLL07_0Xnd1QZpzpfR4W')]//h2//span")
    public List<WebElement> searchResultTitles;

    @FindBy(xpath = "//div[contains(@class,'module--images__thumbnails js-images-thumbnails')]//div//a")
    public List<WebElement> imageResults;

    public int ActualTitleSize;
    public int ActualImagesSize;
    
    public DuckDuckGoSerchResultPage() 
    {
         PageFactory.initElements(driver, this);
    }

    public List<String> getSearchResultTitles()
    {
        List<String> titles = new ArrayList<>();
        for (WebElement title : searchResultTitles) 
        {
            titles.add(title.getText());
            ActualTitleSize = titles.size();
        }
        return titles;
    }

    public List<String> getImageURLs() 
    {
        List<String> imageURLs = new ArrayList<>();
        for (WebElement image : imageResults)
        {
            String imageURL = image.getAttribute("href");
            imageURLs.add(imageURL);
            ActualImagesSize = imageURLs.size();
        }
        return imageURLs;
    }

    public static String stripDuckDuckGoUrl(String fullUrl)
    {
        int index = fullUrl.indexOf("&iai=");
        if (index != -1)
        {
            return fullUrl.substring(index + 5);
        }
        return fullUrl;
    }
}
