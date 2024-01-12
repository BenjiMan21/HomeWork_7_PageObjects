package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

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
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userPhoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage choseHobbies (String value) {
        hobbiesSelector.$(byText(value)).click();
        return this;
    }

    public RegistrationPage loadImage (String value) {
        imageUpload.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage choseState (String value) {
        choseState.click();
        choseState.$(byText(value)).click();
        return this;
    }

    public RegistrationPage choseCity (String value) {
        choseCity.click();
        choseCity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkRegistrationResult (String key, String value) {
        resultTableComponent.checkRegistrationResult(key, value);
        return this;
    }

    public RegistrationPage checkoutWindow () {
        checkWindow.shouldBe(visible);
        return this;

    }

}
