package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactOwnText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    String firstName = "Ivan";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName("Ivanov");

        $("#userEmail").setValue("ivanov@company.org");
        $("#genterWrapper").$(byTagAndText("label", "Other")).click();
        $("#userNumber").setValue("9157770707");

        practiceFormPage.setDateOfBirth("1", "January", "2000");

        $("#hobbiesWrapper").$(byTagAndText("label", "Sports")).click();
        $("#subjectsInput").setValue("M");
        $("#subjectsContainer").$(byText("Maths")).click();
        $("#uploadPicture").uploadFromClasspath("img/image.png");
        $("#currentAddress").setValue("Some address");

        $("#state").click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaiselmer")).click();

        $("#submit").click();
        $(byText("Thanks for submitting the form")).should(appear);

        practiceFormPage
                .checkFormParam("Student Name", firstName + " Ivanov")
                .checkFormParam("Student Email", "ivanov@company.org")
                .checkFormParam("Gender", "Other");

        $(byTagAndText("td", "Student Email")).sibling(0).shouldHave(exactOwnText("ivanov@company.org"));
        $(byTagAndText("td", "Gender")).sibling(0).shouldHave(exactOwnText("Other"));
        $(byTagAndText("td", "Mobile")).sibling(0).shouldHave(exactOwnText("9157770707"));
        $(byTagAndText("td", "Date of Birth")).sibling(0).shouldHave(exactOwnText("01 January,2000"));
        $(byTagAndText("td", "Subjects")).sibling(0).shouldHave(exactOwnText("Maths"));
        $(byTagAndText("td", "Hobbies")).sibling(0).shouldHave(exactOwnText("Sports"));
        $(byTagAndText("td", "Picture")).sibling(0).shouldHave(exactOwnText("image.png"));
        $(byTagAndText("td", "Address")).sibling(0).shouldHave(exactOwnText("Some address"));
        $(byTagAndText("td", "State and City")).sibling(0).shouldHave(exactOwnText("Rajasthan Jaiselmer"));
    }
}
