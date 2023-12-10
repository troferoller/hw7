package tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import pages.data.La;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationObjectPage extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @ValueSource(strings = {"Selenide", "Junit5"})
    @ParameterizedTest(name = "Для поиского запроса {0} должен отдавать не пустой запрос")
    @DisplayName("Тест-кейс")
    @Tag("BLOCKER")
    public void checkTestCaseForWorkTest(String searchQuery){
        open("https://duckduckgo.com");
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @CsvSource(value = {"Selenide, Selenide is a framework for test automation powered by Selenium WebDriver that offers a concise fluent API, stable tests and powerful selectors",
            "Junit5, JUnit 5 is the current generation of the JUnit testing framework, which provides a modern foundation for developer-side testing on the JVM"})
    @ParameterizedTest(name = "Для поиского запроса {0} должен отдавать не пустой запрос")
    @DisplayName("Тест-кейс")
    public void searchYouTube(String searchFix, String searchText){
        Configuration.holdBrowserOpen = true;
        open("https://duckduckgo.com");
        $("#searchbox_input").setValue(searchFix).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']").shouldHave(text(searchText));
    }

    @EnumSource(La.class)
    @ParameterizedTest
    public void searchingDifferentExamplesOfText (La la){
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(la.name())).click();
        $("h3").shouldHave(text(la.description));
    }

    @Disabled("Отключено")
    @Test
    @DisplayName("Проверка на отключенность")
    void testWillBeIgnored() {
        open("https://duckduckgo.com");
    }


    @Test
    @DisplayName("Заполнение тестовых входных данных")
    @Tag("SMOKE")
    void checkFormRegistration(){
        registrationPage.openPage()
                .closeAd()
                .setFirstName("Valera")
                .setLastName("Berezka")
                .setEmail("tfsdfsdg@mail.com")
                .setGender("Male")
                .setUserNumber("3214235346")
                .setDateOfBirth("2001", "June", "27")
                .setSubjectsInput("English")
                .setHobbiesCheckbox("Sports")
                .loadPictureInput("1.jpg")
                .setCurrentAddress("zxvvzx asdadf")
                .setState("NCR")
                .setCity("Delhi")
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", "Valera Berezka")
                .resultCheck("Student Email", "tfsdfsdg@mail.com")
                .resultCheck("Gender", "Male")
                .resultCheck("Mobile", "3214235346")
                .resultCheck("Date of Birth", "27 June,2001")
                .resultCheck("Subjects", "English")
                .resultCheck("Hobbies", "Sports")
                .resultCheck("Picture", "1.jpg")
                .resultCheck("Address", "zxvvzx asdadf")
                .resultCheck("State and City", "NCR Delhi");

    }
    @Test
    @DisplayName("Проверка выполнения формы")
    @Tag("WEB")
    void checkFormRegistrationRequiredFields(){
        registrationPage.openPage()
                .closeAd()
                .setFirstName("Max")
                .setLastName("Korj")
                .setGender("Female")
                .setUserNumber("3214235346")
                .setSubjectsInput("English")
                .setHobbiesCheckbox("Sports")
                .setCurrentAddress("zxvvzx asdadf")
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", "Max Korj")
                .resultCheck("Gender", "Female")
                .resultCheck("Mobile", "3214235346")
                .resultCheck("Subjects", "English")
                .resultCheck("Hobbies", "Sports")
                .resultCheck("Address", "zxvvzx asdadf");
    }
    @Test
    @Disabled("JDK-12345124")
    @DisplayName("Негативная проверка")
    @Tag("SMOKE")
    void checkFormRegistrationEmptyFields() {
        registrationPage.openPage()
                .closeAd()
                .setClickButton()
                .tableHidden();
    }
}