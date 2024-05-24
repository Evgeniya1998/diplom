package ru.iteco.fmhandroid.ui.page;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

public class AuthorizationPage {
    public ViewInteraction login = onView(allOf(withHint(R.string.login), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction password = onView(allOf(withHint(R.string.password), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction openPageAuthirization = onView(allOf(withText(R.string.authorization), withParent(withParent(withId(R.id.nav_host_fragment)))));
    public ViewInteraction InscriptionAuth = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logOut = onView((withText(R.string.log_out)));
    public ViewInteraction authorizationPage = onView(allOf(withText(R.string.authorization)));
    public ViewInteraction signIn = onView(allOf(withId(R.id.enter_button)));
    public ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction aboutPage = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction about = onView(withText(R.string.about));

}