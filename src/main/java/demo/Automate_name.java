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

public class Automate_name {

    ChromeDriver driver;

    public void Myname() throws InterruptedException {
        this.driver = TestCases.TestCasesInitializer();
        // Navigate to URL https://www.google.com/
        driver.get("https://www.google.com/");

        // Click on Search Bar Using Locator "Name" q
        driver.findElement(By.name("q")).click();

        // Type in "Puja" in Search bar Using Locator "Name" q
        driver.findElement(By.name("q")).sendKeys("Poonam Kate");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // Click on Google Search Button Using Locator "XPath" (//input[@value='Google
        // Search'])[1]
        int count = driver.findElements(By.partialLinkText("Poonam Kate")).size();
        Thread.sleep(2000);

        // Count of links in the search result with name Using Locator "XPath"
        // //h3[text()='Puja']
        // int count = driver.findElementByXPath("a");
        Thread.sleep(3000);
        System.out.println("count :" + count);
    }
}
