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

public class AdlibrisTest {
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
    public void adlibris() {
        this.driver.get("https://www.adlibris.com/se");
        this.driver.manage()
                   .window()
                   .setSize(new Dimension(1258, 711));
        this.driver.findElement(By.id("q"))
                   .click();
        this.driver.findElement(By.id("q"))
                   .sendKeys("praktisk mjukvarutestning");
        this.driver.findElement(By.id("q"))
                   .sendKeys(Keys.ENTER);
        this.driver.findElement(By.linkText("Praktisk mjukvarutestning"))
                   .click();
        this.driver.findElement(By.cssSelector(".product__add-to-cart:nth-child(1)"))
                   .click();
        this.driver.findElement(By.cssSelector(".page-header__toggler > .material-icons__shopping_cart"))
                   .click();

        // "Till kassan" doesn't load directly, so wait for it to be available. 10 second timeout.
        WebDriverWait wait = new WebDriverWait(this.driver, 10);

        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Till kassan")));

        el.click();
    }
}
