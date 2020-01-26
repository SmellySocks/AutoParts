package pl.hyla.labone;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterPage {

    private WebDriver webDriver;

    public RegisterPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void open(){
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        PageFactory.initElements(webDriver, this);
    }

    public boolean register(){
        WebDriver webDriver = new FirefoxDriver();
        Random random = new Random();
        int rand1 = random.nextInt() *20;
        int rand2 = random.nextInt() *20;

        webDriver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.id("email_create")).sendKeys("mejl"+rand1 + rand2+"@jajco.org");
        webDriver.findElement(By.id("SubmitCreate")).click();

        webDriver.findElement(By.id("id_gender1")).click();
        webDriver.findElement(By.id("customer_firstname")).sendKeys("Jajco");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("superjajco");
        webDriver.findElement(By.id("passwd")).sendKeys("jajcojajcojajco");

        webDriver.findElement(By.xpath(".//*[@id='newsletter']")).click();

        webDriver.findElement(By.xpath("//*[@id='optin']")).click();

        webDriver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Michal");
        webDriver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Hyla");
        webDriver.findElement(By.xpath("//*[@id='company']")).sendKeys("PJATK");
        webDriver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Brzegi 55");
        webDriver.findElement(By.xpath("//*[@id='address2']")).sendKeys(" ");
        webDriver.findElement(By.xpath("//*[@id='city']")).sendKeys("Gdansk");

        Select sState = new Select(webDriver.findElement(By.xpath("//*[@id='id_state']")));
        sState.selectByVisibleText("Alabama");

        webDriver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("69420");

        Select sCountry = new Select(webDriver.findElement(By.xpath("//*[@id='id_country']")));
        sCountry.selectByVisibleText("United States");

        webDriver.findElement(By.xpath("//*[@id='other']")).sendKeys("jajco");
        webDriver.findElement(By.xpath("//*[@id='phone']")).sendKeys("69696969");
        webDriver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("420420420420");
        webDriver.findElement(By.xpath("//*[@id='alias']")).sendKeys("SmellySocks");

        webDriver.findElement(By.xpath("//*[@id='account-creation_form']")).click();


        return true;



    }
}

