import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/o12345/IdeaProjects/pageobjectseleniumtest/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String header = loginPage.getHeaderText();
        Assert.assertEquals("Sign in to GitHub", header);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("testuser", "testemail@email.com", "Password12345");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest() {
        SignUpPage signUpPage = mainPage.register("", "testemail@email.com", "Password12334");
        String error = signUpPage.getLoginErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpEmptyEmailTest() {
        SignUpPage signUpPage = mainPage.register("username", "", "Password12334");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest() {
        SignUpPage signUpPage = mainPage.register("username", "test@test.test", "Password12334");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
