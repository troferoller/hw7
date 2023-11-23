package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageFakerTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();
    @Test
    void checkFormRegistration(){
        registrationPage.openPage()
                .closeAd()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.year, data.month, data.day)
                .setSubjectsInput(data.subject)
                .setHobbiesCheckbox(data.hobbies)
                .loadPictureInput(data.pictureName)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", data.firstName + " " + data.lastName)
                .resultCheck("Student Email", data.userEmail)
                .resultCheck("Gender", data.gender)
                .resultCheck("Mobile", data.userNumber)
                .resultCheck("Date of Birth",data.year)
                .resultCheck("Date of Birth", data.month)
                .resultCheck("Date of Birth", data.day)
                .resultCheck("Subjects", data.subject)
                .resultCheck("Hobbies", data.hobbies)
                .resultCheck("Picture", data.pictureName)
                .resultCheck("Address", data.address)
                .resultCheck("State and City", data.city)
                .resultCheck("State and City", data.state);
    }
}