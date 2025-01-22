import com.thoughtworks.gauge.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class WebTestImplementation {
    private WebDriver driver;
    private LoginPage loginPage;

    @Step("Initialize web driver")
    public void initializeWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Step("Navigate to <url>")
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @Step("Enter username <username>")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @Step("Enter password <password>")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("Verify login success")
    public void verifyLoginSuccess() {
        assert loginPage.isLoginSuccessful() : "Login was not successful";
    }

    @Step("Close web driver")
    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}