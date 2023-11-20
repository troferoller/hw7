package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationObjectPage extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void checkFormRegistration(){
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
        registrationPage.openPage()
                .closeAd()
                .setClickButton()
                .tableHidden();
    }
}