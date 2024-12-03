package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.pages.LoginPage;
import ru.iteco.fmhandroid.testdata.User;

public class LoginPageSteps extends FirstSteps {

    private final LoginPage loginPage = new LoginPage();

    public void checkPageIsLoaded() {
        Allure.step("Отображение страницы авторизации");
        waitForElement(withText(R.string.authorization), DEFAULT_TIMEOUT);
        loginPage.titleAuthorization.check(matches(isDisplayed()));
        loginPage.loginField.check(matches(isDisplayed()));
        loginPage.passwordField.check(matches(isDisplayed()));
        loginPage.signInButton.check(matches(isDisplayed()));
    }

    public void login(User user) {
        Allure.step("Авторизоваться по логину и паролю");
        enterText(loginPage.loginField, user.getLogin());
        enterText(loginPage.passwordField, user.getPassword());
        loginPage.signInButton.perform(click());
    }

    public void checkEmptyUserDataToastIsDisplayed() {
        Allure.step("Отображение уведомления «Логин и пароль не могут быть пустыми»");
        loginPage.emptyUserData.check(matches(isDisplayed()));
    }

    public void checkWrongUserDataToastIsDisplayed() {
        Allure.step("Отображение уведомления «Неверный логин или пароль»");
        loginPage.wrongUserData.check(matches(isDisplayed()));
    }

    private void enterText(ViewInteraction field, String text) {
        field.perform(click());
        field.perform(replaceText(text));
    }
}
