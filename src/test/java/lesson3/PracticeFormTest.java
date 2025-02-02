package lesson3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanivanov@test.com");
        $(".custom-control-label").click(); // Male
        $("#userNumber").setValue("9023456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month").$(byText("17")).click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("picture1.jpg");
        $("#currentAddress").setValue("г. Москва, ул. Ленина, д. 10");
        $("#react-select-3-input").setValue("Haryana").pressEnter(); //State
        $("#react-select-4-input").setValue("Panipat").pressEnter(); //City
        $("#submit").click();

        $(".table").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
        $(".table").$(byText("Student Email")).parent().shouldHave(text("ivanivanov@test.com"));
        $(".table").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).parent().shouldHave(text("9023456789"));
        $(".table").$(byText("Date of Birth")).parent().shouldHave(text("17 June,1999"));
        $(".table").$(byText("Subjects")).parent().shouldHave(text("Chemistry, Arts"));
        $(".table").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table").$(byText("Picture")).parent().shouldHave(text("picture1.jpg"));
        $(".table").$(byText("Address")).parent().shouldHave(text("г. Москва, ул. Ленина, д. 10"));
        $(".table").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));
    }
}
