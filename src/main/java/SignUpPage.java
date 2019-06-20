import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By header = By.xpath("//div[@class='container-lg p-responsive py-5']//h1");
    private By usernameField = By.xpath("//input[@id=\"user_login\"]");
    private By emailField = By.xpath("//input[@id=\"user_email\"]");
    private By passwordField = By.xpath("//input[@id=\"user_password\"]");
    private By submitButton = By.xpath("//button[@id=\"signup_button\"]");
    private By mainError = By.xpath("//form[@id='signup-form']/child::div");
    //private By loginError = By.xpath("//form[@id='signup-form']/descendant::dd[2]");
    //private By loginError = By.xpath("//dd[@id=\"description_db35722743cc\"]");
    private By loginError = By.xpath("//input[@id='user_login']/ancestor::dd/following-sibling::dd");
    //private By emailError = By.xpath("/form[@id='signup-form']/descendant::dd[4]");
    //private By emailError = By.xpath("//dd[@id=\"description_06e6f156e05a\"]");
    private By emailError = By.xpath("//input[@id='user_email']/ancestor::dd/following-sibling::dd");
    //private By passwordError = By.xpath("/form[@id='signup-form']/descendant::dd[6]");
    //private By passwordError = By.xpath("//dd[@id=\"description_04f35fba6b30\"\"]");
    private By passwordError = By.xpath("//input[@id='user_password']/ancestor::dd/following-sibling::dd");

    public SignUpPage typeUserName(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(submitButton);
        return new SignUpPage(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getLoginErrorText() {
        return driver.findElement(loginError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

}
