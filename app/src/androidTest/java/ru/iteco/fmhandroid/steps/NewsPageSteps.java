package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.pages.NewsPage;
import ru.iteco.fmhandroid.testdata.News;

public class NewsPageSteps extends NavigationBarSteps {

    private final NewsPage newsPage = new NewsPage();

    public void checkPageIsLoaded() {
        Allure.step("Отображение раздела «Новости»");
        super.checkPageIsLoaded();
        waitForElement(withText(R.string.news), DEFAULT_TIMEOUT);
//        newsPage.titleNews.check(matches(isDisplayed()));
        newsPage.filterButton.check(matches(isDisplayed()));
        newsPage.sortButton.check(matches(isDisplayed()));
        newsPage.editButton.check(matches(isDisplayed()));
//        newsPage.listOfNews.check(matches(isDisplayed()));
    }

    public void checkCollapsedNewsItemIsDisplayed(News news) {
        checkCollapsedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate());
    }

    public void checkCollapsedNewsItemIsDisplayed(String title, String date) {
        Allure.step("Наличие свернутой новости");
        newsPage.getCollapsedNewsItem(title, date).check(matches(isDisplayed()));
    }

    public void checkCollapsedNewsItemIsNotExists(News news) {
        checkCollapsedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate());
    }

    public void checkCollapsedNewsItemIsNotExists(String title, String date) {
        Allure.step("Отсутствие свернутой новости");
        newsPage.getCollapsedNewsItem(title, date).check(doesNotExist());
    }

    public void expandNewsItem(News news) {
        expandNewsItem(news.getTitle(), news.getPublicationDate());
    }

    public void expandNewsItem(String title, String date) {
        Allure.step("Развернуть новость");
        checkCollapsedNewsItemIsDisplayed(title, date);
        newsPage.getCollapsedNewsItem(title, date).perform(click());
    }

    public void checkExpandedNewsItemIsDisplayed(News news) {
        checkExpandedNewsItemIsDisplayed(news.getTitle(), news.getDescription(), news.getPublicationDate());
    }

    public void checkExpandedNewsItemIsDisplayed(String title, String description, String date) {
        Allure.step("Наличие развернутой новости");
        newsPage.getExpandedNewsItem(title, description, date).check(matches(isDisplayed()));
    }

    public void collapseNewsItem(News news) {
        collapseNewsItem(news.getTitle(), news.getDescription(), news.getPublicationDate());
    }

    public void collapseNewsItem(String title,  String description, String date) {
        Allure.step("Свернуть новость");
        checkExpandedNewsItemIsDisplayed(title, description, date);
        newsPage.getExpandedNewsItem(title, description, date).perform(click());
    }

    public void checkExpandedNewsItemIsNotExists(News news) {
        checkExpandedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate(), news.getDescription());
    }

    public void checkExpandedNewsItemIsNotExists(String title, String date, String description) {
        Allure.step("Отсутствие развернутой новости");
        newsPage.getExpandedNewsItem(title, date, description).check(doesNotExist());
    }

    public void goToFilters() {
        Allure.step("Переход на страницу «Фильтры»");
        newsPage.filterButton.perform(click());
    }

    public void goToControlPanel() {
        Allure.step("Переход на страницу «Панель управления»");
        newsPage.editButton.perform(click());
    }
}
