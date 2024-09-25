package selenium.zadanie_seven.registrFormPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.zadanie_seven.registrFormPage.components.CalendarDemoQA;
import selenium.zadanie_seven.registrFormPage.components.ModalRegistrationFormSubmit;

public class RegistrationFormPage extends BasePage{

    CalendarDemoQA calendarDemoQA = new CalendarDemoQA(driver);
    ModalRegistrationFormSubmit modalRegistrationFormSubmit = new ModalRegistrationFormSubmit(driver);

    private final By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private final By emailInput = By.xpath("//input[@placeholder='name@example.com']");
    private final String genderLabel = "//label[text()='%s']";
    private final By mobPhoneInput = By.xpath("//input[@placeholder='Mobile Number']");
    private final By subjectsInput = By.xpath("//input[@id='subjectsInput']");
    private final By subjectOptional = By.xpath("//div[contains(@class,'subjects-auto-complete__option')]");
    private final String hobbiesLabel = "//label[text()='%s']";
    private final String stateSelect = "//div[text()='%s']";
    private final String citySelect = "//div[text()='%s']";
    private final By pictureInput = By.xpath("//input[@type='file']");
    private final By addressTextArea = By.xpath("//textarea[@placeholder='Current Address']");
    private final By stateOptional = By.xpath("//div[text()='Select State']");
    private final By cityOptional = By.xpath("//div[text()='Select City']");
    private final By submitBtn = By.xpath("//button[@id='submit']");


    public RegistrationFormPage(WebDriver driver){
        super(driver);
    }


    public RegistrationFormPage setFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
        return  this;
    }

    public RegistrationFormPage setEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public RegistrationFormPage setGender(String gender){
       driver.findElement(By.xpath(String.format(genderLabel, gender))).click();
       return this;
    }

    public RegistrationFormPage setMobilePhone(String mobilePhone){
        driver.findElement(mobPhoneInput).sendKeys(mobilePhone);
        return this;
    }

    public RegistrationFormPage setSubject(String subject){
        driver.findElement(subjectsInput).sendKeys(subject);
        driver.findElement(subjectOptional).click();
        return this;
    }

    public RegistrationFormPage setHobbies(String hobby){
        driver.findElement(By.xpath(String.format(hobbiesLabel, hobby))).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String fileName){
        driver.findElement(pictureInput).sendKeys(System.getProperty("user.dir") + "/src/test/resources/" + fileName);
        return this;
    }

    public RegistrationFormPage setAddress(String address){
        driver.findElement(addressTextArea).sendKeys(address);
        return this;
    }

    public RegistrationFormPage setState(String state){
        driver.findElement(stateOptional).click();
        driver.findElement(By.xpath(String.format(stateSelect, state))).click();
        return this;
    }

    public RegistrationFormPage setCity(String city){
        driver.findElement(cityOptional).click();
        driver.findElement(By.xpath(String.format(citySelect, city))).click();
        return this;
    }

    public RegistrationFormPage submitClick(){
        driver.findElement(submitBtn).click();
        return this;
    }

    public RegistrationFormPage setDayOfBirth(String year, String month, String day){
        calendarDemoQA.setDayOnCalendar(year, month, day);
        return this;
    }

    public RegistrationFormPage assertTableResult(String key, String actualValue){
        modalRegistrationFormSubmit.assertTable(key,actualValue);
        return this;
    }

    public RegistrationFormPage assertTitleModal(String actualTitle){
        modalRegistrationFormSubmit.assertTitleModal(actualTitle);
        return this;
    }

    public RegistrationFormPage closeModalForm(){
        modalRegistrationFormSubmit.btnCloseClick();
        return this;
    }
}

