package lesson_15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MtsTests {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void createDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    private void teardown() {
        driver.quit();
    }

    @Test
    // @ParameterizedTest
    // @ValueSource(strings = {"МТС – мобильный оператор в Беларуси"})
    public void test() {
        driver.get("https://www.mts.by/");
        String title = driver.getTitle();
        assertEquals("МТС – мобильный оператор в Беларуси", title);

        WebElement sectPay = new WebDriverWait(driver, 3).ExpectedConditions.visibilityOfElementLocated(By.className("pay")); //*[@id="pay-section"]/div/div/div[2]/section
        

    }
}
