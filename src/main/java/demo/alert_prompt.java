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
// import org.rauschig.jarchivelib.FileModeMapper.PosixPermissionMapper;

public class alert_prompt {
    ChromeDriver driver;

    public void alert() throws InterruptedException {
        this.driver = TestCases.TestCasesInitializer();

        // navigate to the url
        // https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        // Go to the iframe where "try it" button is present Using Xpath
        // //iframe[@name='iframeResult']
        WebElement framess = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        driver.switchTo().frame(framess);

        // click on the "try it" button using xpath "//button[text()='Try it']"
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        
        // switch to the javascript alert
        Alert alert = driver.switchTo().alert();

        // print the text on the alert
        String text = alert.getText();

        System.out.println("The text message written in the alert is : " + text);

        // send your name to alert text field and accept it
        String myName = "Poonam";
        alert.sendKeys("Poonam");
        alert.accept();
       
        // check if your name is get printed or not Using Xpath "//p[@id='demo']"
        WebElement output = driver.findElement(By.xpath("//p[@id='demo']"));
        String outputText = output.getText();
        
        if (outputText.contains("Poonam")) {
            System.out.println("Hello Poonam! How are you today?");
        } else {
            System.out.println("Name is not Printed");
        }

    }

}
