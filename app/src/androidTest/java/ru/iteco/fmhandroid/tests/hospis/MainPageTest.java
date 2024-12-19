package ru.iteco.fmhandroid.tests.hospis;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.tests.TestRuleClass;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Раздел «Главная»")
public class MainPageTest extends TestRuleClass {

    @Test
    @DisplayName("Переход на страницу «Цитаты»")
    public void goToQuotesTest() {
        mainPageSteps.goToQuotes();
        quotesPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void logoutTest() {
        mainPageSteps.logOut();
    }

    @Test
    @DisplayName("Переход в раздел «Новости» через кнопку «Все новости»")
    public void goToNewsFromMainScreenTest() {
        mainPageSteps.goToNews();
        newsPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Переход в раздел «Новости» через меню навигации")
    public void goToNewsFromMenuTest() {
        mainPageSteps.goToNewsFromMenu();
        newsPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Переход в раздел «О приложении» через меню навигации")
    public void goToAboutFromMenuTest() {
        mainPageSteps.goToAboutFromMenu();
        aboutTheApplicationPageSteps.checkPageIsLoaded();
    }
}
