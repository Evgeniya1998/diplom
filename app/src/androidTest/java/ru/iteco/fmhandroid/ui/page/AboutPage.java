package ru.iteco.fmhandroid.ui.page;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    public static final int PRIVACYPOLICYLINK = R.id.about_privacy_policy_value_text_view;
    public static final int TERMSOFUSELINK = R.id.about_terms_of_use_value_text_view;
    public static final ViewInteraction PRIVACYPOLICY = onView(withText("Privacy Policy:"));
    public static final ViewInteraction TERMSOFUSETEXT = onView(withText("Terms of use:"));

}