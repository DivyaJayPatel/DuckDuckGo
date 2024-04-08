package com.duckduck.qa.testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duckduck.qa.base.TestBase;
import com.duckduck.qa.pages.DuckDuckGoSerchPage;
import com.duckduck.qa.pages.DuckDuckGoSerchResultPage;

public class DuckDuckGoSerchResult extends TestBase
{
	
	DuckDuckGoSerchPage duckduckgoserchpage;
	DuckDuckGoSerchResultPage duckduckgoserchresultpage;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		duckduckgoserchpage = new DuckDuckGoSerchPage();
		duckduckgoserchresultpage = new DuckDuckGoSerchResultPage();
		
		//part 1 -> point no.1 Logs in to the duckduckgo Webpage
		duckduckgoserchpage.search("nice cars image");
	}
	
	@Test(priority = 1)
	public void serchresultpage()
	{
		//part 1 -> point no.2 Returns a List of URLS and stripped 
		List<String> imageurls = duckduckgoserchresultpage.getImageURLs();
		
		Assert.assertEquals(duckduckgoserchresultpage.ActualImagesSize, imageurls.size());
				 
		System.out.println("--------Image URLs---------");
		for(String imageUrl : imageurls)
		{
			imageUrl = duckduckgoserchresultpage.stripDuckDuckGoUrl(imageUrl);
			System.out.println("URL : " + imageUrl);

		}

		//part 1 -> point no.3 Returns a list of all titles
		List<String> titles = duckduckgoserchresultpage.getSearchResultTitles();
		Assert.assertEquals(duckduckgoserchresultpage.ActualTitleSize, titles.size());

		System.out.println("--------Title---------"); 
		for(String title : titles) 
		{
			System.out.println("Title : " + title);
		}
	}
	
	@Test(priority = 2)
	public void wallpaperelement() 
	{
		//part 2 -> point no.1 at least one of the images is coming from wallpapercave.com
		boolean foundwallpapercraveImage = false;

		for(WebElement element : duckduckgoserchresultpage.imageResults)
		{
			String imageURL = element.getAttribute("href");

			if(imageURL.contains("wallpapercave.com"))
			{
				foundwallpapercraveImage = true;
				break;
			}
		}
		assertTrue(foundwallpapercraveImage,"No Images coming from wallpapercave.com");
	}
	
	@Test(priority = 3)
	public void comparisionelement()
	{
		//part 2 -> point no.2 Title comparison "car" and "cars"
		List<String> titles = duckduckgoserchresultpage.getSearchResultTitles();
		
		boolean foundCar = false;
		for(String title : titles)
		{
			if(containsCar(title))
			{
				foundCar = true;
				break;
			}
		}
		assertTrue(foundCar, "No title contains the word 'car' or 'cars'");
	}
	
	private boolean containsCar(String title) 
	{
		String[] words = title.split("\\s+");
		for (String word : words)
		{
			if (word.equalsIgnoreCase("car") || word.equalsIgnoreCase("cars") && word.equalsIgnoreCase("CAR") || word.equalsIgnoreCase("CARS") )
			{
				return true;
			}
		}
		return false;
	}

	
	@AfterMethod
    public void tearDown(ITestResult result)
	{
        if (ITestResult.FAILURE == result.getStatus()) 
        {
            try 
            {             
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        		String currentDir = System.getProperty("user.dir");
        		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
            } 
            catch (IOException e) 
            {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        // Close the browser
       driver.quit();
    }

	
	

}
