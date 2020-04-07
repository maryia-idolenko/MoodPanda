package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class MoodModal {

    String UPDATE_BUTTON_CSS = ".ButtonUpdate";
    String MY_DIARY_BUTTON_CSS = ".ButtonMyDiary";
    String SLIDER_HANDLE_CSS = ".ui-slider-handle";

    public MoodModal isPageOpened() {
        $(UPDATE_BUTTON_CSS).should(Condition.appear);
        return this;
    }

    public MoodModal updateDetails(int moodRating, String description, String date) {
        $("#TextBoxUpdateMoodTag").sendKeys(description);
        $(SLIDER_HANDLE_CSS).click();
        if (moodRating > 5) {
            for (int i = 0; i < moodRating - 5; i++) {
                $(SLIDER_HANDLE_CSS).sendKeys(Keys.ARROW_RIGHT);
            }
        } else {
            for (int i = 0; i < 5 - moodRating; i++) {
                $(SLIDER_HANDLE_CSS).sendKeys(Keys.ARROW_LEFT);
            }
        }
        $(".ResetNow.btn.btn-default.btn-sm").click();
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