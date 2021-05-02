package Websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Google extends Website {
    public void searchFor(String query) {
        WebElement el = this.getSearchInput();
        el.sendKeys("Software Testing");
        el.submit();
    }

    public WebElement getSearchInput() {
        return this.findByXPath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
    }

    @Override
    public void init() {
        this.goTo("https://google.com");
    }
    
}
