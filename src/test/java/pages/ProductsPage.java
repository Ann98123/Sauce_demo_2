package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";

    private By goodsCounter = By.cssSelector("a span");
    private By title = By.cssSelector(".title");
    private By addToCartButton = By.xpath("//*[text()='Add to cart']");
    private By basketIcon = By.cssSelector(".shopping_cart_link");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидаем прогрузки страницы с товарами")
    public ProductsPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return this;
    }

    @Step("Проверяем название страницы")
    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    @Step("Добавляем товар в корзину")
    public ProductsPage addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
        return this;
    }

    @Step("Добавляем товар в корзину")
    public ProductsPage addToCart(final int index) {
        driver.findElements(addToCartButton).get(index).click();
        return this;
    }

    @Step("Берем число товаров в корзине из каунтера")
    public String getGoodsCounter() {
        return driver.findElement(goodsCounter).getText();
    }

    @Step("Переходим в корзину")
    public ProductsPage switchToCart() {
        driver.findElement(basketIcon).click();
        return this;
    }
}
