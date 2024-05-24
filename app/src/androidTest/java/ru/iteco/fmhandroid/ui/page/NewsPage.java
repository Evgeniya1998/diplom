package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsPage {

    public ViewInteraction allNewsHeadLine = onView(withId(R.id.all_news_text_view));
    public ViewInteraction  menuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction  materialButton = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction  createdNews = onView(withId(R.id.add_news_image_view));
    public ViewInteraction  choseCategoryy = onView(withId(R.id.text_input_end_icon));
    public ViewInteraction choseCategory = onView(withText("Category"));
    public ViewInteraction newsPage = onView(withText("News"));
    public ViewInteraction createCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction createTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction choseDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction buttonOk = onView(withText("OK"));
    public ViewInteraction controlPanel = onView(withText("Control panel"));
    public ViewInteraction category =  onView(withText("День рождения"));
    public ViewInteraction choseTime = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction description = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction canselButton = onView(withId(R.id.cancel_button));
    public ViewInteraction openNews = onView(withId(R.id.view_news_item_image_view));
    public ViewInteraction titleNews = onView(withId(R.id.news_item_title_text_view));
    public ViewInteraction deleteNews = onView(withId(R.id.delete_news_item_image_view));
    public ViewInteraction editNews = onView(Matchers.allOf(withId(R.id.edit_news_item_image_view),
            withParent(withParent(Matchers.allOf(withId(R.id.news_item_material_card_view))))));
    public ViewInteraction buttonActive = onView(withId(R.id.switcher));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filterPage = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction filterButton = onView(withId(R.id.filter_button));

    public ViewInteraction deleteNewsButton(String title) {
        return onView(Matchers.allOf(withId(R.id.delete_news_item_image_view),
                withParent(withParent(Matchers.allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));
    }

    public ViewInteraction editNewsButton(String title) {
        return onView(Matchers.allOf(withId(R.id.edit_news_item_image_view),
                withParent(withParent(Matchers.allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));
    }




//
//
//
//
//
//
//    public ViewInteraction titlePage;
//    public ViewInteraction categoryText;
//    public ViewInteraction titleText;
//    public ViewInteraction descriptionText;
//    public ViewInteraction publicationDate;
//    public ViewInteraction time;
//    public ViewInteraction switcher;
//    public ViewInteraction saveButton;
//    public ViewInteraction cancelButton;
//
//    public ViewInteraction errorMessage;
//
//    public ViewInteraction okButtonMessage;
//    public ViewInteraction cancelButtonMessage;
//
//    public EditNewsPage() {
//        titlePage = onView(withId(R.id.custom_app_bar_title_text_view));
//        categoryText =
//                onView(withId(R.id.news_item_category_text_auto_complete_text_view));
//        titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
//        descriptionText =
//                onView(withId(R.id.news_item_description_text_input_edit_text));
//
//        publicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
//        time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
//        switcher = onView(withId(R.id.switcher));
//        saveButton = onView(withId(R.id.save_button));
//        cancelButton = onView(withId(R.id.cancel_button));
//        errorMessage = onView(withId(R.id.message));
//        okButtonMessage = onView(withText("OK"));
//        cancelButtonMessage = onView(withText("Отмена"));
//
//}
}