package ui.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import ui.tests.pageObject.MainPage;
import ui.tests.pageObject.SearchPage;
import ui.tests.pageObject.PageObjectActions;

public class AppleTest extends BaseTest {
    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем iPhone 12 отличается от iPhone 13";

    @Test
    public void checkHref() {
        MainPage mainPage = new MainPage();
        PageObjectActions pageObjectActions = new PageObjectActions();

        pageObjectActions
                .open(BASE_URL)
                .setValue(mainPage.searchInput, SEARCH_STRING, "Поиск")
                .sendKeys(mainPage.searchInput, Keys.ENTER, "Поиск");

        SearchPage searchPage = new SearchPage();

        pageObjectActions
                .getAttribute(searchPage.searchTitles.first(),"href","Поисковая строка");

        Assert.assertTrue(pageObjectActions.attributevalue.contains("iphone-13"));
        System.out.println();

    }


}
