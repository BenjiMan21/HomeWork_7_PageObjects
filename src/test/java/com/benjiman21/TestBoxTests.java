package com.benjiman21;

import org.junit.jupiter.api.Test;
import pages.TextBoxPageObjects;

public class TestBoxTests extends TestBase {

    TextBoxPageObjects testBoxPage = new TextBoxPageObjects();

    @Test
    void successfulTestBoxTest() {
        testBoxPage.openPage()
                .setFullName("Alex Denisov")
                .setEmail("unleash21@mail.ru")
                .setCurrentAddress("current address")
                .setPermanentAddress("permanent address")
                .pressSubmit();

        testBoxPage.checkResults("Name","Alex Denisov")
                .checkResults("Email","unleash21@mail.ru")
                .checkResults("Current Address","current address")
                .checkResults("Permananet Address","permananet address");
    }
}
