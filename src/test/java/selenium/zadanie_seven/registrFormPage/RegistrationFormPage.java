package selenium.zadanie_seven.registrFormPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationFormPage {

    private WebDriver driver;

    private final By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private final By emailInput = By.xpath("//input[@placeholder='name@example.com']");
    private final String genderLabel = "//label[text()='%s']";
    private final By mobPhoneInput = By.xpath("//input[@placeholder='Mobile Number']");


    public RegistrationFormPage(WebDriver driver){
        this.driver = driver;
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
}
