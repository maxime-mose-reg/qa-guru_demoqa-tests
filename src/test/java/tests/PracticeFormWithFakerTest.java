package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithFakerTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));

    private final String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = new Faker().internet().emailAddress();

    @Test
    void successTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("img/image.png");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1231231230"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("30 July,2008"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
