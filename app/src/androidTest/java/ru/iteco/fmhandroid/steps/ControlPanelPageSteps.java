package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.pages.ControlPanelPage;
import ru.iteco.fmhandroid.testdata.News;

public class ControlPanelPageSteps extends NavigationBarSteps {

    private final ControlPanelPage controlPanelPage = new ControlPanelPage();

    public void checkPageIsLoaded() {
        Allure.step("Наличие отображения раздела «Панель управления»");
        super.checkPageIsLoaded();
        waitForElement(withText(R.string.news_control_panel), DEFAULT_TIMEOUT);
        controlPanelPage.titleControlPanel.check(matches(isDisplayed()));
        controlPanelPage.sortButton.check(matches(isDisplayed()));
        controlPanelPage.filterButton.check(matches(isDisplayed()));
        controlPanelPage.addButton.check(matches(isDisplayed()));
        controlPanelPage.listOfNews.check(matches(isDisplayed()));
    }

//    public void sortDescending() {
//        Allure.step("Сортирование от новой к поздней");
//        controlPanelPage.sortButton.perform(click());
//        controlPanelPage.sortButton.perform(click());
//    }
//
//    public void sortAscending() {
//        Allure.step("Сортирование от поздней к новой");
//        controlPanelPage.sortButton.perform(click());
//    }

    public void checkCollapsedNewsItemIsDisplayed(News news) {
        checkCollapsedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate(), news.getAuthor());
    }

    public void checkCollapsedNewsItemIsDisplayed(String title, String publicationDate, String author) {
        Allure.step("Наличие свернутой новости");
        controlPanelPage.getCollapsedNewsItem(title, publicationDate, author).check(matches(isDisplayed()));
    }

    public void checkCollapsedNewsItemIsNotExists(News news) {
        checkCollapsedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate(), news.getAuthor());
    }

    public void checkCollapsedNewsItemIsNotExists(String title, String publicationDate, String author) {
        Allure.step("Отсутствие свернутой новости");
        controlPanelPage.getCollapsedNewsItem(title, publicationDate, author).check(doesNotExist());
    }

    public void collapseNewsItem(News news) {
        collapseNewsItem(news.getTitle(), news.getPublicationDate(), news.getAuthor(), news.getDescription());
    }

    public void collapseNewsItem(String title, String publicationDate, String author, String description) {
        Allure.step("Свернуть новость");
        checkExpandedNewsItemIsDisplayed(title, publicationDate, author, description);
        controlPanelPage.getExpandedNewsItem(title, publicationDate, author, description).perform(click());
    }

    public void expandNewsItem(News news) {
        expandNewsItem(news.getTitle(), news.getPublicationDate(), news.getAuthor());
    }

    public void expandNewsItem(String title, String publicationDate, String author) {
        Allure.step("Развернуть новость");
        checkCollapsedNewsItemIsDisplayed(title, publicationDate, author);
        controlPanelPage.getCollapsedNewsItem(title, publicationDate, author).perform(click());
    }

    public void checkExpandedNewsItemIsDisplayed(News news) {
        checkExpandedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate(),  news.getAuthor(), news.getDescription());
    }

    public void checkExpandedNewsItemIsDisplayed(String title, String publicationDate, String author, String description) {
        Allure.step("Наличие развернутой новости");
        controlPanelPage.getExpandedNewsItem(title, publicationDate, author, description).check(matches(isDisplayed()));
    }

    public void checkExpandedNewsItemIsNotExists(News news) {
        checkExpandedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate(), news.getAuthor(), news.getDescription());
    }

    public void checkExpandedNewsItemIsNotExists(String title, String publicationDate, String author, String description) {
        Allure.step("Отсутствие развернутой новости");
        controlPanelPage.getExpandedNewsItem(title, publicationDate, author, description).check(doesNotExist());
    }

    public void goToFilters() {
        Allure.step("Переход на страницу «Фильтрование новости»");
        controlPanelPage.filterButton.perform(click());
    }

    public void goToCreateNews() {
        Allure.step("Переход на страницу «Создание новости»");
        controlPanelPage.addButton.perform(click());
    }

    public void clickDeleteNewsButton(News news) {
        clickDeleteNewsButton(news.getTitle());
    }

    public void clickDeleteNewsButton(String title) {
        Allure.step("Удаление новости");
        controlPanelPage.getNewsDeleteButton(title).check(matches(isDisplayed()));
        controlPanelPage.getNewsDeleteButton(title).perform(click());
        controlPanelPage.okButton.perform(click());
    }

    public void clickUndoDeleteNewsButton(News news) {
        clickUndoDeleteNewsButton(news.getTitle());
    }

    public void clickUndoDeleteNewsButton(String title) {
        Allure.step("Отмена удаления новости");
        controlPanelPage.getNewsDeleteButton(title).check(matches(isDisplayed()));
        controlPanelPage.getNewsDeleteButton(title).perform(click());
        controlPanelPage.cancelButton.perform(click());
    }

    public void clickEditNewsButton(News news) {
        clickEditNewsButton(news.getTitle());
    }

    public void clickEditNewsButton(String title) {
        Allure.step("Переход на страницу «Редактирование новости»");
        controlPanelPage.getNewsEditButton(title).check(matches(isDisplayed()));
        controlPanelPage.getNewsEditButton(title).perform(click());
    }

    public void checkNewsIsActive(News news) {
        checkNewsIsActive(news.getTitle());
    }

    public void checkNewsIsActive(String title) {
        Allure.step("Наличие статуса новости «Активна»");
        controlPanelPage.getNewsStatus(title).check(matches(isDisplayed()));
        controlPanelPage.getNewsStatus(title).check(matches(withText(R.string.news_control_panel_active)));
    }

    public void checkNewsIsNotActive(News news) {
        checkNewsIsNotActive(news.getTitle());
    }

    public void checkNewsIsNotActive(String title) {
        Allure.step("Наличие статуса новости «Неактивна»");
        controlPanelPage.getNewsStatus(title).check(matches(isDisplayed()));
        controlPanelPage.getNewsStatus(title).check(matches(withText(R.string.news_control_panel_not_active)));
    }
}
