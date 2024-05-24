package ru.iteco.fmhandroid.ui.tests;

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
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.TopicalQuotesSteps;


    @LargeTest
    @RunWith(AllureAndroidJUnit4.class)

    @Epic("Тест-кейс для проведения функционального тестирования вкладки 'love is all' мобильного приложения 'Мобильный хоспис'")
    public class TopicalQuotesTest {

        TopicalQuotesSteps topicalQuotes = new TopicalQuotesSteps();
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
            } catch (Exception e) {
                authorization.validAuthorization();
            }
        }

        @DisplayName("Тест №12 Развернуть и свернуть цитату, во вкладке \"Love is all\" приложения")
        @Test
        public void showAndHideQuoteTest() {
            topicalQuotes.openQuotesPage();
            topicalQuotes.checkQuote(2);
            topicalQuotes.descriptionIsDisplay(DataHelper.quoteText);
            topicalQuotes.checkQuote(2);
            topicalQuotes.descriptionNotDisplay(DataHelper.quoteText);
        }
    }

