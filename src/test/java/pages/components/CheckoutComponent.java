package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutComponent {
    public void checkResult(String key, String value) {
        $(".modal-body").shouldHave(text(key)).shouldHave(text(value));
    }
}
