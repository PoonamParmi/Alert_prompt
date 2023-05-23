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


public class alert_prompt {
    ChromeDriver driver;

    public void alert() throws InterruptedException
    {
        this.driver =TestCases.TestCasesInitializer();
        
        //navigate to the url https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        // Go to the iframe where "try it" button is present Using Xpath //iframe[@name='iframeResult']
        WebElement framess = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        driver.switchTo().frame(framess);
        
        // click on the "try it" button using xpath "//button[text()='Try it']"
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        
        //switch to the javascript alert
        Alert alert =  driver.switchTo().alert();
        
        //print the text on the alert
        String text = alert.getText();
        System.out.println("The text message written in the alert is : "+ text);
       
        // send your name to alert text field and accept it
        alert.sendKeys("Poonam Kate");
        // Thread.sleep(2000);
        alert.accept();
        
        // check if your name is get printed or not Using Xpath "//p[@id='demo']"
        WebElement validation = driver.findElement(By.xpath("//p[@id='demo']"));
        if(validation.getText().equals("Hello Poonam! How are you today?")){
            System.out.println("Yes the name is getting printed");
        }else{
            System.out.println("Name is not getting printed");
        }
     
    }
}
