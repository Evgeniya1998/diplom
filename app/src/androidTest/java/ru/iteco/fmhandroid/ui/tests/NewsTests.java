package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.NEWTITLE;
import static ru.iteco.fmhandroid.ui.data.DataHelper.TITLE;
import static ru.iteco.fmhandroid.ui.data.DataHelper.TITLEFORDELETE;
import static ru.iteco.fmhandroid.ui.data.DataHelper.TITTLE;
import static ru.iteco.fmhandroid.ui.data.DataHelper.category;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тесты для функционального тестирования: вкладки 'Main' мобильного приложения 'Мобильный хоспис' ")

public class NewsTests {

       NewsSteps news = new NewsSteps();
       AuthorizationSteps authorization = new AuthorizationSteps();

        @Rule
        public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
                new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void SetUup() {
        try {
            authorization.checkMainPage();
        } catch (Exception  e) {
            authorization.validAuthorization();
        }
    }

    @DisplayName("Тест №6 Добавление новой новсти с текущей датой и временем")
    @Test
    public void addFreshNewsCurrentDataTest()  {
        news.goToTabNews();
        news.goToTabControlPanel();
        news.goToTabCreatingNews();
        news.randomCategoryNews();
        news.enterTittle(TITTLE);
        news.publicationDate();
        news.publicationTime();
        news.randomDescriptionNews();
        news.saveNews();
        news.checkNews(TITTLE);
    }

    @DisplayName("Тест №7 Отмена создания новости")
    @Test
    public void cancelAddNewsTest() {
        news.goToTabNews();
        news.goToTabControlPanel();
        news.goToTabCreatingNews();
        news.randomCategoryNews();
        news.randomTitleNews();
        news.publicationDate();
        news.publicationTime();
        news.randomDescriptionNews();
        news.cancelNews();
        news.checkPageControlPanek();
    }

    @DisplayName("Тест №8 Редактирование новости")
    @Test
    public void editNewsTest() {
        news.goToTabNews();
        news.goToTabControlPanel();
        news.goToTabCreatingNews();
        news.randomCategoryNews();
        news.enterTittle(TITLE);
        news.publicationDate();
        news.publicationTime();
        news.randomDescriptionNews();
        news.saveNews();
        news.clickEditNews(TITLE);
        news.enterTittle(NEWTITLE);
        news.saveNews();
        news.checkEditNews(NEWTITLE);
    }

    @DisplayName("Тест №9 Удаление новости")
    @Test
    public void deleteNewsTest() {
        news.goToTabNews();
        news.goToTabControlPanel();
        news.goToTabCreatingNews();
        news.randomCategoryNews();
        news.enterTittle(TITLEFORDELETE);
        news.publicationDate();
        news.publicationTime();
        news.randomDescriptionNews();
        news.saveNews();
       // news.checkPageControlPanek();
        news.clickDeleteNews(TITLEFORDELETE);
        news.checkDeleteNews(TITLEFORDELETE);//news.checkIfNoNewsWithTitle(TITLEFORDELETE);
    }

    @DisplayName("Тест №10 Сортировка новостей")
    @Test
    public void sortNews() {
        news.goToTabNews();
        news.sortNews();
        news.checkNewsPage();
    }
    @DisplayName("Тест №11 Фильтрация новостей по категориям")
    @Test
    public void newsFilteringByCategoryTest() {
        news.goToTabNews();
        news.goToTabControlPanel();
        news.filterNews();
        news.pushCategory();
        news.choseCategory(category);
        news.saveFilter();
        news.checkPageControlPanek();
    }
}
