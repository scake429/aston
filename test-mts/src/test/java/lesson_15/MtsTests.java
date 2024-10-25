package lesson_15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.openqa.selenium.*;
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
    public void test() {
        driver.get("https://www.mts.by/");

        driver.manage().deleteCookieNamed("BITRIX_SM_COOKIES_AGREEMENT");
        driver.manage().addCookie(new Cookie("BITRIX_SM_COOKIES_AGREEMENT", "no"));

        String title = driver.getTitle();
        assertEquals("МТС – мобильный оператор в Беларуси", title);

        WebElement sectPay = driver.findElement(By.cssSelector(".pay"));

        WebElement heading = sectPay.findElement(By.tagName("h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", heading.getText());

        WebElement payPartnersList = sectPay.findElement(By.cssSelector(".pay__partners ul"));
        assertEquals(payPartnersList.isDisplayed(), true);
        assertEquals(payPartnersList.findElements(By.cssSelector("li>img")).size(), 5);

        WebElement ancorDetailedServ = sectPay.findElement(By.cssSelector("a"));
        assertEquals(ancorDetailedServ.isDisplayed(), true);
        assertEquals("Подробнее о сервисе", ancorDetailedServ.getText());
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", ancorDetailedServ.getAttribute("href"));

        ancorDetailedServ.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
        driver.navigate().back();


        assertEquals("Услуги связи", driver.findElement(By.cssSelector("#pay-section .select__now")).getText());
        WebElement formPayments = driver.findElement(By.id("pay-connection"));
        assertEquals(formPayments.isDisplayed(), true);
        WebElement inputTel = formPayments.findElement(By.id("connection-phone"));
        inputTel.clear();
        inputTel.click();
        inputTel.sendKeys("297777777");

        WebElement inputSum = formPayments.findElement(By.id("connection-sum"));
        inputSum.clear();
        inputSum.click();
        inputSum.sendKeys("100");

        WebElement inputEmail = formPayments.findElement(By.id("connection-email"));
        inputEmail.clear();
        inputEmail.click();
        inputEmail.sendKeys("test@testmail.com");

        WebElement butt = formPayments.findElement(By.cssSelector("button[type=\"submit\"]"));
        assertEquals("Продолжить", butt.getText());
        butt.click();

        driver.manage().deleteCookieNamed("BITRIX_SM_COOKIES_AGREEMENT");
    }
}
