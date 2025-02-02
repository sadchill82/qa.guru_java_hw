package lesson7.tests;

import lesson7.pages.RegistrationPage;
import lesson7.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {

    RandomUtils testData = new RandomUtils();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .chooseGender(testData.gender)
                .setNumber(testData.number)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .chooseHobbies(testData.hobbies)
                .uploadFile(testData.picture)
                .setAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitRegistration()
                .modalWindowShouldExist()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city)
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void fillOnlyNecessaryFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .chooseGender(testData.gender)
                .setNumber(testData.number)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .submitRegistration()
                .modalWindowShouldExist()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void fillOnlyFirstNameFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .submitRegistration()
                .modalWindowShouldNotExist();
    }


}
