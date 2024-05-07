package ru.iteco.fmhandroid.ui.page;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class TopicalQuotesPage {
    public static final int missionLogo = R.id.our_mission_item_open_card_image_button;
    public static final int openQuoteButton = R.id.our_mission_item_open_card_image_button;
    public static final int descriptionQuoteField = R.id.our_mission_item_description_text_view;

    public static void openQuote(int position) {
        Allure.step("Открытие цитаты");
        onView(withIndex(withId(openQuoteButton), position)).perform(click());
    }
    public static void checkTextQuote(String description) {
        Allure.step("Проверка текста цитаты");
        onView(allOf(withId(descriptionQuoteField), withText(description), isDisplayed()));
    }
}