package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.PageIsReached;
import static ru.iteco.fmhandroid.ui.data.DataHelper.WRONGLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.ERORREMPTYOFLOGINORPASSWORD;
import static ru.iteco.fmhandroid.ui.data.DataHelper.WRONGPASSWORDANDLOGIN;
import static ru.iteco.fmhandroid.ui.data.DataHelper.clickItem;
import static ru.iteco.fmhandroid.ui.data.DataHelper.selectField;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitPage;

import android.os.SystemClock;

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
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.data.DataHelper;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тесты для функционального тестирования: вкладки 'authorization' мобильного приложения 'Мобильный хоспис' ")
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void SetUp() {
        try {
            waitPage(DataHelper.FIELDOFLOGIN);
        } catch (Exception e) {
            MainPage.logOut();
        }
    }

    @DisplayName("Тест №1 'Ввод валидных значений в поля login и password(позитивный тест)'")
    @Test
    public void successfulLogin()  {
        waitPage(DataHelper.FIELDOFLOGIN);
        selectField(DataHelper.FIELDOFLOGIN);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN, DataHelper.VALIDLOGIN);
        selectField(DataHelper.FIELDOFPASSWORD);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD, DataHelper.VALIDPASSWORD);
        clickItem(DataHelper.SIGNINBUTTON);
        waitPage(MainPage.MAINMENUBUTTON);
        PageIsReached(MainPage.MAINMENUBUTTON);
    }

    @DisplayName("Тест №2 'Выход из приложения(позитивный тест)'")
    @Test
    public void successfulLogOut()  {
        waitPage(DataHelper.FIELDOFLOGIN);
        selectField(DataHelper.FIELDOFLOGIN);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN, DataHelper.VALIDLOGIN);
        selectField(DataHelper.FIELDOFPASSWORD);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD, DataHelper.VALIDPASSWORD);
        clickItem(DataHelper.SIGNINBUTTON);
        waitPage(MainPage.MAINMENUBUTTON);
        MainPage.logOut();
        waitPage(DataHelper.FIELDOFLOGIN);
        PageIsReached(DataHelper.FIELDOFLOGIN);
    }
    @DisplayName("Тест №3 'Отсутствие ввода в поля login и password(негативный тест)'")
    @Test
    public void failedLoginWithEmptyLoginAndPassword()  {
        waitPage(DataHelper.FIELDOFLOGIN);
        selectField(DataHelper.FIELDOFLOGIN);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN, DataHelper.EMPTYLOGIN);
        selectField(DataHelper.FIELDOFPASSWORD);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD, DataHelper.EMPTYPASSWORD);
        clickItem(DataHelper.SIGNINBUTTON);
        SystemClock.sleep(5000);
        DataHelper.checkToastErrorMessage(ERORREMPTYOFLOGINORPASSWORD);

    }

    @DisplayName("Тест №4 'Ввод невалидных данных в поле password(негативный тест)'")
    @Test
    public void failedLoginWithWrongPassword()  {
        waitPage(DataHelper.FIELDOFLOGIN);
        selectField(DataHelper.FIELDOFLOGIN);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN, DataHelper.VALIDLOGIN);
        selectField(DataHelper.FIELDOFPASSWORD);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD, DataHelper.INVALIDPASSWORD);
        clickItem(DataHelper.SIGNINBUTTON);
        SystemClock.sleep(5000);
        DataHelper.checkToastErrorMessage(WRONGPASSWORDANDLOGIN);
    }

    @DisplayName("Тест №5 'Ввод невалидных данных в поле login(негативный тест)'")
    @Test
    public void failedLoginWithWrongLogin() {
        waitPage(DataHelper.FIELDOFLOGIN);
        selectField(DataHelper.FIELDOFLOGIN);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFLOGIN, DataHelper.INVALIDLOGIN);
        selectField(DataHelper.FIELDOFPASSWORD);
        DataHelper.fillingOutOfField(DataHelper.FIELDOFPASSWORD,DataHelper.VALIDPASSWORD);
        clickItem(DataHelper.SIGNINBUTTON);
        SystemClock.sleep(5000);
        DataHelper.checkToastErrorMessage(WRONGPASSWORDANDLOGIN);
    }
}

