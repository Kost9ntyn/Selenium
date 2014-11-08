package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 07.11.2014.
 */
public class StylusSearch {
    WebDriver driver;

    //Preconditions
    @BeforeClass
    public void setUp(){
        //Initializes a browser
        driver = new FirefoxDriver();
        //Sets implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Maximizes a window size
        driver.manage().window().maximize();

        //Opens a url
        driver.get("http://stylus.com.ua");
    }

    @Test
    public void searchTest() {
        // Finds an element by name
        WebElement searchField = driver.findElement(By.className("s_in"));

        // Sends "Sony Xperia Z2 Black" text into an input field
        searchField.sendKeys("Sony Xperia Z2 Black");

        //Presses a search key
        WebElement pressLink = driver.findElement(By.id("button"));
        pressLink.click();

        //Finds first link with specified result
        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/h4/a"));

        //Verifies a result
        Assert.assertEquals(seleniumLink.getText().toString().contains("Sony Xperia Z2 Black"), true);
    }



    @AfterClass
    public void tearDown(){
        //Closes a browser
        driver.quit();
    }
}
