package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.clickItem;
import static ru.iteco.fmhandroid.ui.utils.Utils.childAtPosition;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;


public class NewsPage {
    public static final int FILTERNEWSBUTTON = R.id.filter_news_material_button;
    public static final int APPLYFILTERBUTTON = R.id.filter_button;
    public static final int EDITNEWSBUTTON = R.id.edit_news_material_button;
    public static final int ADDNEWSBUTTON = R.id.add_news_image_view;
    public static final int NEWSLIST = R.id.news_list_recycler_view;
    public static final int NEWSTITLEFIELD = R.id.news_item_title_text_view;
    public static final int CATEGIRYBUTTONOFFILTER = com.google.android.material.R.id.text_input_end_icon;
    public static final ViewInteraction CONTROLPANEL = onView(withText("Control panel"));

    private static final int SAVENEWSBUTTON = R.id.save_button;
    private static final int CATEGORYBUTTON = com.google.android.material.R.id.text_input_end_icon;
    private static final int DATEPUBLICATION = R.id.news_item_publish_date_text_input_edit_text;
    private static final int TIMEPUBLICATION = R.id.news_item_publish_time_text_input_edit_text;
    private static final int DESCRIPTIONFIELD= R.id.news_item_description_text_input_edit_text;
    private static final int OKBUTTON = android.R.id.button1;
    public static final String CATEGORY = "День рождения";
    public static final String NEWSMENUITEM = "News";
    public static final String INVALIDDATE = "01.01.2020";
    public static final String ERORRMESSAGEWRONGDATE = "Invalid date!";


    public static void chooseCategory(String title) {
        Allure.step("Выбрать категорию новости: " + title);
        onView(allOf(withId(CATEGORYBUTTON), withContentDescription("Show dropdown menu"))).perform(click());//Show dropdown menu
        onView(withText(title))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public static void addNewsCurrentDate() {
        Allure.step("Выбрать текущую дату новой Новости");
        clickItem(DATEPUBLICATION);
        clickItem(OKBUTTON);
    }

    public static void addNewsInvalidDate(String date) {
        Allure.step("Добавить некорректную дату новой Новости");
        onView((withId(DATEPUBLICATION))).perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
    }


    public static void checkToastErrorMessage(String messageError) {
        Allure.step("Появление всплывающего сообщения об ошибке Неверные данные");
        onView(allOf(withContentDescription(messageError), isDisplayed()));
    }

    public static void addNewsCurrentTime() {
        Allure.step("Выбрать текущее время новой Новости");
        onView((withId(TIMEPUBLICATION))).perform(click());
        onView((withId(OKBUTTON))).perform(click());
    }

    public static void addNewsDescription(String description) {
        Allure.step("Добавить описание новой новости " + description);
        onView(withId(DESCRIPTIONFIELD))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    public static void saveFreshNews() {
        Allure.step("Сохранение новой Новости");
        onView((withId(SAVENEWSBUTTON))).perform(scrollTo(), click());
    }



    public static void findAddedNews(String description) {
        Allure.step("Найти добавленную новость через список всех новостей");
        onView(withText(description)).check(matches(isDisplayed()));
    }

    public static void checkNewsCategory(String title, int position) {
        Allure.step("Проверить категорию новости в Cписке");
        ViewInteraction textView = onView(
                allOf(withIndex(withId(NEWSTITLEFIELD), position),
                        isDisplayed()));
        textView.check(matches(withText(title)));
    }

    public static void chooseCategoryOfNews(String title) {
        Allure.step("Выбрать категорию новости " + title + " в Фильтре");
        onView(allOf(withId(CATEGIRYBUTTONOFFILTER), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText(title))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public static void selectStartFilterTimeInterval() {
        Allure.step("Выбрать НАЧАЛО интервала для Фильтра - текущую дату");
        DataHelper.clickItem(R.id.news_item_publish_date_start_text_input_edit_text);
        DataHelper.clickItem(android.R.id.button1);
    }

    public static void selectEndFilterTimeInterval() {
        Allure.step("Выбрать КОНЕЦ интервала для Фильтра - текущую дату");
        DataHelper.clickItem(R.id.news_item_publish_date_end_text_input_edit_text);
        DataHelper.clickItem(android.R.id.button1);
    }

    public static void clickFreshNews() {
        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));
    }
}