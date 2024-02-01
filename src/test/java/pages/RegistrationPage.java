package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            loadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            buttonSubmit = $("#submit"),
            checkTable = $(".table-responsive"),
            setInput = $("#search-form #search");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent formResult = new ResultComponent();

    public RegistrationPage searchInput(String searchVid){
        setInput.setValue(searchVid).pressEnter();
        return this;
    }
    public RegistrationPage closeAd() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDateOfBirth(day, month, year);
        return this;
    }
    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbiesCheckbox(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage loadPictureInput(String classpath) {
        loadPicture.uploadFromClasspath(classpath);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.val(value).pressEnter();
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.val(value).pressEnter();
        return this;
    }
    public RegistrationPage resultCheck(String key, String value) {
        formResult.resultCheck(key, value);
        return this;
    }
    public RegistrationPage setClickButton() {
        buttonSubmit.click();
        return this;
    }
    public RegistrationPage tableVisible() {
        checkTable.shouldBe(visible);
        return this;
    }
    public void tableHidden() {
        checkTable.shouldBe(hidden);

    }
    public RegistrationPage closeCoocke(){
        SelenideElement bannerRoot = $(".fc-consent-root");
        if (bannerRoot.isDisplayed()) {
            bannerRoot.$(byText("Consent")).click();
        }
        return this;
    }

}