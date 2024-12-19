package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;

import ru.iteco.fmhandroid.pages.QuotesPage;
import ru.iteco.fmhandroid.testdata.Quote;

public class QuotesPageSteps extends NavigationBarSteps {

    private final QuotesPage quotesPage = new QuotesPage();

    public void checkPageIsLoaded() {
        Allure.step("Отображение страницы «Цитаты»");
        super.checkPageIsLoaded();
        quotesPage.titleQuotes.check(matches(isDisplayed()));
        quotesPage.listOfItems.check(matches(isDisplayed()));
    }

    public void expandQuote(Quote quote) {
        expandQuote(quote.getTitle());
    }

    public void expandQuote(String title) {
        Allure.step("Развернуть цитату");
        quotesPage.getCollapsedQuotesItem(title).check(matches(isDisplayed()));
        quotesPage.getCollapsedQuotesItem(title).perform(click());
    }

    public void checkExpandedQuote(Quote quote) {
        checkExpandedQuote(quote.getTitle(), quote.getDescription());
    }

    public void checkExpandedQuote(String title, String description) {
        Allure.step("Наличие развёрнутой цитаты");
        quotesPage.getExpandedQuotesItem(title, description).check(matches(isDisplayed()));
    }

    public void collapseQuote(Quote quote) {
        collapseQuote(quote.getTitle(), quote.getDescription());
    }

    public void collapseQuote(String title, String description) {
        Allure.step("Свернуть цитату");
        quotesPage.getExpandedQuotesItem(title, description).perform(click());
    }
    public void checkQuoteDescriptionIsNotDisplayed(Quote quote) {
        checkQuoteDescriptionIsNotDisplayed(quote.getDescription());
    }

    public void checkQuoteDescriptionIsNotDisplayed(String description) {
        Allure.step("Наличие свёрнутой цитаты");
        quotesPage.getQuotesItemDescription(description).check(matches(not(isDisplayed())));
    }
   }
