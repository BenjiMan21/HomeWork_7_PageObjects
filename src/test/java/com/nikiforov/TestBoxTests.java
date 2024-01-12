package com.nikiforov;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TestBoxTests extends TestBase {

    TextBoxPage testBoxPage = new TextBoxPage();

    @Test
    void successfulTestBoxTest() {
        testBoxPage.openPage()
                .setFullName("Alex Denisov")
                .setEmail("unleash21@mail.ru")
                .setCurrentAddress("current address")
                .setPermanentAddress("permanent address")
                .pressSubmit();

        testBoxPage.checkTextBoxResult("Name","Alex Denisov")
                .checkTextBoxResult("Email","unleash21@mail.ru")
                .checkTextBoxResult("Current Address","current address")
                .checkTextBoxResult("Permananet Address","permananet address");
    }
}
