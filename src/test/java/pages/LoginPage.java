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
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Логинимся под кредами пользователя: логин = {user.email}, пароль = *****")
    public LoginPage authorization(User user) {
        login(user.getEmail());
        password(user.getPassword());
        loginButton();
        return this;
    }

    @Step("Вводим логин = {user.email}")
    public LoginPage login(String userName) {
        driver.findElement(loginInput).sendKeys(userName);
        return this;
    }

    @Step("Вводим пароль = *****")
    public LoginPage password(String password) {
        driver.findElement(passInput).sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку 'Login'")
    public LoginPage loginButton() {
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Проверяем текст сообщения об ошибке")
    public String checkErrorMsg () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));

        return driver.findElement(errorMsg).getText();
        }
    }
