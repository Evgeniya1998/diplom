package ru.iteco.fmhandroid.ui.page;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.clickItem;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitPage;

import androidx.test.espresso.matcher.RootMatchers;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainPage {
    public static final int MAINMENUBUTTON = R.id.main_menu_image_button;
    public static final int USERPROFILE = R.id.authorization_image_button;
    public static final int LOGOUTBUTTON = android.R.id.title;
    public static final int ALLNEWSHEADLINE = R.id.all_news_text_view;
    public static final int QUOTESBUTTON = R.id.our_mission_image_button;

    public static void logOut() {
        Allure.step("log out");
        waitPage(MAINMENUBUTTON);
        onView(withId(USERPROFILE)).perform(click());
        onView(withId(LOGOUTBUTTON)).perform(click());
    }


    public static void clickMainMenuItem(String item) {
        Allure.step("Выбор(клик) элемента в главном меню");
        clickItem(MAINMENUBUTTON);
        onView(withText(item))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }
}