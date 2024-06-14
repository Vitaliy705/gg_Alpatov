package selenium.zadanie_seven;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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
    driver.get("https://www.f1news.ru/");
  }

  @AfterEach
  public void getOut(){
    driver.quit();
  }
}
