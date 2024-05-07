package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static ru.iteco.fmhandroid.ui.page.NewsPage.CONTROLPANEL;
import static ru.iteco.fmhandroid.ui.utils.Utils.childAtPosition;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;

import android.widget.ImageView;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.MainPage;

public class DataHelper {

    public static final String VALIDLOGIN = "login2";
    public static final String VALIDPASSWORD = "password2";

    public static final String INVALIDLOGIN = "login";
    public static final String INVALIDPASSWORD = "password";

    public static final String EMPTYLOGIN = "";
    public static final String EMPTYPASSWORD = "";

    public static final int FIELDOFLOGIN = R.id.login_text_input_layout;
    public static final int FIELDOFPASSWORD = R.id.password_text_input_layout;
    public static final int SIGNINBUTTON = R.id.enter_button;
    public static final String WRONGPASSWORDANDLOGIN = "Something went wrong. Try again later.";
    public static final String WRONGLOGIN = "Wrong login or password";
    public static final String ERORREMPTYOFLOGINORPASSWORD = "Login and password cannot be empty";


    public static void fillingOutOfField(int field, String inputText) {
        Allure.step("Заполнение выбранного поля текстом: {inputText}");
        onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(field),
                                0),
                        0)))
                .perform(replaceText(inputText), closeSoftKeyboard());
    }

    @Step("Появление всплывающего сообщения об ошибке 'Неверные данные'")
    public static void checkToastErrorMessage(String messageError) {
    onView(allOf(withContentDescription(messageError), isDisplayed()));
}
    public static void selectField(int field) {
        Allure.step("Выбор поля для ввода данных");
        onView(withId(field)).perform(click());
    }
    public static void clickItem(int item) {
        Allure.step("Клик по выбранному элементу на странице");
        onView(withId(item)).perform(click());
    }
    public static void PageIsReached(int pageMarker) {
        Allure.step("Проверка, что отображается страница с указанным элементом");
        ViewInteraction marker = onView(withId(pageMarker)).check(matches(isDisplayed()));
    }
    public static void waitPage(int pageMarker) {
        Allure.step("Ожидание загрузки страницы с указанным элементом");
        onView(isRoot()).perform(waitDisplayed(pageMarker,15000 ));
    }

}



