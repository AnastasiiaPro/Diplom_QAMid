package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage extends NavigationBar {

    public ViewInteraction titleQuotes = onView((withId(R.id.our_mission_title_text_view)));
    public ViewInteraction listOfItems = onView(withId(R.id.our_mission_item_list_recycler_view));

    public ViewInteraction getCollapsedQuotesItem(String title) {
        return onView(allOf(
                withId(R.id.our_mission_item_material_card_view),
                withChild(withChild(allOf(
                        withId(R.id.our_mission_item_title_text_view),
                        withText(title))))));
    }

    public ViewInteraction getExpandedQuotesItem(String title, String description) {
        return onView(allOf(
                withId(R.id.our_mission_item_material_card_view),
                withChild(allOf(
                        withChild(allOf(
                                withId(R.id.our_mission_item_title_text_view),
                                withText(title))),
                        withChild(allOf(
                                withId(R.id.our_mission_item_description_text_view),
                                withText(description)))))));
    }

    public ViewInteraction getQuotesItemDescription(String description) {
        return onView(allOf(
                withId(R.id.our_mission_item_description_text_view),
                withText(description)));
    }
}