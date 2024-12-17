package ru.iteco.fmhandroid.tests;

import org.junit.Test;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.utils.TestRuleClass;

@Feature(value = "Раздел «О приложении»")
public class AboutTheApplicationPageTest extends TestRuleClass {

    @Test
    @DisplayName("Переход из раздела «О приложении» через кнопку «назад»")
    public void goBackFromAboutPageTest() {
//        loginPageSteps.login(REGISTERED_USER);
//        mainPageSteps.checkPageIsLoaded();
        mainPageSteps.goToAboutFromMenu();
        aboutTheApplicationPageSteps.checkPageIsLoaded();
        aboutTheApplicationPageSteps.clickBackButton();
        mainPageSteps.checkPageIsLoaded();
    }
}
