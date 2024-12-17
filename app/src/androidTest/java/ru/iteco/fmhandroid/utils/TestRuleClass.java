package ru.iteco.fmhandroid.utils;

import static ru.iteco.fmhandroid.testdata.User.REGISTERED_USER;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import ru.iteco.fmhandroid.steps.AboutTheApplicationPageSteps;
import ru.iteco.fmhandroid.steps.ControlPanelPageSteps;
import ru.iteco.fmhandroid.steps.CreateAndEditNewsPageSteps;
import ru.iteco.fmhandroid.steps.FiltersPageSteps;
import ru.iteco.fmhandroid.steps.LoginPageSteps;
import ru.iteco.fmhandroid.steps.MainPageSteps;
import ru.iteco.fmhandroid.steps.NewsPageSteps;
import ru.iteco.fmhandroid.steps.QuotesPageSteps;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class TestRuleClass {

    protected static AboutTheApplicationPageSteps aboutTheApplicationPageSteps = new AboutTheApplicationPageSteps();
    protected static ControlPanelPageSteps controlPanelPageSteps = new ControlPanelPageSteps();
    protected static CreateAndEditNewsPageSteps createAndEditNewsPageSteps = new CreateAndEditNewsPageSteps();
    protected static FiltersPageSteps filtersPageSteps = new FiltersPageSteps();
    protected static LoginPageSteps loginPageSteps = new LoginPageSteps();
    protected static MainPageSteps mainPageSteps = new MainPageSteps();
    protected static NewsPageSteps newsPageSteps = new NewsPageSteps();
    protected static QuotesPageSteps quotesPageSteps = new QuotesPageSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        loginPageSteps.waitForAppToLoad();
        try {
            loginPageSteps.checkPageIsLoaded();
        } catch (Exception e) {
            mainPageSteps.logOut();
            loginPageSteps.checkPageIsLoaded();
            loginPageSteps.login(REGISTERED_USER);
            mainPageSteps.checkPageIsLoaded();
        }
    }
}
