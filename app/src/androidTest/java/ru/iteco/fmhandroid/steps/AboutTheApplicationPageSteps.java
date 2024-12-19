package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.pages.AboutTheApplicationPage;

public class AboutTheApplicationPageSteps  {

    private final AboutTheApplicationPage aboutTheApplicationPage = new AboutTheApplicationPage();

    public void checkPageIsLoaded() {
        Allure.step("Отображение раздела «О приложении»");
        aboutTheApplicationPage.backButton.check(matches(isDisplayed()));
        aboutTheApplicationPage.logo.check(matches(isDisplayed()));
        aboutTheApplicationPage.version.check(matches(isDisplayed()));
        aboutTheApplicationPage.privacyPolicyLink.check(matches(isDisplayed()));
        aboutTheApplicationPage.privacyPolicyTitle.check(matches(isDisplayed()));
        aboutTheApplicationPage.termsOfUseLink.check(matches(isDisplayed()));
        aboutTheApplicationPage.termsOfUseTitle.check(matches(isDisplayed()));
        aboutTheApplicationPage.companyInfo.check(matches(isDisplayed()));
    }

    public void clickBackButton() {
        Allure.step("Активация кнопки «Назад»");
        aboutTheApplicationPage.backButton.perform(click());
    }
//    public void clickPrivacyPolicyTitle() {
//        Allure.step("Переход на ссылку «Политика конфидициальности»");
//        aboutTheApplicationPage.privacyPolicyTitle.perform(click());
//
//    }
//
//    public void clickTermsOfUseTitle() {
//        Allure.step("Переход на ссылку «Пользовательское соглашение»");
//        aboutTheApplicationPage.privacyPolicyTitle.perform(click());
//    }
}
