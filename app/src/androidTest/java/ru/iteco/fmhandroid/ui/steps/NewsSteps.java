package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

import static ru.iteco.fmhandroid.ui.page.TopicalQuotesPage.getDescriptionText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsSteps {

    NewsPage news = new NewsPage();

    public void clickEditNews(String newsTitle) {
        Allure.step("Нажать кнопку 'редактировать новость'");
        news.editNewsButton(newsTitle).perform(click());
    }

    public void doActiveNews() {
        Allure.step("Кликаем на свитчер (активная или неактивная новость)");
        news.buttonActive.perform(click());
    }

    public void checkIfNewsWithTitle(String titleText) {
        Allure.step("Проверка наличия новости с указанным заголовком");
        onView(allOf(withText(titleText), isDisplayed())).check(matches(isDisplayed()));
    }
    public void openNews(String titleText) {
        Allure.step("Проверка наличия новости с указанным заголовком");
        onView(allOf(withText(titleText), isDisplayed())).check(matches(isDisplayed())).perform(click());
    }

    public void clickDeleteNews(String newsTitle) {
        Allure.step("Удалить новость с указанным заголовком");
        news.deleteNewsButton(newsTitle).perform(click());
        Allure.step("Подтвердить удаление новости с указанным заголовком");
        news.buttonOk.perform(click());
    }

    public void randomDescriptionNews() {
        Allure.step("Кликаем на вкладку 'description'");
       // news.createCategory.perform(click());
        news.description.perform(click());
        Allure.step("Вставляем в поле 'description' текст с рандомным числом");
        String newsDescription = Utils.getRandomNewsDescription();
        news.description.perform(replaceText(newsDescription), closeSoftKeyboard());
    }
    public void goToTabCreatingNews() {
        Allure.step("Переходим во вкладку 'creating news'");
        news.createdNews.perform(click());
    }
    public void goToTabControlPanel () {
        Allure.step("Переход во вкладку 'Control panel'");
        news.materialButton.perform(click());
    }

    public void enterTittle(String title) {
        Allure.step("Ввод заголовка");
        news.createTitle.perform(replaceText(title));
    }

    public void checkPageControlPanek() {
        Allure.step("Проверить страницу 'Control panel'");
        news.controlPanel.check(matches(isDisplayed()));
    }

    public void checkPageNews() {
        Allure.step("Проверить страницу 'News'");
        news.newsPage.check(matches(isDisplayed()));
    }
    public void checkDeleteNews(String title) {
        Allure.step("Проверка, что новости с указанным заголовком нет");
        onView(allOf(withText(title))).check(doesNotExist());//onView(allOf(withText(title))).check(matches(not(isDisplayed())));//onView(allOf(withText(title))).check(doesNotExist());//.check(matches(isDisplayed()));
    }

    public void checkEditNews(String title) {
        Allure.step("Проверка, что новость с указанным заголовком отредактирована");
        onView(allOf(withText(title))).check(matches(isDisplayed()));//, isDisplayed())).check(matches(isDisplayed()));//).check(matches(isDisplayed()));
    }

    public void filterNews() {
        Allure.step("Кликнуть на фильтр для новостей");
        news.filterPage.perform(click());
    }

    public void choseCategory(String category) {
        Allure.step("Выбрать категорию");
        news.createCategory.perform(replaceText(category));
    }

    public void pushCategory() {
        Allure.step("Нажать на поле 'category'");
        news.createCategory.perform(click());
    }
    public void saveFilter() {
        Allure.step("Сохранить фильтрацию");
        news.filterButton.perform(click());
    }

    public void checkNews(String title) {
        Allure.step("Проверить созданную новость");
        onView(allOf(withText(title), isDisplayed()));//.check(matches(isDisplayed()));
    }

    public void checkIfNoNewsWithTitle(String title) {
        Allure.step("Проверка, что новости с указанным заголовком нет");
        onView(allOf(withText(title), isDisplayed())).check(doesNotExist());
    }

    public static void checkToastErrorMessage(String messageError) {
        Allure.step("Появление всплывающего сообщения об ошибке Неверные данные");
        onView(allOf(withContentDescription(messageError), isDisplayed()));
    }
    public void goToTabNews () {
        Allure.step("Переход во вкладку 'News'");
        news.allNewsHeadLine.perform(click());
    }

    public void randomTitleNews() {
        Allure.step("Кликаем на 'title'");
        news.createTitle.perform(click());
        Allure.step("Вставляем в поле 'Title' текст");
        String categoryRandom = Utils.randomCategory();
        news.createTitle.perform(replaceText(categoryRandom));
    }

    public void randomCategoryNews() {
        Allure.step("Кликаем на 'category'");
        news.createCategory.perform(click());
        Allure.step("Вставляем в поле 'Category' текст");
        String categoryRandom = Utils.randomCategory();
        news.createCategory.perform(replaceText(categoryRandom));
    }

    public void publicationDate() {
        Allure.step("Вставляем текущую дату");
        news.choseDate.perform(click());
        //Allure.step("Кликаем на кнопку ок");
        news.buttonOk.perform(click());
    }

    public void publicationTime() {
        Allure.step("Вставляем текущее время");
        news.choseTime.perform(click());
        //Allure.step("Кликаем на кнопку ок");
        news.buttonOk.perform(click());
    }
    public void saveNews() {
        Allure.step("Сохраняем новость");
        news.saveButton.perform(click());
    }

    public void cancelNews() {
        Allure.step("Отменяем новость");
        news.canselButton.perform(click());
        news.buttonOk.perform(click());
    }

    public void checkingCreateNewsPage() {
        Allure.step("Проверить, что это oкно Создания новости");
        news.createCategory.check(matches(isDisplayed()));
    }

    public void openNews() {
        Allure.step("Открываем последнюю новость");
        news.openNews.perform(click());
    }

    public void sortNews() {
        Allure.step("Нажать кнопку Сортировка");
        news.sort.perform(click());
    }
    public void checkNewsPage() {
        Allure.step("Проверить, что это oкно новостей");
        news.newsPage.check(matches(isDisplayed()));
    }
}