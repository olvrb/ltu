package Websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Website {
    protected WebDriver driver = new ChromeDriver();

    public Website() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        this.driver.manage()
                   .window()
                   .maximize();
        this.init();
    }

    public void goTo(String url) {
        this.driver.get(url);
    }


    public abstract void init();

    public WebElement findByXPath(String xPath) {
        return this.driver.findElement(By.xpath(xPath));
    }

}
