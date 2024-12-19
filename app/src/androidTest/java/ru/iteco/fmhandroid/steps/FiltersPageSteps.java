package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.pages.FiltersPage;

public class FiltersPageSteps {

    private final FiltersPage filtersPage = new FiltersPage();

    private void checkPageIsLoaded() {
        filtersPage.titleFilter.check(matches(isDisplayed()));
        filtersPage.categoryField.check(matches(isDisplayed()));
        filtersPage.startDateField.check(matches(isDisplayed()));
        filtersPage.endDateField.check(matches(isDisplayed()));
        filtersPage.filterButton.check(matches(isDisplayed()));
        filtersPage.cancelButton.check(matches(isDisplayed()));
    }

    public void checkNewsFilterPageIsLoaded() {
        Allure.step("Отображение страницы «Фильтровать новости» в разделе «Новости»");
        checkPageIsLoaded();
    }

    public void fillCategoryFields(String category) {
        Allure.step("Заполнение поля «Категория»");
        filtersPage.categoryField.perform(replaceText(category));
    }

    public void fillDateFields(String startDate, String endDate) {
        Allure.step("Заполнение полей с датами");
        filtersPage.startDateField.perform(replaceText(startDate));
        filtersPage.endDateField.perform(replaceText(endDate));
    }

    public void clickFilterButton() {
        Allure.step("Нажать кнопку «Фильтровать»");
        filtersPage.filterButton.perform(click());
    }

    public void clickActiveCheckbox() {
        Allure.step("Нажать на чекбокс «Активный»");
        filtersPage.checkBoxActive.perform(click());
    }

    public void clickNotActiveCheckbox() {
        Allure.step("Нажать на чекбокс «Неактивный»");
        filtersPage.checkBoxNotActive.perform(click());
    }
}
