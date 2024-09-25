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
    String month = "September";
    String day = "029";
    String titleModalText = "Thanks for submitting the form";
    String keyFullName = "Student Name";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
    registrationFormPage.setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setMobilePhone(mobPhone)
            .setGender(gender)
            .setSubject(subject)
            .setHobbies(hobby)
            .uploadPicture(fileName)
            .setAddress(address)
            .setState(stateName)
            .setCity(cityName)
            .setDayOfBirth(year, month, day)
            .submitClick()
            .assertTitleModal(titleModalText)
            .assertTableResult(keyFullName, firstName + " " + lastName)
            .assertTableResult("Mobile", mobPhone)
            .assertTableResult("Subjects", subject)
            .closeModalForm();

  }


}
