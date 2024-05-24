package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.ui.page.TopicalQuotesPage.descriptionQuoteField;
import static ru.iteco.fmhandroid.ui.page.TopicalQuotesPage.getDescriptionText;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.TopicalQuotesPage;

public class TopicalQuotesSteps {
    static TopicalQuotesPage topicalQuotes = new TopicalQuotesPage();

    public void checkQuotesPage() {
        Allure.step("Проверка, что открыта страница 'Love is all'");
        topicalQuotes.loveIsAllPage.check(matches(isDisplayed()));
    }
    public static void openQuotesPage() {
        Allure.step("Открытие страницы с цитатами");
        topicalQuotes.openPageQuotes.perform(click());
    }

    public static void checkTextQuote(String description) {
        Allure.step("Проверка текста цитаты");
        onView(allOf(withId(descriptionQuoteField), withText(description), isDisplayed())).perform(click());;
    }

        public void checkQuote(int number) {
            Allure.step("Развернуть/свернуть цитату");
            topicalQuotes. constraintlayout.check(matches(isDisplayed()));
            topicalQuotes.constraintlayout.perform(actionOnItemAtPosition(number, click()));
        }

        public void descriptionNotDisplay(String text) {
            Allure.step("Отображение цитаты");
            onView(allOf(getDescriptionText(),
                    withText(text))).check(matches(not(isDisplayed())));
        }

        public void descriptionIsDisplay(String text) {
            Allure.step("Cкрытие цитаты");
            onView(allOf(getDescriptionText(),
                    withText(text))).check(matches(isDisplayed()));
        }
    }

