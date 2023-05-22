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

import com.google.common.io.Files;

public class TestCases {
    static ChromeDriver driver;

    public static ChromeDriver TestCasesInitializer() {
        System.out.println("driver Initializer");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        // driver.close();
        driver.quit();

    }

    // SESSION 4 ASSIGMENTS
    public void testCase01() {
        System.out.println("Start Test case: testCase01 is search amazon.in on Google Page");
        Amazon_search amazon = new Amazon_search();
        amazon.search_amazon_on_google();
    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02 is Count of Hyperlinks present on Page of BookMyShow");
        Bookmyshow_hyperlink hyperlink = new Bookmyshow_hyperlink();
        hyperlink.count_links_onpage();
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start testCase: testCase03 : Create Post on Linkedin");

        CreatePost_on_Linkidin p = new CreatePost_on_Linkidin();
        p.post_link();
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start testCase: testCase04 is Automate the my name in google and count it ");
        Automate_name name = new Automate_name();
        name.Myname();
    }

    public void testCase05() throws InterruptedException {
        System.out.println(
                "Start testCase: testCase05 is finding the image url and print the name and Language of 2nd premier list");
          Automate_image_url url = new Automate_image_url();
          url.imageurl();
}

    public void testCase06() throws InterruptedException, AWTException {
        
        System.out.println("Test case 06 is to create a post on linkedin with Image or Video");
        Automate_post_image_or_video_linkedin video = new Automate_post_image_or_video_linkedin();
        video.image_video_Link();
    }

    public void testCase07() throws InterruptedException
    {
        System.out.println("Start testCase: testCase07 is nested frame and print the text from that framw");
        nested_frames_text nest = new nested_frames_text();
        nest.frame();
    }
}
