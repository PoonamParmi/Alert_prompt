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

public class nested_frames_text {
    ChromeDriver driver;

    public void frame() throws InterruptedException{
        this.driver = TestCases.TestCasesInitializer();
      
        //Navigate to URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(1000);
        driver.switchTo().frame("frame-top");
        Thread.sleep(1000);
        driver.switchTo().frame("frame-left");
        Thread.sleep(1000);
        
        
        //Search for the first BODY in html code Using Locator "XPath" //body[contains(text(),'LEFT')]
        String leftText = driver.findElementByXPath("//body[contains(text(),'LEFT')]").getText();
        System.out.println("First Text: "+ leftText);
        Thread.sleep(1000);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Thread.sleep(1000);

        //Search for the middle BODY in html code Using Locator "XPath" //div[contains(text(),'MIDDLE')]
        String middleText = driver.findElementByXPath("//div[contains(text(),'MIDDLE')]").getText();
        System.out.println("Second Text: "+ middleText);
        Thread.sleep(1000);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Thread.sleep(1000);

        //Search for the RIGHT BODY in html code Using Locator "XPath" //body[contains(text(),'RIGHT')]
        String rightText = driver.findElementByXPath("//body[contains(text(),'RIGHT')]").getText();
        System.out.println("Third Text: "+ rightText);
        // Thread.sleep(1000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        // Thread.sleep(1000);

        //Search for the BOTTOM BODY in html code Using Locator "XPath" //body[contains(text(),'BOTTOM')]
        String belowText = driver.findElementByXPath("//body[contains(text(),'BOTTOM')]").getText();
        System.out.println("Fourth Text: "+ belowText);
    }
    
}
