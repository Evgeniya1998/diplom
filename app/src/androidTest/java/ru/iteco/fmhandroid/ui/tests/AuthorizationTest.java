package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.ERORREMPTYOFLOGINORPASSWORD;
import static ru.iteco.fmhandroid.ui.data.DataHelper.WRONGPASSWORDANDLOGIN;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тесты для функционального тестирования: вкладки 'authorization' мобильного приложения 'Мобильный хоспис' ")

public class AuthorizationTest {
    AuthorizationSteps authorization = new AuthorizationSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void SetUp() {
        authorization.waitPage();
        try {
            authorization.checkAuthorization();
        } catch (NoMatchingViewException e) {
            authorization.logOut();
        }
    }

    @DisplayName("Тест №1 'Ввод валидных значений в поля login и password(позитивный тест)'")
    @Test
    public void successfulLogin() {
        authorization.checkAuthorization();
        authorization.validAuthorization();
    }

    @DisplayName("Тест №2 'Выход из приложения(позитивный тест)'")
    @Test
    public void successfulLogOut() {
        authorization.checkAuthorization();
        authorization.validAuthorization();
        authorization.logOut();
    }

    @DisplayName("Тест №3 'Отсутствие ввода в поля login и password(негативный тест)'")
    @Test
    public void failedLoginWithEmptyLoginAndPassword() {
        authorization.checkAuthorization();
        authorization.emptyLoginAndPassword();
        authorization.checkToastErrorMessage(ERORREMPTYOFLOGINORPASSWORD);
    }

    @DisplayName("Тест №4 'Ввод невалидных данных в поле 'login'(негативный тест)'")
    @Test
    public void failedLoginWithWrongLogin() {
        authorization.checkAuthorization();
        authorization.WrongLogin();
        authorization.checkToastErrorMessage(WRONGPASSWORDANDLOGIN);
    }

    @DisplayName("Тест №5 'Ввод невалидных данных в поле login(негативный тест)'")
    @Test
    public void failedLoginWithWrongPassword() {
        authorization.checkAuthorization();
        authorization.WrongPassword();
        authorization.checkToastErrorMessage(WRONGPASSWORDANDLOGIN);
    }
}