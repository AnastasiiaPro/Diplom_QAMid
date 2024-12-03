package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.User.REGISTERED_USER;
import static ru.iteco.fmhandroid.testdata.User.UNREGISTERED_USER;
import static ru.iteco.fmhandroid.testdata.User.USER_WITHOUT_LOGIN;
import static ru.iteco.fmhandroid.testdata.User.USER_WITHOUT_PASSWORD;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;

import ru.iteco.fmhandroid.tests.FirstTest;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница «Авторизация»")
public class LoginPageTest extends FirstTest {
    @Test
    @DisplayName("Авторизация в приложении зарегистрированного пользователя")
    public void loginWithRegisteredUserTest() {
        loginPageSteps.login(REGISTERED_USER);
        mainPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Авторизация в мобильном приложении незарегистрированного пользователя")
    public void loginWithUnregisteredUserTest() {
        loginPageSteps.login(UNREGISTERED_USER);
        loginPageSteps.checkWrongUserDataToastIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация в мобильном приложении при пустом поле «Логин»")
    public void loginWithEmptyLoginTest() {
        loginPageSteps.login(USER_WITHOUT_LOGIN);
        loginPageSteps.checkEmptyUserDataToastIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация в мобильном приложении при пустом поле «Пароль»")
    public void loginWithEmptyPasswordTest() {
        loginPageSteps.login(USER_WITHOUT_PASSWORD);
        loginPageSteps.checkEmptyUserDataToastIsDisplayed();
    }
}
