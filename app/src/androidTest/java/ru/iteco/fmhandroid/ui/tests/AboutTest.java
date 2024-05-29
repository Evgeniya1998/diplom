package ru.iteco.fmhandroid.ui.tests;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import static ru.iteco.fmhandroid.ui.data.DataHelper.urlTermsOfUse;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки 'about' мобильного приложения 'Мобильный хоспис'")
public class AboutTest {
    AuthorizationSteps auth = new AuthorizationSteps();
    AboutSteps about = new AboutSteps();
    AuthorizationSteps authorization = new AuthorizationSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void SetUup() {
        try {
            authorization.checkMainPage();
        } catch (Exception  e) {
            authorization.validAuthorization();
        }
    }

    @DisplayName("Тест №13 'Переход по ссылке 'Политика конфиденциальности'")
    @Test
    public void followTheLinkPrivacyPolicyTest() {
        auth.goMenuAbout();
        about.checkingAboutPage();
        //about.checkingUrlPrivacy();
        Intents.init();
        about.goToPrivacyPolicy();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        Intents.release();
        about.backButton();
    }

    @DisplayName("Тест №14 'Переход по ссылке 'Правила использования'")
    @Test
    public void followTheLinkTermsOfUseTest()  {
        auth.goMenuAbout();
        about.checkingAboutPage();
        //about.checkingUrlTerms();
        Intents.init();
        about.goToTermsOfUse();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
        about.backButton();
}
}