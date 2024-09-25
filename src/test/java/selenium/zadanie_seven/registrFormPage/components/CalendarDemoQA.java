package selenium.zadanie_seven.registrFormPage.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.zadanie_seven.registrFormPage.BasePage;

public class CalendarDemoQA extends BasePage{


    private final By dateOfBirthInput = By.xpath("//input[@id='dateOfBirthInput']");
    private final By yearSelect = By.xpath("//select[@class='react-datepicker__year-select']");
    private final By monthSelect = By.xpath("//select[@class='react-datepicker__month-select']");

    private final String yearOptionLocator= "//option[@value='%s']";
    private final String  monthOptionLocator= "//option[text()='%s']";
    private final String  dayOptionLocator = "//div[@class='react-datepicker__day react-datepicker__day--%s']";

    public CalendarDemoQA(WebDriver driver){

        super(driver);
    }

    public void setDayOnCalendar(String year, String month, String day){
        driver.findElement(dateOfBirthInput).click();
        driver.findElement(yearSelect).click();
        driver.findElement(By.xpath(String.format(yearOptionLocator, year))).click();
        driver.findElement(monthSelect).click();
        waitVisibilityOfElement(By.xpath(String.format(monthOptionLocator, month)));
        driver.findElement(By.xpath(String.format(monthOptionLocator, month))).click();
        waitVisibilityOfElement(By.xpath(String.format(dayOptionLocator, day)));
        driver.findElement(By.xpath(String.format(dayOptionLocator, day))).click();
    }
}
