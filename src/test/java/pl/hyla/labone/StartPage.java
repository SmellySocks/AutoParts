package pl.hyla.labone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StartPage {

    private WebDriver webDriver;

    @FindBy(id = "home-page-tabs")
    WebElement popularLink;

    public StartPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getPopularLink(){
        return popularLink;
    }

    public void clickPopular() {
        getPopularLink().click();
    }

    public List<WebElement> getProducts() {
        return webDriver.findElement(By.cssSelector("#homefeatured")).findElements(By.tagName("li"));
    }

    public void open() {
        webDriver.get("http://automationpractice.com/index.php");
        PageFactory.initElements(webDriver, this);
    }
}
