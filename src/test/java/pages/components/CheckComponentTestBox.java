package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponentTestBox {
    public void checkResults(String key, String value) {
        $("#output").shouldHave(text(key)).shouldHave(text(value));
    }
}
