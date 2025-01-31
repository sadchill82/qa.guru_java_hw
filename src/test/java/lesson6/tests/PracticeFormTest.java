package lesson6.tests;

import lesson6.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanivanov@test.com")
                .chooseGender("Male")
                .setNumber("9023456789")
                .setDateOfBirth("17", "June", "1999")
                .setSubject("Chemistry")
                .setSubject("Arts")
                .chooseHobbies("Music")
                .uploadFile("picture.jpg")
                .setAddress("г. Москва, ул. Ленина, д. 10")
                .setState("Haryana")
                .setCity("Panipat")
                .submitRegistration()
                .modalWindowShouldExist()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivanivanov@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9023456789")
                .checkResult("Date of Birth", "17 June,1999")
                .checkResult("Subjects", "Chemistry, Arts")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "г. Москва, ул. Ленина, д. 10")
                .checkResult("State and City", "Haryana Panipat")
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void fillOnlyNecessaryFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .chooseGender("Male")
                .setNumber("9023456789")
                .setDateOfBirth("17", "June", "1999")
                .submitRegistration()
                .modalWindowShouldExist()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Date of Birth", "17 June,1999")
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void fillOnlyFirstNameFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Ivan")
                .submitRegistration()
                .modalWindowShouldNotExist();
    }


}
