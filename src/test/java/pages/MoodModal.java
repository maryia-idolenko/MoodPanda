package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MoodModal {

    String UPDATE_BUTTON_CSS = ".ButtonUpdate";
    String MY_DIARY_BUTTON_CSS = ".ButtonMyDiary";

    public MoodModal isPageOpened() {
        $(UPDATE_BUTTON_CSS).should(Condition.appear);
        return this;
    }

    public MoodModal updateDetails(int moodRating, String description, String date) {
        sleep(10000);
        $("#TextBoxUpdateMoodTag").sendKeys(description);
        sleep(10000);
        if (moodRating > 5) {
            for (int i = 0; i < moodRating - 5; i++) {
                $(By.xpath("//*[@id=\"slider-range-min\"]/a")).click();
                $(By.xpath("//*[@id=\"slider-range-min\"]/a")).sendKeys(Keys.ARROW_RIGHT);
            }
        } else {
            for (int i = 0; i < 5 - moodRating; i++) {
                $(By.xpath("//*[@id=\"slider-range-min\"]/a")).click();
                $(By.xpath("//*[@id=\"slider-range-min\"]/a")).sendKeys(Keys.ARROW_LEFT);
            }
        }
        $(By.xpath("//*[@id=\"Advanced\"]/div/div[4]")).click();
        return this;
    }

    public MoodModal clickUpdateMood() {
        $(UPDATE_BUTTON_CSS).click();
        return this;
    }

    public void toDiary() {
        $(MY_DIARY_BUTTON_CSS).click();
    }
}