package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest {
    String LOGIN = "login2";
    String PASSWORD = "password2";

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test

    public void appActivityTest() {
        try {
        sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));


        textInputEditText.check(matches(isDisplayed()));   // Проверка на отображение элемента
        textInputEditText.perform(replaceText(LOGIN), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(withId(R.id.password_text_input_layout));
        textInputEditText2.check(matches(isDisplayed()));
        textInputEditText2.perform(replaceText(PASSWORD), closeSoftKeyboard());

        ViewInteraction materialButton = onView((withId(R.id.enter_button)));
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());




    }


}
