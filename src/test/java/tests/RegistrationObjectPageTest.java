package tests;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationObjectPageTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void checkFormRegistration(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .closeAd()
                .setFirstName("Valera")
                .setLastName("Berezka")
                .setEmail("tfsdfsdg@mail.com")
                .setGender("Male")
                .setUserNumber("3214235346")
                .setDateOfBirth("27", "June", "2001")
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
    void checkFormRegistrationRequiredFields(){
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    void checkFormRegistrationEmptyFields() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .closeAd()
                .setClickButton()
                .tableHidden();
    }
}