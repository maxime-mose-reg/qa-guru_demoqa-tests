package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    @Test
    void cssXpathExamples() {
        // <input type="email" class="inputText login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]");
        $(by("data-testid", "email"));

        // <input type="email" class="inputText lxogin_form_input_box" name="email" id="email">
        $("#email");
        $(byId("email"));
        $("[id=email]");
        $(by("id", "email"));
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        // <input type="email" class="inputText login_form_input_box" name="email">
        $("[name=email]");
        $(byName("email"));
        $(by("name", "email"));

        // <input type="email" class="inputText login_form_input_box">
        $(".login_form_input_box.inputText");
        $(byClassName("login_form_input_box"));
        $("[class=login_form_input_box]");
        $(by("class", "login_form_input_box"));

        // <div class="login_form_input_box">
        //      <input type="email" class="inputText">
        // </div>
        $(".login_form_input_box .inputText");

        // <input type="email" class="inputText login_form_input_box" name="email" id="email" data-testid="email">
        $("input.login_form_input_box.inputText#email[name=email][data-testid=email]");

        // <div>Hello, qa.guru</div>
        $(byText("Hello, qa.guru"));
        $(withText("qa.guru"));
    }
}
