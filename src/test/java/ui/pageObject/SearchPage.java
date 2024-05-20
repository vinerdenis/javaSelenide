package ui.pageObject;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    public final ElementsCollection searchTitles = $$x("//h2//a");
}
