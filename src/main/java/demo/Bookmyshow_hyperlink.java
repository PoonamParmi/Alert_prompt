package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bookmyshow_hyperlink {
    ChromeDriver driver;
   
    public void count_links_onpage(){
        this.driver = TestCases.TestCasesInitializer();
        // Nevigate to Url  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // Locate the locater for hyperlink  Using Locator "Name" a
        int count = driver.findElements(By.tagName("a")).size();
        // Get count of the hyperlinks Using Locator "Name" a
        System.out.println(count);
     }
}
 