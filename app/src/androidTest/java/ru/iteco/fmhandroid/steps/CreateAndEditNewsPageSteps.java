package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;

import ru.iteco.fmhandroid.pages.CreateAndEditNewsPage;
import ru.iteco.fmhandroid.testdata.News;


public class CreateAndEditNewsPageSteps {

    private final CreateAndEditNewsPage createAndEditNewsPage = new CreateAndEditNewsPage();

    public void checkPageIsLoaded() {
        createAndEditNewsPage.newsTitle.check(matches(isDisplayed()));
        createAndEditNewsPage.categoryField.check(matches(isDisplayed()));
        createAndEditNewsPage.titleField.check(matches(isDisplayed()));
        createAndEditNewsPage.publicationDateField.check(matches(isDisplayed()));
        createAndEditNewsPage.timeField.check(matches(isDisplayed()));
        createAndEditNewsPage.descriptionField.check(matches(isDisplayed()));
        createAndEditNewsPage.switcher.check(matches(isDisplayed()));
        createAndEditNewsPage.saveButton.check(matches(isDisplayed()));
        createAndEditNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public void checkCreatePageIsLoaded() {
        Allure.step("Отображение страницы «Создание новости»");
        checkPageIsLoaded();
        createAndEditNewsPage.creatingTitle.check(matches(isDisplayed()));
    }

    public void checkEditPageIsLoaded() {
        Allure.step("Отображение страницы «Редактирование новости»");
        checkPageIsLoaded();
        createAndEditNewsPage.editingTitle.check(matches(isDisplayed()));
    }

    public void fillNewsFields(News news) {
        fillNewsFields(news.getCategory(), news.getTitle(), news.getPublicationDate(), news.getTime(), news.getDescription());
    }

    public void fillNewsFields(String category, String title, String publicationDate, String time, String description) {
        Allure.step("Заполнение полей формы создания/редактирования новости");
        createAndEditNewsPage.categoryField.perform(replaceText(category));
        createAndEditNewsPage.titleField.perform(replaceText(title));
        createAndEditNewsPage.publicationDateField.perform(replaceText(publicationDate));
        createAndEditNewsPage.timeField.perform(replaceText(time));
        createAndEditNewsPage.descriptionField.perform(replaceText(description));
    }

    public void clickSaveButton() {
        Allure.step("Сохранить изменения");
        createAndEditNewsPage.saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Отменить изменения");
        createAndEditNewsPage.cancelButton.perform(click());
        createAndEditNewsPage.okButton.check(matches(isDisplayed()));
        createAndEditNewsPage.okButton.perform(click());
    }

//    public void clickCancelButtonOk() {
//        Allure.step("Отменить прекращение изменения");
//        createAndEditNewsPage.cancelButton.perform(click());
//        createAndEditNewsPage.cancelButton.check(matches(isDisplayed()));
//        createAndEditNewsPage.cancelButton.perform(click());
//    }

    public void clickSwitcher() {
        Allure.step("Переключение тумблера активации новости");
        createAndEditNewsPage.switcher.perform(click());
    }

    public void checkEmptyFieldsIsDisplayed() {
        Allure.step("Отображение уведомления «Заполните пустые поля»");
        createAndEditNewsPage.emptyFields.check(matches(isDisplayed()));
    }
}
