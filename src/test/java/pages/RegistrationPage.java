package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckoutComponent;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObjects {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userPhoneNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelector = $("#hobbiesWrapper"),
            imageUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            choseState = $("#state"),
            choseCity = $("#city"),
            submitButton = $("#submit"),
            checkWindow = $(".modal-content");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckoutComponent checkoutComponent = new CheckoutComponent();


    public PageObjects openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PageObjects setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PageObjects setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PageObjects setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PageObjects setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public PageObjects setPhoneNumber(String value) {
        userPhoneNumberInput.setValue(value);
        return this;
    }

    public PageObjects setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PageObjects setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PageObjects choseHobbies (String value) {
        hobbiesSelector.$(byText(value)).click();
        return this;
    }

    public PageObjects loadImage (String value) {
        imageUpload.uploadFromClasspath(value);
        return this;
    }

    public PageObjects setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public PageObjects choseState (String value) {
        choseState.click();
        choseState.$(byText(value)).click();
        return this;
    }

    public PageObjects choseCity (String value) {
        choseCity.click();
        choseCity.$(byText(value)).click();
        return this;
    }

    public PageObjects pressSubmit() {
        submitButton.click();
        return this;
    }

    public PageObjects checkResult (String key, String value) {
        checkoutComponent.checkResult(key, value);
        return this;
    }

    public PageObjects checkoutWindow () {
        checkWindow.shouldBe(visible);
        return this;

    }

}
