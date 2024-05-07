package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.clickItem;
import static ru.iteco.fmhandroid.ui.data.DataHelper.selectField;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitPage;
import static ru.iteco.fmhandroid.ui.data.DataHelper.PageIsReached;
import android.content.Intent;
import android.os.SystemClock;

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
import ru.iteco.fmhandroid.ui.page.AboutPage;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.MainPage;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки 'about' мобильного приложения 'Мобильный хоспис'")
public class AboutPageTest {
    private final String ABOUTMENUITEM = "About";

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setUp() {
        try {
            waitPage(MainPage.MAINMENUBUTTON);
        } catch (Exception e) {
            waitPage(DataHelper.FIELDOFLOGIN);
            selectField(DataHelper.FIELDOFLOGIN);
            DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN, DataHelper.VALIDLOGIN);
            selectField(DataHelper.FIELDOFPASSWORD);
            DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD,DataHelper.VALIDPASSWORD);
            clickItem(DataHelper.SIGNINBUTTON);
            waitPage(MainPage.MAINMENUBUTTON);
            PageIsReached(MainPage.MAINMENUBUTTON);
        }
    }

    @DisplayName("Тест №10 'Переход по ссылке 'Политика конфиденциальности'")
    @Test
    public void followTheLinkPrivacyPolicyTest()  {
        MainPage.clickMainMenuItem(ABOUTMENUITEM);
        SystemClock.sleep(5000);
        Intents.init();
        clickItem(AboutPage.PRIVACYPOLICYLINK);
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
        AboutPage.PRIVACYPOLICY.check(matches(isDisplayed()));
        pressBack();
    }
    @DisplayName("Тест №11 'Переход по ссылке 'Правила использования'")
    @Test
    public void followTheLinkTermsOfUseTest()  {
        MainPage.clickMainMenuItem(ABOUTMENUITEM);
        SystemClock.sleep(5000);
        Intents.init();
        clickItem(AboutPage.TERMSOFUSELINK);
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
        AboutPage.TERMSOFUSETEXT.check(matches(isDisplayed()));
        pressBack();
    }
}