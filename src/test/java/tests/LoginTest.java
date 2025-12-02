package tests;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;
import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {UserFactory.withIncorrectUserPermission(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withIncorrectPasswordPermission(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withEmptyUserPermission(), "Epic sadface: Username is required"},
                {UserFactory.withEmptyPasswordPermission(), "Epic sadface: Password is required"},
                {UserFactory.withEmptyUserAndPasswordPermission(), "Epic sadface: Username is required"},
        };
    }

    @Epic("Модуль авторизации интернет-магазина")
    @Feature("Проверка ввода корретного логина и пароля")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Shnitkovskaya Anna shnitkovakayaanna@gmail.com")
    @TmsLink("Sauce_demo_2")
    @Test()
    public void authCorrect() {
        System.out.println("CorrectLogin Tests are running in thread: " + Thread.currentThread().getId());
        loginPage.open()
                .authorization(UserFactory.withAdminPermission());
        assertEquals(PRODUCTS.getDisplayName(), productsPage.getTitleText());
    }

    @Epic("Модуль авторизации интернет-магазина")
    @Feature("Проверка ввода некорретного логина и пароля")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Shnitkovskaya Anna shnitkovakayaanna@gmail.com")
    @Test(dataProvider = "loginData")
    public void authIncorrect(User user, String errorMsg) {
        System.out.println("IncorrectLogin Tests are running in thread: " + Thread.currentThread().getId());
        loginPage.open()
                .authorization(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
