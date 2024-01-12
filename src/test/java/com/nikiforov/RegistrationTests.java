package com.benjiman21;

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

        registrationPage.checkResult("Student Name", "Alex Nikiforov")
                .checkResult("Student Email", "unleash21@mail.ru")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8999777665")
                .checkResult("Date of Birth","20 May,1989")
                .checkResult("Subjects","English, Maths")
                .checkResult("Hobbies","Sports, Reading")
                .checkResult("Picture","image.jpg")
                .checkResult("Address","Lorem ipsum dolor")
                .checkResult("State and City","NCR Delhi");
    }

    @Test
    void minimumValuesRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Nikiforov")
                .setGender("Male")
                .setPhoneNumber("8999777665")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Alex Nikiforov")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8999777665");
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