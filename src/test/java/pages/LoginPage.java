package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    String URL = "https://moodpanda.com/login/";

    public LoginPage openPage() {
        open(URL);
        $(By.xpath("//*[@id=\"ContentPlaceHolderContent_AppStore\"]/a[1]/img")).waitUntil(Condition.visible, 30000);
        return this;
    }

    public LoginPage login(String user, String password) {
        sleep(10000);
        $(By.xpath("//*[@id=\"ContentPlaceHolderContent_TextBoxEmail\"]")).sendKeys(user);
        sleep(10000);
        $(By.xpath("//*[@id=\"ContentPlaceHolderContent_TextBoxPassword\"]")).sendKeys(password);
        sleep(10000);
        $(By.xpath("//*[@id=\"ContentPlaceHolderContent_ButtonLogin\"]")).click();
        return this;
    }
}