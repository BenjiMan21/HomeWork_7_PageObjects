package com.nikiforov;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Nikiforov")
                .setEmail("unleash21@mail.ru")
                .setGender("Male")
                .setPhoneNumber("8999777665")
                .setDateOfBirth("20", "May", "1989")
                .setSubject("English").setSubject("Maths")
                .choseHobbies("Sports").choseHobbies("Reading")
                .loadImage("image.jpg")
                .setAddress("Lorem ipsum dolor")
                .choseState("NCR")
                .choseCity("Delhi")
                .pressSubmit();

        registrationPage.checkRegistrationResult("Student Name", "Alex Nikiforov")
                .checkRegistrationResult("Student Email", "unleash21@mail.ru")
                .checkRegistrationResult("Gender","Male")
                .checkRegistrationResult("Mobile","8999777665")
                .checkRegistrationResult("Date of Birth","20 May,1989")
                .checkRegistrationResult("Subjects","English, Maths")
                .checkRegistrationResult("Hobbies","Sports, Reading")
                .checkRegistrationResult("Picture","image.jpg")
                .checkRegistrationResult("Address","Lorem ipsum dolor")
                .checkRegistrationResult("State and City","NCR Delhi");
    }

    @Test
    void minimumValuesRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Nikiforov")
                .setGender("Male")
                .setPhoneNumber("8999777665")
                .pressSubmit();

        registrationPage.checkRegistrationResult("Student Name", "Alex Nikiforov")
                .checkRegistrationResult("Gender","Male")
                .checkRegistrationResult("Mobile","8999777665");
    }

    @Test
    void unsuccessfulRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Nikiforov")
                .setGender("Male")
                .setPhoneNumber("")
                .pressSubmit();

        registrationPage.checkoutWindow();
    }
}