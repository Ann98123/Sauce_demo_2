package user;
import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withIncorrectUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.incorrect_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withIncorrectPasswordPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.incorrect_password"));
    }

    public static User withEmptyUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.empty_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPasswordPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.empty_password"));
    }

    public static User withEmptyUserAndPasswordPermission() {
        return new User(PropertyReader.getProperty("saucedemo.empty_user"),
                PropertyReader.getProperty("saucedemo.empty_password"));
    }
}
