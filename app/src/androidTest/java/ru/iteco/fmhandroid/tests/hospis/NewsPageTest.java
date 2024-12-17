package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.FormatTestData.LAST_DAY;
import static ru.iteco.fmhandroid.testdata.FormatTestData.TODAY;
import static ru.iteco.fmhandroid.testdata.FormatTestData.TOMORROW;
import static ru.iteco.fmhandroid.testdata.News.EMPTY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.LAST_DAY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.TODAY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.TOMORROW_NEWS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.testdata.News;
import ru.iteco.fmhandroid.utils.TestRuleClass;

@Feature(value = "Раздел «Новости»")
public class NewsPageTest extends TestRuleClass {
    @Before
        public void beforeEach() {
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
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TOMORROW, TOMORROW);
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.clickDeleteNewsButton(TOMORROW_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
    }

    @Feature(value = "Страницы «Создание и редактирование новостей»")
    public static class CreateAndEditNewsPageTest extends TestRuleClass {
        private static News currentNews;

        @Before
        public void loginAndGoToControlPanelPage() {
    //        loginPageSteps.login(REGISTERED_USER);
    //        mainPageSteps.checkPageIsLoaded();
            mainPageSteps.goToNews();
            newsPageSteps.checkPageIsLoaded();
            newsPageSteps.goToControlPanel();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.goToCreateNews();
            createAndEditNewsPageSteps.checkCreatePageIsLoaded();
        }

        @After
        public void deleteCreatedNews() {
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.clickDeleteNewsButton(currentNews);
            controlPanelPageSteps.checkExpandedNewsItemIsNotExists(currentNews);
        }

        @Test
        @DisplayName("Страница «Панель управления» - Развернуть и свернуть новость, созданную на «сегодня»")
        public void createdTodayNewsExpandedOnControlPanelPageTest() {
            currentNews = TODAY_NEWS;

            createAndEditNewsPageSteps.fillNewsFields(currentNews);
            createAndEditNewsPageSteps.clickSaveButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.goToFilters();
            filtersPageSteps.checkNewsFilterPageIsLoaded();
            filtersPageSteps.fillDateFields(TODAY, TODAY);
            filtersPageSteps.clickFilterButton();
            controlPanelPageSteps.expandNewsItem(currentNews);
            controlPanelPageSteps.checkExpandedNewsItemIsDisplayed(currentNews);
            controlPanelPageSteps.collapseNewsItem(currentNews);
            controlPanelPageSteps.checkCollapsedNewsItemIsDisplayed(currentNews);
        }
        @Test
        @DisplayName("Страница «Панель управления» - Создание новости с заполненными полями на «завтра»")
        public void createNewsOnControlPanelPageTest() {
            currentNews = TOMORROW_NEWS;

            createAndEditNewsPageSteps.fillNewsFields(currentNews);
            createAndEditNewsPageSteps.clickSaveButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.goToFilters();
            filtersPageSteps.checkNewsFilterPageIsLoaded();
            filtersPageSteps.fillDateFields(TOMORROW, TOMORROW);
            filtersPageSteps.clickFilterButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.expandNewsItem(currentNews);
            controlPanelPageSteps.checkExpandedNewsItemIsDisplayed(currentNews);
            controlPanelPageSteps.checkNewsIsActive(currentNews);
        }

        @Test
        @DisplayName("Страница «Панель управления» - Редактирование новости с заполненными полями")
        public void editNewsOnControlPanelPageTest() {
            currentNews = LAST_DAY_NEWS;

            createAndEditNewsPageSteps.fillNewsFields(TODAY_NEWS);
            createAndEditNewsPageSteps.clickSaveButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.goToFilters();
            filtersPageSteps.checkNewsFilterPageIsLoaded();
            filtersPageSteps.fillDateFields(TODAY, TODAY);
            filtersPageSteps.clickFilterButton();
            controlPanelPageSteps.clickEditNewsButton(TODAY_NEWS);
            createAndEditNewsPageSteps.checkEditPageIsLoaded();
            createAndEditNewsPageSteps.fillNewsFields(currentNews);
            createAndEditNewsPageSteps.clickSwitcher();
            createAndEditNewsPageSteps.clickSaveButton();
            controlPanelPageSteps.goToFilters();
            filtersPageSteps.checkNewsFilterPageIsLoaded();
            filtersPageSteps.fillDateFields(LAST_DAY, LAST_DAY);
            filtersPageSteps.clickFilterButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TODAY_NEWS);
            controlPanelPageSteps.expandNewsItem(currentNews);
            controlPanelPageSteps.checkExpandedNewsItemIsDisplayed(currentNews);
            controlPanelPageSteps.checkNewsIsNotActive(currentNews);
        }

        @Test
        @DisplayName("Страница «Панель управления» - Отмена редактированиея новости")
        public void yndEditNewsOnControlPanelPageTest() {
            currentNews = TODAY_NEWS;

            createAndEditNewsPageSteps.fillNewsFields(currentNews);
            createAndEditNewsPageSteps.clickSaveButton();
            controlPanelPageSteps.goToFilters();
            filtersPageSteps.checkNewsFilterPageIsLoaded();
            filtersPageSteps.fillDateFields(TODAY, TODAY);
            filtersPageSteps.clickFilterButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.clickEditNewsButton(currentNews);
            createAndEditNewsPageSteps.checkEditPageIsLoaded();
            createAndEditNewsPageSteps.fillNewsFields(EMPTY_NEWS);
            createAndEditNewsPageSteps.clickSaveButton();
            createAndEditNewsPageSteps.checkEmptyFieldsIsDisplayed();
            createAndEditNewsPageSteps.clickCancelButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.checkCollapsedNewsItemIsDisplayed(currentNews);
        }

        @Test
        @DisplayName("Страница «Панель управления» - Отмена удаления новости")
        public void undoDeleteNewsButtonOnControlPanelPageTest() {
            currentNews = TODAY_NEWS;

            createAndEditNewsPageSteps.fillNewsFields(currentNews);
            createAndEditNewsPageSteps.clickSaveButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.goToFilters();
            filtersPageSteps.checkNewsFilterPageIsLoaded();
            filtersPageSteps.fillDateFields(TODAY, TODAY);
            filtersPageSteps.clickFilterButton();
            controlPanelPageSteps.checkPageIsLoaded();
            controlPanelPageSteps.clickUndoDeleteNewsButton(currentNews);
            controlPanelPageSteps.checkCollapsedNewsItemIsDisplayed(currentNews);
        }
    }
}
