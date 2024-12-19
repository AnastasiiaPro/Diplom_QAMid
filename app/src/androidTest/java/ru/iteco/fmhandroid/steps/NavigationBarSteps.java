package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;

import ru.iteco.fmhandroid.pages.NavigationBar;


public class NavigationBarSteps {

    private final NavigationBar navigationBar = new NavigationBar();

    public void checkPageIsLoaded() {
        Allure.step("Отображение элементов панели навигации");
        navigationBar.menuButton.check(matches(isDisplayed()));
        navigationBar.logo.check(matches(isDisplayed()));
        navigationBar.ourMissionButton.check(matches(isDisplayed()));
        navigationBar.logoutButton.check(matches(isDisplayed()));
    }

    public void logOut() {
        Allure.step("Выйти из учетной записи");
        navigationBar.logoutButton.perform(click());
        navigationBar.logoutMenuItem.check(matches(isDisplayed()));
        navigationBar.logoutMenuItem.perform(click());
    }

    public void goToQuotes() {
        Allure.step("Переход на страницу «Цитаты»");
        navigationBar.ourMissionButton.perform(click());
    }

    public void clickMenuButton() {
        Allure.step("Открытие «Меню»");
        navigationBar.menuButton.check(matches(isClickable()));
        navigationBar.menuButton.perform(click());
        navigationBar.mainMenuItem.check(matches(isDisplayed()));
        navigationBar.newsMenuItem.check(matches(isDisplayed()));
        navigationBar.aboutMenuItem.check(matches(isDisplayed()));
    }

    public void goToMainFromMenu() {
        Allure.step("Переход в раздел «Главная» из «Меню»");
        clickMenuButton();
        navigationBar.mainMenuItem.perform(click());
    }

    public void goToNewsFromMenu() {
        Allure.step("Переход в раздел «Новости» из «Меню»");
        clickMenuButton();
        navigationBar.newsMenuItem.perform(click());
    }

    public void goToAboutFromMenu() {
        Allure.step("Переход в раздел «О приложении» из «Меню»");
        clickMenuButton();
        navigationBar.aboutMenuItem.perform(click());
    }
}
