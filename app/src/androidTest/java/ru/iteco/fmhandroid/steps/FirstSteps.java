package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class FirstSteps {

    protected static final int DEFAULT_TIMEOUT = 2000;

    public void waitForAppToLoad() {
        Allure.step("Ожидание загрузки приложения");
        waitForElement(withId(R.id.splashscreen_image_view), DEFAULT_TIMEOUT);
    }
}
