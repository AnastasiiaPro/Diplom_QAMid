package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.Quote.QUOTE;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.utils.TestRuleClass;

@Feature(value = "Раздел «Цитаты»")
public class QuotesPageTest extends TestRuleClass {
    @Before
    public void beforeEach() {
        mainPageSteps.goToQuotes();
        quotesPageSteps.checkPageIsLoaded();
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void logoutTest() {
        mainPageSteps.logOut();
    }

    @Test
    @DisplayName("Переход в раздел «Главная» через меню навигации")
    public void goToMainFromMenuTest() {
        mainPageSteps.goToMainFromMenu();
        mainPageSteps.checkPageIsLoaded();
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

    @Test
    @DisplayName("Развернуть и свернуть цитату")
    public void expandAndCollapseQuoteTest() {
        quotesPageSteps.expandQuote(QUOTE);
        quotesPageSteps.checkExpandedQuote(QUOTE);
        quotesPageSteps.collapseQuote(QUOTE);
        quotesPageSteps.checkQuoteDescriptionIsNotDisplayed(QUOTE);
    }
}
