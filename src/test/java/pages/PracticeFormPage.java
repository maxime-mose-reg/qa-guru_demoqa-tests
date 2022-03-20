package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactOwnText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    // components
    private final CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");

    // actions
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(byTagAndText("h5", "Student Registration Form")).should(appear);
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage checkFormParam(String label, String value) {
        $(byTagAndText("td", label)).sibling(0).shouldHave(exactOwnText(value));
        return this;
    }
}
