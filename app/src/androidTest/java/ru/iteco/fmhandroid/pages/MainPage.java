package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage extends NavigationBar {

    public ViewInteraction titleNews = onView(withText(R.string.news));
    public ViewInteraction newsList = onView(withId(R.id.news_list_recycler_view));
    public ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));

//    public ViewInteraction getCollapsedNewsItem(String title, String date) {
//        return onView(allOf(
//                withId(R.id.news_item_material_card_view),
//                withChild(allOf(
//                        withChild(allOf(
//                                withId(R.id.news_item_title_text_view),
//                                withText(title))),
//                        withChild(allOf(
//                                withId(R.id.news_item_date_text_view),
//                                withText(date)))))));
//    }
//
//    public ViewInteraction getExpandedNewsItem(String title, String date, String description) {
//        return onView(allOf(
//                withId(R.id.news_item_material_card_view),
//                withChild(allOf(
//                        withChild(allOf(
//                                withId(R.id.news_item_title_text_view),
//                                withText(title))),
//                        withChild(allOf(
//                                withId(R.id.news_item_description_text_view),
//                                withText(description))),
//                        withChild(allOf(
//                                withId(R.id.news_item_date_text_view),
//                                withText(date)))))));
//    }
}