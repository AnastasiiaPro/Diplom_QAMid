package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.FormatTestData.TODAY;
import static ru.iteco.fmhandroid.testdata.News.TODAY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.TOMORROW_NEWS;
import static ru.iteco.fmhandroid.testdata.User.REGISTERED_USER;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.tests.FirstTest;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Раздел «Новости»")
public class NewsPageTest extends FirstTest {
    @Before
        public void beforeEach() {
        loginPageSteps.login(REGISTERED_USER);
        mainPageSteps.checkPageIsLoaded();
        mainPageSteps.goToNews();
        newsPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void logoutTest() {
        mainPageSteps.logOut();
    }

    @Test
    @DisplayName("Переход в раздел «Главная» через меню навигации")
    public void goToMainFromMenuTest() {
        newsPageSteps.goToMainFromMenu();
        mainPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Переход в раздел «О приложении» через меню навигации")
    public void goToAboutFromMenuTest() {
        newsPageSteps.goToAboutFromMenu();
        aboutTheApplicationPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Переход на страницу «Цитаты»")
    public void goToQuotesPageTest() {
        newsPageSteps.goToQuotes();
        quotesPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Раздел «Новости» - Развернуть и свернуть новость на сегодняшний день")
    public void newsTodayExpandedOnNewsPageTest() {
        newsPageSteps.goToControlPanel();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToCreateNews();
        createAndEditNewsPageSteps.checkCreatePageIsLoaded();
        createAndEditNewsPageSteps.fillNewsFields(TODAY_NEWS);
        createAndEditNewsPageSteps.clickSaveButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToNewsFromMenu();
        newsPageSteps.checkPageIsLoaded();
        newsPageSteps.expandNewsItem(TODAY_NEWS);
        newsPageSteps.checkExpandedNewsItemIsDisplayed(TODAY_NEWS);
        newsPageSteps.collapseNewsItem(TODAY_NEWS);
        newsPageSteps.checkCollapsedNewsItemIsDisplayed(TODAY_NEWS);
        newsPageSteps.goToControlPanel();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TODAY, TODAY);
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.clickDeleteNewsButton(TODAY_NEWS);
        controlPanelPageSteps.checkExpandedNewsItemIsNotExists(TODAY_NEWS);
    }

    @Test
    @DisplayName("Раздел «Новости» - Отсутствие новости на завтрашний день")
    public void isNotNewsTomorrowOnNewsPageTest() {
        newsPageSteps.goToControlPanel();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToCreateNews();
        createAndEditNewsPageSteps.checkCreatePageIsLoaded();
        createAndEditNewsPageSteps.fillNewsFields(TOMORROW_NEWS);
        createAndEditNewsPageSteps.clickSaveButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToNewsFromMenu();
        newsPageSteps.checkPageIsLoaded();
        newsPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
        newsPageSteps.goToControlPanel();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.clickDeleteNewsButton(TOMORROW_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
    }
}
