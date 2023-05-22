package demo;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Automate_image_url {
    ChromeDriver driver;
    

    public void imageurl() throws InterruptedException {
        this.driver = TestCases.TestCasesInitializer();

        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
       
        // Locate the recommended movies list Using Locator "XPath" //div[@class='sc-lnhrs7-2 eQezya']/div//img
        List<WebElement> moviesList = driver.findElements(By.xpath("//div[@class='sc-lnhrs7-2 eQezya']/div//img"));
        System.out.println("Number of movie images " + moviesList.size());
        
        // use for loop to iterate over each img and print the src attribute value
        for (WebElement movieUrl : moviesList) {
            String attribute = movieUrl.getAttribute("src");
            System.out.println("image urls of recommended movie lists " + attribute);
            Thread.sleep(2000);
        }
        
        // Scroll down into the viewport where "PREMIERE" heading is been seen
        //WebElement heading = driver.findElement(By.xpath("//img[@alt='Tvod Offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "null");
       
        // Print the name of the 2nd item of premiere list Using Locator "XPath"
        // (//div[@class='sc-7o7nez-0 fyTNyu'])[2]
        WebElement name = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 fyTNyu'])[2]"));
        System.out.println("Name of movie which come 2nd in the premiere list is " + name.getText());
        
        // Print the language of the 2nd item of premiere list Using Locator "XPath"
        // (//div[@class='sc-7o7nez-0 eeVqLW'])[2]
        WebElement lang = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 eeVqLW'])[2]"));
        System.out.println("Language of the movie which comes 2nd in the premiere list " + lang.getText());

    }

}
