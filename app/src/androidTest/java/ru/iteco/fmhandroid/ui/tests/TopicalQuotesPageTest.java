package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.VALIDLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.VALIDPASSWORD;
import static ru.iteco.fmhandroid.ui.data.DataHelper.PageIsReached;

import static ru.iteco.fmhandroid.ui.data.DataHelper.clickItem;
import static ru.iteco.fmhandroid.ui.data.DataHelper.selectField;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitPage;

import android.os.SystemClock;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.page.TopicalQuotesPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейс для проведения функционального тестирования вкладки 'love is all' мобильного приложения 'Мобильный хоспис'")
public class TopicalQuotesPageTest {

    private final String title = "\"Хоспис для меня - это то, каким должен быть мир.\"";
    private final String description = "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.\" Юля Капис, волонтер";
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
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
            DataHelper.fillingOutOfField(DataHelper .FIELDOFLOGIN,VALIDLOGIN);
            selectField(DataHelper.FIELDOFPASSWORD);
            DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD,VALIDPASSWORD);
            clickItem(DataHelper.SIGNINBUTTON);
            waitPage(MainPage.MAINMENUBUTTON);
            PageIsReached(MainPage.MAINMENUBUTTON);
        }
    }
    @DisplayName("Тест №12 'Открытие цитаты'")
    @Test
    public void openingQuoteTest()  {
        clickItem(MainPage.QUOTESBUTTON);
        SystemClock.sleep(5000);
        waitPage(TopicalQuotesPage.missionLogo);
        TopicalQuotesPage.checkTextQuote(title);
        TopicalQuotesPage.openQuote(0);
        TopicalQuotesPage.checkTextQuote(description);
    }
}