package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.FormatTestData.TODAY;
import static ru.iteco.fmhandroid.testdata.FormatTestData.TOMORROW;
import static ru.iteco.fmhandroid.testdata.News.TODAY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.TOMORROW_NEWS;
import static ru.iteco.fmhandroid.testdata.User.REGISTERED_USER;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;

import ru.iteco.fmhandroid.tests.FirstTest;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница «Фильтрация новостей»")
public class FiltersPageTest extends FirstTest {

    @Before
    public void loginAndCreateNews() {
        loginPageSteps.login(REGISTERED_USER);
        mainPageSteps.checkPageIsLoaded();
        mainPageSteps.goToNews();
        newsPageSteps.checkPageIsLoaded();
        newsPageSteps.goToControlPanel();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToCreateNews();
        createAndEditNewsPageSteps.checkCreatePageIsLoaded();
        createAndEditNewsPageSteps.fillNewsFields(TODAY_NEWS);
        createAndEditNewsPageSteps.clickSaveButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToCreateNews();
        createAndEditNewsPageSteps.checkCreatePageIsLoaded();
        createAndEditNewsPageSteps.fillNewsFields(TOMORROW_NEWS);
        createAndEditNewsPageSteps.clickSaveButton();
        controlPanelPageSteps.checkPageIsLoaded();
    }

    @After
    public void deleteCreatedNews() {
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TODAY, TOMORROW);
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.clickDeleteNewsButton(TODAY_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TODAY_NEWS);
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.clickDeleteNewsButton(TOMORROW_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
    }

    @Test
    @DisplayName("Разлел «Новости» - фильтрация по дате, новости - сегодня")
    public void filterTodayNewsByDateOnNewsPageTest() {
        controlPanelPageSteps.goToNewsFromMenu();
        newsPageSteps.checkPageIsLoaded();
        newsPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TODAY, TODAY);
        filtersPageSteps.clickFilterButton();
        newsPageSteps.checkPageIsLoaded();
        newsPageSteps.checkCollapsedNewsItemIsDisplayed(TODAY_NEWS);
        newsPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
        newsPageSteps.goToControlPanel();
    }

    @Test
    @DisplayName("Страница «Панель управления» - фильтрация по дате, новости - завтра")
    public void filterTomorrowNewsByDateOnControlPanelPageTest() {
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TOMORROW, TOMORROW);
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.checkCollapsedNewsItemIsDisplayed(TOMORROW_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TODAY_NEWS);
    }

//    @Test
//    @DisplayName("Страница «Панель управления» - фильтрация по дате, отсутствующих в последний день календаря")
//    public void filterIsNotNewsByDateOnControlPanelPageTest() {
//        controlPanelPageSteps.goToFilters();
//        filtersPageSteps.checkNewsFilterPageIsLoaded();
//        filtersPageSteps.fillDateFields(LAST_DAY, LAST_DAY);
//        filtersPageSteps.clickFilterButton();
//        controlPanelPageSteps.checkPageIsLoaded();
//        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TODAY_NEWS);
//        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
//    }

    @Test
    @DisplayName("Страница «Панель управления» - фильтрация по параметру «Активный»")
    public void filterNewsByActiveOnControlPanelPageTest() {
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TODAY, TOMORROW);
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.clickEditNewsButton(TODAY_NEWS);
        createAndEditNewsPageSteps.checkEditPageIsLoaded();
        createAndEditNewsPageSteps.clickSwitcher();
        createAndEditNewsPageSteps.clickSaveButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.clickNotActiveCheckbox();
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.checkNewsIsActive(TOMORROW_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TODAY_NEWS);
    }

    @Test
    @DisplayName("Страница «Панель управления» - фильтрация по параметру «Неактивный»")
    public void filterNewsByNotActiveOnControlPanelPageTest() {
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.fillDateFields(TODAY, TOMORROW);
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.clickEditNewsButton(TODAY_NEWS);
        createAndEditNewsPageSteps.checkEditPageIsLoaded();
        createAndEditNewsPageSteps.clickSwitcher();
        createAndEditNewsPageSteps.clickSaveButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.goToFilters();
        filtersPageSteps.checkNewsFilterPageIsLoaded();
        filtersPageSteps.clickActiveCheckbox();
        filtersPageSteps.clickFilterButton();
        controlPanelPageSteps.checkPageIsLoaded();
        controlPanelPageSteps.checkNewsIsNotActive(TODAY_NEWS);
        controlPanelPageSteps.checkCollapsedNewsItemIsNotExists(TOMORROW_NEWS);
    }
}
