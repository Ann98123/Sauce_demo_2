package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;
import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");
    WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
}
