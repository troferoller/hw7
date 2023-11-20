package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private final SelenideElement CHECK_RESULT = $(".table-responsive");
    public void resultCheck(String key, String value){
        CHECK_RESULT.$(byText(key)).parent().shouldHave(text(value));
    }
}