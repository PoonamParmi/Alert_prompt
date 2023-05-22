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
///

public class Amazon_search
{
    ChromeDriver driver;
   public void  search_amazon_on_google()
   {
     this.driver = TestCases.TestCasesInitializer();
        // Negivagte to URL
        driver.get("https://www.google.com");

        // Click on Search Bar Using Locator "Name" q
        driver.findElementByName("q").click();
       
        // Type in "Amazon" in search bar Using Locator "Name" q
        driver.findElementByName("q").sendKeys("amazon");
       
        // Click on Google Search button Using Locator "XPath" (//input[@value='Google
        // Search'])[1]
        driver.findElementByXPath("(//input[@value='Google Search'])[1]").click();

        // Validate Amazon.in search result Using Locator "Link
        // Text"(//input[@value='Google Search'])[1]
        boolean ds = driver.findElementByXPath("//h3[text()='Amazon.in']").isDisplayed();
        System.out.println(ds);
        
        //Click on the link of Amazon.in Using Locator "XPath" //h3[text()='Amazon.in']
        driver.findElementByXPath("//h3[text()='Amazon.in']").click();
    }
}
