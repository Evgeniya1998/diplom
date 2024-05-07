package ru.iteco.fmhandroid.ui.tests;
import static ru.iteco.fmhandroid.ui.data.DataHelper.PageIsReached;
import static ru.iteco.fmhandroid.ui.data.DataHelper.VALIDLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.VALIDPASSWORD;
import static ru.iteco.fmhandroid.ui.data.DataHelper.clickItem;
import static ru.iteco.fmhandroid.ui.data.DataHelper.selectField;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitPage;
import static ru.iteco.fmhandroid.ui.page.NewsPage.CATEGORY;
import static ru.iteco.fmhandroid.ui.page.NewsPage.ERORRMESSAGEWRONGDATE;
import static ru.iteco.fmhandroid.ui.page.NewsPage.INVALIDDATE;
import static ru.iteco.fmhandroid.ui.page.NewsPage.NEWSMENUITEM;

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
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки 'News' приложения 'Мобильный хоспис'")
public class NewsPageTest {

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
            DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN,VALIDLOGIN);
            selectField(DataHelper.FIELDOFPASSWORD);
            DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD,VALIDPASSWORD);
            clickItem(DataHelper.SIGNINBUTTON);
            waitPage(MainPage.MAINMENUBUTTON);
            PageIsReached(MainPage.MAINMENUBUTTON);
        }
    }

    @DisplayName("Тест №6 Добавление новой новсти с текущей датой и временем")
    @Test
    public void addFreshNewsCurrentDataTest()  {
        String newsDescription = Utils.getRandomNewsDescription();
        clickItem(MainPage.ALLNEWSHEADLINE); //all news
        clickItem(NewsPage.EDITNEWSBUTTON);
        clickItem(NewsPage.ADDNEWSBUTTON);
        NewsPage.chooseCategory(CATEGORY);
        NewsPage.addNewsCurrentDate();
        NewsPage.addNewsCurrentTime();
        NewsPage.addNewsDescription(newsDescription);
        NewsPage.saveFreshNews();
        waitPage(MainPage.MAINMENUBUTTON);
        MainPage.clickMainMenuItem(NEWSMENUITEM);
        waitPage(NewsPage.NEWSLIST);
        NewsPage.clickFreshNews();
        SystemClock.sleep(5000);
        NewsPage.findAddedNews(newsDescription);
    }

    @DisplayName("Тест №7 Добавление новой новости с текущей датой и временем через 'Главное меню'")
    @Test
    public void addFreshNewsCurrentDataNewsMenuTest()  {
        String newsDescription = Utils.getRandomNewsDescription();
        MainPage.clickMainMenuItem(NEWSMENUITEM);
        waitPage(NewsPage.NEWSLIST);
        clickItem(NewsPage.EDITNEWSBUTTON);
        clickItem(NewsPage.ADDNEWSBUTTON);
        NewsPage.chooseCategory(CATEGORY);
        NewsPage.addNewsCurrentDate();
        NewsPage.addNewsCurrentTime();
        NewsPage.addNewsDescription(newsDescription);
        NewsPage.saveFreshNews();
        waitPage(MainPage.MAINMENUBUTTON);
        MainPage.clickMainMenuItem(NEWSMENUITEM);
        waitPage(NewsPage.NEWSLIST);
        NewsPage.clickFreshNews();
        NewsPage.findAddedNews(newsDescription);
    }

    @DisplayName("Тест №8 Фильтрация новостей по категориям")
    @Test
    public void newsFilteringByCategoryTest() {
        clickItem(MainPage.ALLNEWSHEADLINE);
        waitPage(NewsPage.NEWSLIST);
        clickItem(NewsPage.FILTERNEWSBUTTON);
        NewsPage.chooseCategoryOfNews(CATEGORY);
        NewsPage.selectStartFilterTimeInterval();
        NewsPage.selectEndFilterTimeInterval();
        clickItem(NewsPage.APPLYFILTERBUTTON);
        waitPage(NewsPage.NEWSLIST);
        NewsPage.checkNewsCategory(CATEGORY, 0);
    }

    @DisplayName("Тест №9 Добавление новой новости с некорректной датой и корректным временем")
    @Test
    public void addFreshNewsInvalidDateTest()  {
        String newsDescription = Utils.getRandomNewsDescription();
        clickItem(MainPage.ALLNEWSHEADLINE);
        clickItem(NewsPage.EDITNEWSBUTTON);
        clickItem(NewsPage.ADDNEWSBUTTON);
        NewsPage.chooseCategory(CATEGORY);
        NewsPage.addNewsInvalidDate(INVALIDDATE);
        NewsPage.addNewsCurrentTime();
        NewsPage.addNewsDescription(newsDescription);
        NewsPage.saveFreshNews();
        NewsPage.checkToastErrorMessage(ERORRMESSAGEWRONGDATE);

    }
}