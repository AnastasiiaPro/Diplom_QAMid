package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.pages.MainPage;

public class MainPageSteps extends NavigationBarSteps {

    private final MainPage mainPage = new MainPage();

    public void checkPageIsLoaded() {
        Allure.step("Отображение раздела «Главная»");
        super.checkPageIsLoaded();
        mainPage.titleNews.check(matches(isDisplayed()));
        mainPage.allNewsButton.check(matches(isDisplayed()));
        mainPage.newsList.check(matches(isDisplayed()));
    }

    public void goToNews() {
        Allure.step("Переход в раздел «Новости» по кнопке «Все новости»");
        mainPage.allNewsButton.perform(click());
    }
}
