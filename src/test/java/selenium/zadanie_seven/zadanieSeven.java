package selenium.zadanie_seven;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class zadanieSeven {

  private WebDriver driver;

  @BeforeEach
  public void setUp(){
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(1920,1080));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @Test
  public void priveteForm(){
    driver.get("https://demoqa.com/automation-practice-form");

    String firstName = "Alex";
    String lastName = "Coruzo";
    String email = "coruzo@gmail.com";
    String mobPhone = "9056587887";
    String subject = "b";
    String adress = "Bruklin 89";

    WebElement firstNameInput = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    WebElement lastNameInput = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
    WebElement genderInput = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
    WebElement mobPhoneInput = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
    firstNameInput.sendKeys(firstName);
    lastNameInput.sendKeys(lastName);
    emailInput.sendKeys(email);
    genderInput.click();
    mobPhoneInput.sendKeys(mobPhone);

    WebElement dateOfBirthInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
    dateOfBirthInput.click();
    WebElement yearSelect = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
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
    WebElement subjectOptional = driver.findElement(By.xpath("//div[text()='Biology']"));
    subjectOptional.click();

    WebElement hobbiesLabel = driver.findElement(By.xpath("//label[text()='Sports']"));
    hobbiesLabel.click();

    WebElement pictureInput = driver.findElement(By.xpath("//input[@type='file']"));
    pictureInput.sendKeys(System.getProperty("user.dir") + "/src/test/resources/Penguins.jpg");

    WebElement adressTextArea = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
    adressTextArea.sendKeys(adress);

    WebElement stateOpional = driver.findElement(By.xpath("//div[text()='Select State']"));
    stateOpional.click();
    WebElement stateSelect = driver.findElement(By.xpath("//div[text()='NCR']"));
    stateSelect.click();

    WebElement cityOpional = driver.findElement(By.xpath("//div[text()='Select City']"));
    cityOpional.click();
    WebElement citySelect = driver.findElement(By.xpath("//div[text()='Delhi']"));
    citySelect.click();

    WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
    submitBtn.click();

    WebElement emailOnFormTd = driver.findElement(By.xpath("//td[text()='Student Email']//following-sibling::td"));

    String emailOnForm = emailOnFormTd.getText();
    Assertions.assertTrue(email.equals(emailOnForm));

  }

  @AfterEach
  public void getOut(){
    driver.quit();
  }
}
