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

    @BeforeAll
    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void createDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    private void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
        String tel;
        String sum;
        String email;
        tel = "297777777";
        sum = "100.00";
        email = "test@testmail.com";

        driver.manage().deleteAllCookies();

        String title = driver.getTitle();
        assertEquals("МТС – мобильный оператор в Беларуси", title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement butCookieCanc = driver.findElement(By.cssSelector(".cookie__wrapper .cookie__cancel"));
            wait.until(ExpectedConditions.elementToBeClickable(butCookieCanc));
            butCookieCanc.click();
        } catch (TimeoutException e) {
        }

        WebElement sectPay = driver.findElement(By.cssSelector(".pay"));

        WebElement heading = sectPay.findElement(By.tagName("h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", heading.getText());

        WebElement payPartnersList = sectPay.findElement(By.cssSelector(".pay__partners ul"));
        assertEquals(payPartnersList.isDisplayed(), true);
        assertEquals(payPartnersList.findElements(By.cssSelector("li>img")).size(), 5);

        WebElement ancorDetailedServ = sectPay.findElement(By.cssSelector("a"));
        assertEquals(ancorDetailedServ.isDisplayed(), true);
        assertEquals("Подробнее о сервисе", ancorDetailedServ.getText());
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                ancorDetailedServ.getAttribute("href"));

        ancorDetailedServ.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
        driver.navigate().back();

        assertEquals("Услуги связи", driver.findElement(By.cssSelector("#pay-section .select__now")).getText());
        WebElement formPayments = driver.findElement(By.id("pay-connection"));
        assertEquals(formPayments.isDisplayed(), true);
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));

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
