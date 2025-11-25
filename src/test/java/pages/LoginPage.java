package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {

    private By loginInput = By.id("user-name");
    private By passInput = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие url страницы")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Логинимся под кредами пользователя: логин = {user.email}, пароль = *****")
    public void authorization(User user) {
        login(user.getEmail());
        password(user.getPassword());
        loginButton();
    }

    @Step("Вводим логин = {user.email}")
    public void login(String userName) {
        driver.findElement(loginInput).sendKeys(userName);
    }

    @Step("Вводим пароль = *****")
    public void password(String password) {
        driver.findElement(passInput).sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void loginButton() {
        driver.findElement(loginBtn).click();
    }

    @Step("Проверяем текст сообщения об ошибке")
    public String checkErrorMsg () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));

        return driver.findElement(errorMsg).getText();
        }
    }
