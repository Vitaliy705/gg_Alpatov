package selenium.zadanie_seven.registrFormPage.components;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.zadanie_seven.registrFormPage.BasePage;

public class ModalRegistrationFormSubmit extends BasePage {

    private final By titleModalLocator = By.xpath("//div[@class='modal-title h4']");
    private final String anyLabelOnTableLocator = "//td[text()='%s']/following-sibling::td";
    private final By btnCloseLocator = By.xpath("//button[text()='Close']");


    public ModalRegistrationFormSubmit(WebDriver driver) {
        super(driver);
    }

    public void assertTitleModal(String actualTitle){
        waitVisibilityOfElement(titleModalLocator);
        String getTitleModal = driver.findElement(titleModalLocator).getText();
        Assertions.assertEquals(actualTitle, getTitleModal);
    }

    public void assertTable(String key, String actualValue){
        String expectedValue = driver.findElement(By.xpath(String.format(anyLabelOnTableLocator, key))).getText();
        Assertions.assertEquals(actualValue, expectedValue);
    }

    public void btnCloseClick(){
        driver.findElement(btnCloseLocator).click();
    }
}
