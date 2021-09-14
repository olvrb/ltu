import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimetryfreeTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // this.driver.quit();
    }

    @Test
    public void actitimetryfree() {
        this.driver.get("https://www.actitime.com/");
        this.driver.findElement(By.id("cookie-button--got-it"))
                   .click();
        this.driver.findElement(By.linkText("Try Free"))
                   .click();
        this.driver.findElement(By.id("first-name"))
                   .click();
        this.driver.findElement(By.id("first-name"))
                   .sendKeys("test");
        this.driver.findElement(By.id("last-name"))
                   .sendKeys("test");
        this.driver.findElement(By.id("email"))
                   .sendKeys("test");
        this.driver.findElement(By.id("company"))
                   .sendKeys("test");
    }
}
