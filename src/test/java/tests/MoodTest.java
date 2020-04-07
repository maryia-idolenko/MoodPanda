package tests;

import org.testng.annotations.Test;

public class MoodTest extends BaseTest {

    @Test
    public void updateMoodTo10Test() {
        steps
                .login("moodpanda@mailinator.com", "qazQAZ1!")
                .updateMood(8, "Rating is changed", "Date");
    }
}