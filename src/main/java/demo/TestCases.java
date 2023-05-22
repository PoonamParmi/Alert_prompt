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
        driver.close();
        driver.quit();

    }
//SESSION 4 ASSIGMENTS
 public void testCase01(){
     System.out.println("Start Test case: testCase01 of search amazon.in on Google Page");
        Amazon_search amazon = new Amazon_search();
        amazon.search_amazon_on_google();
     }
     


    public void testCase02(){
        System.out.println("Start Test case: testCase02 Count Hyperlinks present on Page of BookMyShow");
        Bookmyshow_hyperlink hyperlink = new Bookmyshow_hyperlink();
        hyperlink.count_links_onpage();

        
    }


    public void testCase03() throws InterruptedException {
        System.out.println("Start testCase: testCase03");
        // Navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        
		// Type "Email or phone: in Username textbox Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("poonamkate13@gmail.com");
        
		// Type "Password" in password textbox Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("Parmi@4820");
        
		// Click on "Sign in" button Using Locator "XPath" //button[@type='submit']
        driver.findElementByXPath("//button[@type='submit']").click();
        
		// Print the count of "Who's viewed your profile" Using Locator "XPath"
        // //*[contains(text(),'viewed your
        // profile')]/../../following-sibling::div//strong
        String viewedProfile = driver
                .findElement(
                        By.xpath("//*[contains(text(),'viewed your profile')]/../../following-sibling::div//strong"))
                .getText();
        System.out.println("Who's viewed your profile: " + viewedProfile);
       
	   // Print the count of "Impressions of your post" Using Locator "XPath"
        // //*[text()='Impressions of your post']/../../following-sibling::div//strong

        String impressionPost = driver
                .findElement(By.xpath("//*[text()='Impressions of your post']/../../following-sibling::div//strong"))
                .getText();
        System.out.println("Impressions of your post: " + impressionPost);

        // Click on "Start a post" button Using Locator "XPath" //button[contains(@class,'share-box-feed-entry__trigger')]
        driver.findElementByXPath("//button[contains(@class,'share-box-feed-entry__trigger')]").click();

        // Type message in textbox Using Locator "XPath" //div[@data-placeholder='What do you want to talk about?']
        driver.findElementByXPath("//div[@data-placeholder='What do you want to talk about?']").sendKeys("SDLC");
        Thread.sleep(1000);
        // Click on "Post" button Using Locator "XPath"
        // //button[contains(@class,'share-actions__primary-action artdeco-button')]
        driver.findElementByXPath("//button[contains(@class,'share-actions__primary-action artdeco-button')]")
                .click();
        // Verify that "Post successful" message is displayed Using Locator "XPath" //*[text()='Post successful.']
        boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
        System.out.println("Post is posted successfully: " + isDisplayed);
    }

    public void testCase04() {
        System.out.println("Start testCase: testCase04");
        //Navigate to URL  https://www.google.com/
        driver.get("https://www.google.com/");
        
        //Click on Search Bar Using Locator "Name" q
        driver.findElement(By.name("q")).click();
        
        //Type in "Puja" in Search bar  Using Locator "Name" q
        driver.findElement(By.name("q")).sendKeys("Puja");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        
        //Click on Google Search Button Using Locator "XPath" (//input[@value='Google Search'])[1]
        int count = driver.findElements(By.partialLinkText("Puja")).size();
        
        //Count of links in the search result with name Using Locator "XPath" //h3[text()='Puja']
        //int count = driver.findElementByXPath("a");
        System.out.println("count :" + count);
    }
    
    public void testCase05() throws InterruptedException {
        System.out.println("Start testCase: testCase05");
        
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
    
//SESSION 5 ASSIGMENTS
    
public void testCase06() throws InterruptedException, AWTException{
    // Navigate to URL https://www.linkedin.com/
    driver.get("https://www.linkedin.com/");
    // Type "Email or phone: in Username textbox Using Locator "Name" session_key
    driver.findElementByName("session_key").sendKeys("poonamkate13@gmail.com");
    // Type "Password" in password textbox Using Locator "Name" session_password
    driver.findElementByName("session_password").sendKeys("Parmi@4820");
    // Click on "Sign in" button Using Locator "XPath" //button[@type='submit']
    driver.findElementByXPath("//button[@type='submit']").click();
    // Click on "Photo" button Using Locator "XPath" //button[@aria-label='Add a
    // photo']
    driver.findElementByXPath("//button[@aria-label='Add a photo']").click();
   Thread.sleep(2000);  
    
   // Select the photo with the help of Robot Class
    StringSelection s = new StringSelection("D:\\image\\nature.png");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
    Robot robot = new Robot();   // Robot class throws AWT Exception
    robot.delay(1000);
    
    robot.keyPress(KeyEvent.VK_CONTROL);    //Press ctrl+v
    robot.keyPress(KeyEvent.VK_V);          //Press ctrl+v

    robot.keyRelease(KeyEvent.VK_V);        //Release ctrl+v
    robot.keyRelease(KeyEvent.VK_CONTROL);  //Release ctrl+v

    // robot.keyPress(KeyEvent.VK_ENTER);
    robot.delay(1000);

    // robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_ENTER);      //Press Enter
    robot.keyRelease(KeyEvent.VK_ENTER);    //Release Enter
    robot.delay(2000);
    
    //Click on the"Done" button Using Locator "XPath" //div[@class='share-box-footer__main-actions']//button[2]
    driver.findElementByXPath("//div[@class='share-box-footer__main-actions']//button[2]").click();

    //Click on "Post" button Using Locator "XPath" //button[contains(@class,'share-actions__primary-action artdeco-button')]
    driver.findElementByXPath("//button[contains(@class,'share-actions__primary-action artdeco-button')]").click();

    //Verify that "Post successful" message is displayed Using Locator "XPath" //*[text()='Post successful.']
    boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
    System.out.println("Post is posted successfully: " + isDisplayed);
}

    
    public void testCase07() {
        System.out.println("Start testCase: testCase07");
        //Navigate to URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        
        //Search for the first BODY in html code Using Locator "XPath" //body[contains(text(),'LEFT')]
        String leftText = driver.findElementByXPath("//body[contains(text(),'LEFT')]").getText();
        System.out.println("First Text: "+ leftText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");

        //Search for the middle BODY in html code Using Locator "XPath" //div[contains(text(),'MIDDLE')]
        String middleText = driver.findElementByXPath("//div[contains(text(),'MIDDLE')]").getText();
        System.out.println("Second Text: "+ middleText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");

        //Search for the RIGHT BODY in html code Using Locator "XPath" //body[contains(text(),'RIGHT')]
        String rightText = driver.findElementByXPath("//body[contains(text(),'RIGHT')]").getText();
        System.out.println("Third Text: "+ rightText);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        //Search for the BOTTOM BODY in html code Using Locator "XPath" //body[contains(text(),'BOTTOM')]
        String belowText = driver.findElementByXPath("//body[contains(text(),'BOTTOM')]").getText();
        System.out.println("Fourth Text: "+ belowText);
    }

    public void testCase08() throws InterruptedException{
        System.out.println("Start testCase: testCase08");

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
        Thread.sleep(2000);
        alert.accept();
        
        // check if your name is get printed or not Using Xpath "//p[@id='demo']"
        WebElement validation = driver.findElement(By.xpath("//p[@id='demo']"));
        if(validation.getText().equals("Hello Poonam! How are you today?")){
            System.out.println("Yes the name is getting printed");
        }else{
            System.out.println("Name is not getting printed");
        }
    }

    public void testCase09(){
        System.out.println("Start testCase: testCase09");
        //navigate to url "https://www.imdb.com/chart/top"
        driver.get("https://www.imdb.com/chart/top");
        
        // print the highest rated movies of the list By using Xpath //strong[text()='9.2']//parent::td//preceding-sibling::td[1]/a
        List<WebElement> highestRated = driver.findElements(By.xpath("//strong[text()='9.2']//parent::td//preceding-sibling::td[1]/a"));
        System.out.println("Highest rated movies are as follows :-");
        for(WebElement movie: highestRated){
            System.out.println(movie.getText());
        }
        
        //print how many movies are included in the list By using Xpath //tbody[@class='lister-list']/tr
        List<WebElement> movies = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
        System.out.println("Number of movies included in the list is : "+movies.size());
         
        //print the oldest movie of the list By using Xpath //span[text()='(1921)']/preceding-sibling::a
        WebElement oldest = driver.findElement(By.xpath("//span[text()='(1921)']/preceding-sibling::a"));
        System.out.println("Oldest movie of the list is : "+oldest.getText());
        
        //print the most recent movies of the list By using Xpath //span[text()='(2023)']/preceding-sibling::a
        List<WebElement> recentMovies = driver.findElements(By.xpath("//span[text()='(2023)']/preceding-sibling::a"));
        System.out.println("Most recent movies are as follows :-");
        for(WebElement film: recentMovies){
            System.out.println(film.getText());
        }
        
        //print the highest user rating in figure By using Xpath //tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]
        WebElement rating = driver.findElement(By.xpath("(//tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]"));
        System.out.println("Highest user ratings are : "+rating.getAttribute("title"));
        
        //Print the movie with most user rating By using Xpath //tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]/parent::td/preceding-sibling::td[1]/a
        WebElement mostRated = driver.findElement(By.xpath("(//tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]/parent::td/preceding-sibling::td[1]/a"));
        System.out.println("Most user rated movie name is : "+ mostRated.getText());
    }

    public void testCase10() throws InterruptedException{
        System.out.println("Start testCase: testCase10");
        //navigate to the url "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open"
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        
        // save the current window handle address
        String currWindow = driver.getWindowHandle();
        
        //Go to the frame where the "try it" button is present Using Locator "XPath" //iframe[@name='iframeResult']
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        driver.switchTo().frame(iframe);
        
        // click on the "try it" button Using Locator "XPath //button[@onclick='myFunction()']
        WebElement button = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();", button);
        Actions act = new Actions(driver);
        act.moveToElement(button).click().build().perform();
        Thread.sleep(3000);
        
        // save the address of newly open window and switch to it
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            if(!window.equals(currWindow)){
                driver.switchTo().window(window);
            }
        }
        // Get the url, title and take screenshot then close the window
        String currUrl = driver.getCurrentUrl();
        System.out.println("current url is : "+currUrl);
        String title = driver.getTitle();
        System.out.println("title of the page is : "+title);
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File("C:\\Users\\sayan\\OneDrive\\Desktop\\picture\\W3SchoolImage.png");
            Files.copy(SrcFile, DestFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
         // switch back to the original window
         driver.switchTo().window(currWindow);
    }  
}
  