package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.FormatTestData.LAST_DAY;
import static ru.iteco.fmhandroid.testdata.FormatTestData.TODAY;
import static ru.iteco.fmhandroid.testdata.FormatTestData.TOMORROW;
import static ru.iteco.fmhandroid.testdata.News.EMPTY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.TODAY_NEWS;
import static ru.iteco.fmhandroid.testdata.News.TOMORROW_NEWS;
import static ru.iteco.fmhandroid.testdata.News.LAST_DAY_NEWS;
import static ru.iteco.fmhandroid.testdata.User.REGISTERED_USER;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.testdata.News;
import ru.iteco.fmhandroid.tests.FirstTest;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страницы «Создание и редактирование новостей»")
public class CreateAndEditNewsPageTest extends FirstTest {
    private static News currentNews;

    @Before
    public void loginAndGoToControlPanelPage() {
        loginPageSteps.login(REGISTERED_USER);
        mainPageSteps.checkPageIsLoaded();
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
