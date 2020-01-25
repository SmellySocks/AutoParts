package pl.hyla.labone.selenium;

import org.jbehave.core.annotations.Then;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.hyla.labone.LoginPage;
import pl.hyla.labone.RegisterPage;
import pl.hyla.labone.StartPage;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    private static WebDriver webDriver;
    private StartPage startPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;


@BeforeClass
public static void driverSetup() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\micha\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
    webDriver = new FirefoxDriver();
    webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);
    }
    @Before
    public void before() {
        startPage = new StartPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        webDriver.manage().window().fullscreen();
    }
    @Test
    public void loginFailed(){
    loginPage.open();
    loginPage.loginFailed();
   assertFalse(loginPage.isLoginFailed());
    }

    @Test
    public void loginSuccess(){
    loginPage.open();
    loginPage.loginSuccess();
    assertEquals("http://automationpractice.com/index.php?controller=my-account", loginPage.isLoginSuccessfull());
    }
    @Test
    public void register(){
    registerPage.open();
    registerPage.register();
    }

    @Test
    public void popularCount() {
    webDriver.manage().window().setSize(new Dimension(300, 700));
    startPage.open();
    startPage.clickPopular();
    assertEquals(7, startPage.getProducts().size());
    }

    @Test
    public void popularCountFail(){
    startPage.open();
    startPage.clickPopular();
    assertNotEquals(9, startPage.getProducts().size());
    }
    @After
    public void cleanup(){
    webDriver.close();
    }



}