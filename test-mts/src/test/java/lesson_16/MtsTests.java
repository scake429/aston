package lesson_16;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import page_objects.CoockieActions;
import page_objects.FramePayment;
import page_objects.SectionPay;

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
            WebElement butCookieCanc = CoockieActions.buttonCancel(driver);
            wait.until(ExpectedConditions.elementToBeClickable(butCookieCanc));
            butCookieCanc.click();
        } catch (TimeoutException e) {
        }

        WebElement heading = SectionPay.head(driver);
        assertEquals("Онлайн пополнение\nбез комиссии", heading.getText());

        WebElement payPartnersList = SectionPay.partnersList(driver);
        assertEquals(payPartnersList.isDisplayed(), true);
        assertEquals(SectionPay.partnersListArr(driver).size(), 5);

        WebElement ancorDetailedServ = SectionPay.detailedServ(driver);
        assertEquals(ancorDetailedServ.isDisplayed(), true);
        assertEquals("Подробнее о сервисе", ancorDetailedServ.getText());
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                ancorDetailedServ.getAttribute("href"));
        ancorDetailedServ.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
        driver.navigate().back();

        assertEquals("Услуги связи", SectionPay.connection(driver).getText());
        WebElement formPayments = SectionPay.form(driver);
        assertEquals(formPayments.isDisplayed(), true);

        assertEquals(SectionPay.telGetAttr(driver, "placeholder"), "Номер телефона");

        SectionPay.fillInputTel(driver, tel);

        assertEquals(SectionPay.sumGetAttr(driver, "placeholder"), "Сумма");

        SectionPay.fillInputSum(driver, sum);

        assertEquals(SectionPay.emailGetAttr(driver, "placeholder"), "E-mail для отправки чека");

        SectionPay.fillInputEmail(driver, email);

        WebElement butt = SectionPay.continueButt(driver);
        assertEquals("Продолжить", butt.getText());
        butt.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(FramePayment.byFrame));

        WebElement iframePayment = FramePayment.frame(driver);
        driver.switchTo().frame(iframePayment);

        wait.until(ExpectedConditions.presenceOfElementLocated(FramePayment.byWrap));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FramePayment.bySum(sum)));
        assertTrue(FramePayment.sum(driver, sum).isDisplayed());
        assertTrue(FramePayment.tel(driver, tel).isDisplayed());
        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(FramePayment.byPayButt, "Оплатить " + sum + " BYN"));
        assertTrue(FramePayment.payButt(driver, sum).isDisplayed());
    }
}
