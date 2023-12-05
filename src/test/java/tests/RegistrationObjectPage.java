package tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationObjectPage extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
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