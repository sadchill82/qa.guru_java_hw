package lesson6.pages;

import com.codeborne.selenide.SelenideElement;
import lesson6.pages.components.CalendarComponent;
import lesson6.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dayOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateList = $("#state"),
            stateFieldSetValue = $("#react-select-3-input"),
            cityList = $("#city"),
            cityFieldSetValue = $("#react-select-4-input"),
            submitButton = $("#submit"),
            closeRegistrationConfirmationWindow = $("#closeLargeModal"),
            modalWindow = $(".modal-title.h4");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanners() {
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

    public RegistrationPage chooseGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dayOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage chooseHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadFile(String filePath) {
        uploadPicture.uploadFromClasspath(filePath);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateList.click();
        stateFieldSetValue.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityList.click();
        cityFieldSetValue.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage submitRegistration() {
        submitButton.click();

        return this;
    }

    public RegistrationPage closeModalWindow() {
        closeRegistrationConfirmationWindow.click();

        return this;
    }

    public RegistrationPage modalWindowShouldExist() {
        modalWindow.should(exist);

        return this;
    }

    public RegistrationPage modalWindowShouldNotExist() {
        modalWindow.shouldNot(exist);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
}
