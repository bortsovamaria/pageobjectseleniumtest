import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/o12345/IdeaProjects/pageobjectseleniumtest/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://github.com");

        //MainPage mainPage = new MainPage(driver);

        //PageFactory
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.register("testusername", "qweqweqwe@xcsx.com", "qweqwefd234243WQE");
    }
}
