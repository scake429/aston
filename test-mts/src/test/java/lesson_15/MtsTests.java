package lesson_15;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MtsTests {
    WebDriver driver;
    WebDriverWait wait;

    String tel = "297777777";
    String sum = "100.00";
    String email = "test@testmail.com";

    WebElement sectPay;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void createDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        driver.manage().deleteAllCookies();

        String title = driver.getTitle();
        assertEquals("МТС – мобильный оператор в Беларуси", title);

        try {
            WebElement butCookieCanc = driver.findElement(By.cssSelector(".cookie__wrapper .cookie__cancel"));
            wait.until(ExpectedConditions.elementToBeClickable(butCookieCanc));
            butCookieCanc.click();
        } catch (Exception e) {
        }

        sectPay = driver.findElement(By.cssSelector(".pay"));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Checking the name of the replenishment block")
    public void testCheckName() {
        WebElement heading = sectPay.findElement(By.tagName("h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", heading.getText());
    }

    @Test
    @DisplayName("Logo check")
    public void testCheckLogo() {
        WebElement payPartnersList = sectPay.findElement(By.cssSelector(".pay__partners ul"));
        assertTrue(payPartnersList.isDisplayed());
        assertEquals(payPartnersList.findElements(By.cssSelector("li>img")).size(), 5);
    }

    @Test
    @DisplayName("Link check")
    public void testCheckLink() {
        WebElement ancorDetailedServ = sectPay.findElement(By.cssSelector("a"));
        assertTrue(ancorDetailedServ.isDisplayed());
        assertEquals("Подробнее о сервисе", ancorDetailedServ.getText());
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                ancorDetailedServ.getAttribute("href"));
        ancorDetailedServ.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
        String allText = driver.findElement(By.cssSelector("div.wrapper")).getText();
        assertTrue(allText.contains("Оплата банковской картой"));
        assertTrue(allText.contains("Информация о безопасности Интернет-платежей"));
        assertTrue(allText.contains("Условия возврата денежных средств"));
        driver.navigate().back();
    }

    @Test
    @DisplayName("Form check")
    public void testCheckForm() {
        assertEquals("Услуги связи", driver.findElement(By.cssSelector("#pay-section .select__now")).getText());
        WebElement formPayments = driver.findElement(By.id("pay-connection"));
        assertTrue(formPayments.isDisplayed());
        WebElement inputTel = formPayments.findElement(By.id("connection-phone"));
        inputTel.clear();
        inputTel.click();
        inputTel.sendKeys(tel);

        WebElement inputSum = formPayments.findElement(By.id("connection-sum"));
        inputSum.clear();
        inputSum.click();
        inputSum.sendKeys(sum);

        WebElement inputEmail = formPayments.findElement(By.id("connection-email"));
        inputEmail.clear();
        inputEmail.click();
        inputEmail.sendKeys(email);

        WebElement butt = formPayments.findElement(By.cssSelector("button[type=\"submit\"]"));
        assertEquals("Продолжить", butt.getText());
        butt.click();

        WebDriverWait waitForIframe = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForIframe.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));

        WebElement iframePayment = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(iframePayment);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".app-wrapper__content")));
        WebElement wrapPayment = driver.findElement(By.cssSelector(".app-wrapper__content"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + sum + " BYN')]")));
        assertTrue(wrapPayment.findElement(By.xpath("//*[contains(text(), '" + sum + " BYN')]")).isDisplayed());
        assertTrue(wrapPayment
                .findElement(By.xpath("//*[contains(text(), 'Оплата: Услуги связи\r\n" + "Номер:375" + tel + "')]"))
                .isDisplayed());
        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button"), "Оплатить " + sum + " BYN"));
        assertTrue(wrapPayment.findElement(By.xpath("//button[contains(text(), 'Оплатить  " + sum + " BYN')]"))
                .isDisplayed());
    }
}
