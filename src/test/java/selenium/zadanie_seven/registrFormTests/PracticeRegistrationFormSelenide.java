package selenium.zadanie_seven.registrFormTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.zadanie_seven.registrFormPage.RegistrationFormPage;

import java.time.Duration;

public class PracticeRegistrationFormSelenide extends BaseTest{



  @Test
  public void positiveRegistrationForm(){



    String firstName = "Alex";
    String lastName = "Coruzo";
    String email = "coruzo@gmail.com";
    String mobPhone = "9056587887";
    String subject = "Biology";
    String address = "Bruklin 89";
    String gender = "Male";
    String hobby = "Sports";
    String fileName = "Penguins.jpg";
    String stateName = "NCR";
    String cityName = "Delhi";
    String year = "1999";
    String month = "8";
    String day = "029";
    String titleModalText = "Thanks for submitting the form";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
    registrationFormPage.setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setMobilePhone(mobPhone)
            .setGender(gender);

    //WebElement firstNameInput = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    //WebElement lastNameInput = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    //WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
    //WebElement genderInput = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
    //WebElement mobPhoneInput = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
    //firstNameInput.sendKeys(firstName);
    //lastNameInput.sendKeys(lastName);
    //emailInput.sendKeys(email);
    //genderInput.click();
    //mobPhoneInput.sendKeys(mobPhone);

    WebElement dateOfBirthInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
    dateOfBirthInput.click();
    WebElement yearSelect = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    yearSelect.click();
    WebElement optionYear = driver.findElement(By.xpath("//option[@value='1999']"));
    optionYear.click();
    WebElement monthSelect = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    monthSelect.click();
    WebElement optionMonth = driver.findElement(By.xpath("//option[@value='8']"));
    optionMonth.click();
    WebElement dayOptional = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--023']"));
    dayOptional.click();

    WebElement subjectsInput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
    subjectsInput.sendKeys(subject);
    WebElement subjectOptional = driver.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__option')]"));
    subjectOptional.click();

    WebElement hobbiesLabel = driver.findElement(By.xpath("//label[text()='Sports']"));
    hobbiesLabel.click();

    WebElement pictureInput = driver.findElement(By.xpath("//input[@type='file']"));
    pictureInput.sendKeys(System.getProperty("user.dir") + "/src/test/resources/Penguins.jpg");

    WebElement addressTextArea = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
    addressTextArea.sendKeys(address);

    WebElement stateOptional = driver.findElement(By.xpath("//div[text()='Select State']"));
    stateOptional.click();
    WebElement stateSelect = driver.findElement(By.xpath("//div[text()='NCR']"));
    stateSelect.click();

    WebElement cityOptional = driver.findElement(By.xpath("//div[text()='Select City']"));
    cityOptional.click();
    WebElement citySelect = driver.findElement(By.xpath("//div[text()='Delhi']"));
    citySelect.click();

    WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
    submitBtn.click();

    WebElement emailOnFormTd = driver.findElement(By.xpath("//td[text()='Student Email']//following-sibling::td"));

    String emailOnForm = emailOnFormTd.getText();
    Assertions.assertEquals(email, emailOnForm);

  }


}
