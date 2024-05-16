package pageObjectActions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class PageObjectActions {
    public String attributevalue = null;

    public PageObjectActions click(SelenideElement el, String elName) {
        el.click();
        return this;
    }

    public PageObjectActions open(String url) {
        Selenide.open(url);
        return this;
    }

    public PageObjectActions setValue(SelenideElement el, String value, String elementName) {
        el
                .setValue(value);
        return this;
    }

    public PageObjectActions sendKeys(SelenideElement el, Keys keys, String elementName) {
        el.sendKeys(keys);
        return this;
    }

    public PageObjectActions getAttribute(SelenideElement el, String attributeName, String elementName) {
        attributevalue = el.getAttribute(attributeName);
        return this;
    }
}
