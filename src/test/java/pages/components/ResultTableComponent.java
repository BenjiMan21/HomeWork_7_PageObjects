package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public void checkRegistrationResult(String key, String value) {
        $(".modal-body").shouldHave(text(key)).shouldHave(text(value));
    }

    public void checkTextBoxResult(String key, String value) {
        $("#output").shouldHave(text(key)).shouldHave(text(value));
    }
}
