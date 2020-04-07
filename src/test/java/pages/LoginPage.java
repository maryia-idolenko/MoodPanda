package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    String URL = "https://moodpanda.com/login/";

    public LoginPage openPage() {
        open(URL);
        $(By.id("ContentPlaceHolderContent_AppStore")).waitUntil(Condition.visible, 30000);
        return this;
    }

    public LoginPage login(String user, String password) {
        sleep(2000);
        $(By.id("ContentPlaceHolderContent_TextBoxEmail")).sendKeys(user);
        $(By.id("ContentPlaceHolderContent_TextBoxPassword")).sendKeys(password);
        $(By.id("ContentPlaceHolderContent_ButtonLogin")).click();
        return this;
    }
}