package ui.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главна страниа сайта appleinsider.ru
 */
public class MainPage {
    public final SelenideElement searchButton = $x("//form");
    public final SelenideElement searchInput = $x("//input[@name='s']");

}
