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

public class imdb_ratings {
    ChromeDriver driver;

    public void ratings() {
        this.driver = TestCases.TestCasesInitializer();
        // navigate to url "https://www.imdb.com/chart/top"
        driver.get("https://www.imdb.com/chart/top");

        // print the highest rated movies of the list By using Xpath
        // //strong[text()='9.2']//parent::td//preceding-sibling::td[1]/a
        List<WebElement> highestRated = driver
                .findElements(By.xpath("//strong[text()='9.2']//parent::td//preceding-sibling::td[1]/a"));
        System.out.println("Highest rated movies are as follows :-");
        for (WebElement movie : highestRated) {
            System.out.println(movie.getText());
        }

        // print how many movies are included in the list By using Xpath
        // //tbody[@class='lister-list']/tr
        List<WebElement> movies = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
        System.out.println("Number of movies included in the list is : " + movies.size());

        // print the oldest movie of the list By using Xpath
        // //span[text()='(1921)']/preceding-sibling::a
        WebElement oldest = driver.findElement(By.xpath("//span[text()='(1921)']/preceding-sibling::a"));
        System.out.println("Oldest movie of the list is : " + oldest.getText());

        // print the most recent movies of the list By using Xpath
        // //span[text()='(2023)']/preceding-sibling::a
        List<WebElement> recentMovies = driver.findElements(By.xpath("//span[text()='(2023)']/preceding-sibling::a"));
        System.out.println("Most recent movies are as follows :-");
        for (WebElement film : recentMovies) {
            System.out.println(film.getText());
        }

        // print the highest user rating in figure By using Xpath
        // //tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]
        WebElement rating = driver
                .findElement(By.xpath("(//tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]"));
        System.out.println("Highest user ratings are : " + rating.getAttribute("title"));

        // Print the movie with most user rating By using Xpath
        // //tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]/parent::td/preceding-sibling::td[1]/a
        WebElement mostRated = driver.findElement(By.xpath(
                "(//tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]/parent::td/preceding-sibling::td[1]/a"));
        System.out.println("Most user rated movie name is : " + mostRated.getText());

    }

}
