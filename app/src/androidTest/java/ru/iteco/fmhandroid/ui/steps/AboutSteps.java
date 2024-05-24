package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.core.AllOf.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.urlPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.data.DataHelper.urlTermsOfUse;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;

import android.app.Instrumentation;
import android.content.Intent;
import androidx.test.espresso.intent.Intents;
import org.hamcrest.Matcher;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.AboutPage;

public class AboutSteps {
    AboutPage about = new AboutPage();

    public void checkingAboutPage() {
        Allure.step("Проверить, что это страница О приложении");
        about.title.check(matches(isDisplayed()));
    }

    public void checkingUrlPrivacy() {
        Allure.step("Переход по ссылке Политики конфиденциальности");
        Intents.init();
        //Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(urlPrivacyPolicy));
        //intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        about.privacyPolicy.perform(click());
        intended(hasData(urlPrivacyPolicy));
        //intended(expectedIntent);
        Intents.release();
    }
    public void checkingUrlTerms()  {
        Allure.step("Переход по ссылке Пользовательского соглашения");
        Intents.init();
        about.termsOfUse.perform(click());
        //Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(urlTermsOfUse));
       // intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        intended(hasData(urlTermsOfUse));
        Intents.release();

    }
    public void backButton() {
        Allure.step("Возврат к предыдущей странице");
        about.backButton.perform(click());
    }
}