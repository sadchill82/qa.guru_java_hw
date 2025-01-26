package lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void headerSearchTest() {
        open("");
        $("nav.HeaderMenu-nav").$(byText("Solutions")).hover();
        $("div.border-bottom.pb-3.pb-lg-0.border-lg-bottom-0.pb-lg-3").$("[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\ndeveloper platform"));
    }
}
