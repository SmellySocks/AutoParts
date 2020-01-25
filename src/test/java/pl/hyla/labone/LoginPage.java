package pl.hyla.labone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver webDriver;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(css = "#passwd")
    WebElement passInput;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    WebElement submitBtn;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void open(){
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        PageFactory.initElements(webDriver, this);
    }


    public void loginFailed(){
        emailInput.sendKeys("mhyla@pjwstk.edu.pl");
        passInput.sendKeys("JaJco123");
        submitBtn.click();
    }
    public void loginSuccess(){
        emailInput.sendKeys("mhyla@pjwstk.edu.pl");
        passInput.sendKeys("JaJco1234");
        submitBtn.click();
    }
    public WebElement getLoginButton() {
        return submitBtn;
    }

    public WebElement getLoginInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passInput;
    }

    public boolean isLoginFailed() {
        return webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")) == null;
    }

    public String isLoginSuccessfull(){
        return webDriver.getCurrentUrl();
    }

}
