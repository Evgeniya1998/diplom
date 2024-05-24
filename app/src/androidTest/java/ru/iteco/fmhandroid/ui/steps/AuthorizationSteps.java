package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.EMPTYLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.EMPTYPASSWORD;
import static ru.iteco.fmhandroid.ui.data.DataHelper.INVALIDLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.INVALIDPASSWORD;
import static ru.iteco.fmhandroid.ui.data.DataHelper.VALIDLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.VALIDPASSWORD;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
public class AuthorizationSteps {

    AuthorizationPage auth = new AuthorizationPage();

    public void waitPage() {
        Allure.step("Ожидание загрузки 'Authorization");
        onView(isRoot()).perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_main, 10000));
    }

    public void checkAuthorization() {
        Allure.step("Проверка oкна авторизации");
        auth.openPageAuthirization.check(matches(isDisplayed()));
    }

    public void validAuthorization(){
        Allure.step("Заполнить поле 'login'");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(VALIDLOGIN));
        Allure.step("Заполнить поле 'password'");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(VALIDPASSWORD));
        Allure.step("Нажать на кнопку 'sign in'");
        auth.signIn.perform(click());
        checkMainPage();
    }

    public void goMenuAbout() {
        Allure.step("Переход в меню вкладки О приложении");
        auth.mainMenuButton.perform(click());
        auth.about.perform(click());
        auth.aboutPage.check(matches(isDisplayed()));
    }

    public void checkMainPage(){
        Allure.step("Проверка, что это главная страница");
        onView(isRoot()).perform(waitDisplayed(R.id.all_news_text_view, 10000));
        //main.InscriptionAllNews.check(matches(isDisplayed()));
    }

    public void logOut() {
        Allure.step("Выход из приложения");
        auth.InscriptionAuth.perform(click());
        auth.logOut.perform(click());
        auth.authorizationPage.check(matches(isDisplayed()));
    }
    public void emptyLoginAndPassword(){
        Allure.step("Оставить  поле 'login' пустым");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(EMPTYLOGIN));
        Allure.step("Заполнить поле 'password' валидными данными");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(EMPTYPASSWORD));
        Allure.step("Нажать на кнопку 'sign in'");
        auth.signIn.perform(click());
        }

    public void checkToastErrorMessage(String messageError) {
        Allure.step("Сообщение об ошибке");
            onView(allOf(withContentDescription(messageError), isDisplayed()));
    }
    public void WrongLogin(){
        Allure.step("Заполнить поле 'login' невалидными данными");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(INVALIDLOGIN));
        Allure.step("Заполнить поле 'password' валидными данными");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(VALIDPASSWORD));
        Allure.step("Нажать на кнопку 'sign in'");
        auth.signIn.perform(click());
    }

    public void WrongPassword(){
        Allure.step("Заполнить поле 'login' валидными данными");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(VALIDLOGIN));
        Allure.step("Заполнить поле 'password' невалидными данными");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(INVALIDPASSWORD));
        Allure.step("Нажать на кнопку 'sign in'");
        auth.signIn.perform(click());
    }
}
