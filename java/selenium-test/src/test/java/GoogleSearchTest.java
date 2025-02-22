import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleSearchTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void googlesearch() {
        this.driver.get("https://www.google.com/");
        this.driver.manage()
                   .window()
                   .setSize(new Dimension(1258, 711));
        this.driver.findElement(By.name("q"))
                   .sendKeys("system testing");
        this.driver.findElement(By.name("q"))
                   .sendKeys(Keys.ENTER);
    }
}
