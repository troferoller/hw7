package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public SelenideElement yearSelect = $(".react-datepicker__year-select");
    public SelenideElement monthSelect = $(".react-datepicker__month-select");

    public void setDateOfBirth(String day, String month, String year) {
        yearSelect.selectOption(year);
        monthSelect.selectOption(month);
        $(".react-datepicker__day.react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
    }
}