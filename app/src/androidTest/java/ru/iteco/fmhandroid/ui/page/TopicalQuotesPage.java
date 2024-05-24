package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;


import static ru.iteco.fmhandroid.ui.utils.Utils.childAtPosition;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;


import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class TopicalQuotesPage {
    public ViewInteraction newsPage = onView(withText("News"));
    public ViewInteraction openQuotes = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction loveIsAllPage = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction openPageQuotes = onView(withId(R.id.our_mission_image_button));//onView(withId(R.id.our_mission_image_button));
    public static final int openQuoteButton = R.id.our_mission_item_open_card_image_button;
    public static final int descriptionQuoteField = R.id.our_mission_item_description_text_view;

    public static ViewInteraction constraintlayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));

    public static Matcher<View> getDescriptionText() {
        return ViewMatchers.withId(R.id.our_mission_item_description_text_view);
    }
}
