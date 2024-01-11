package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CheckComponentTestBox;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPageObjects {
    private SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInpit = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");


    CheckComponentTestBox checkComponent = new CheckComponentTestBox();

    public TextBoxPageObjects openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPageObjects setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPageObjects setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPageObjects setCurrentAddress(String value) {
        currentAddressInpit.setValue(value);
        return this;
    }

    public TextBoxPageObjects setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPageObjects pressSubmit() {
        submitButton.click();
        return this;
    }

    public TextBoxPageObjects checkResults(String key, String value) {
        checkComponent.checkResults(key, value);
        return this;
    }
}
