package lesson_18;

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

import io.qameta.allure.Description;

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
            WebElement butCookieCanc = CoockieActions.buttonCancel(driver);
            wait.until(ExpectedConditions.elementToBeClickable(butCookieCanc));
            butCookieCanc.click();
        } catch (Exception e) {
        }
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Checking the name of the replenishment block")
    @Description("Проверка наименования формы пополнения без комиссии")
    public void testCheckName() {
        WebElement heading = SectionPay.head(driver);
        assertEquals("Онлайн пополнение\nбез комиссии", heading.getText());
    }

    @Test
    @DisplayName("Logo check")
    @Description("Проверка наличия логотипов платежных систем")
    public void testCheckLogo() {
        WebElement payPartnersList = SectionPay.partnersList(driver);
        assertTrue(payPartnersList.isDisplayed());
        assertEquals(SectionPay.partnersListArr(driver).size(), 5);
    }

    @Test
    @DisplayName("Link check")
    @Description("Проверка работы ссылки 'Подробнее о сервисе'- проверка url при переходе по ссылке и названий секций на загруженной странице.")
    public void testCheckLink() {
        WebElement ancorDetailedServ = SectionPay.detailedServ(driver);
        assertTrue(ancorDetailedServ.isDisplayed());
        assertEquals("Подробнее о сервисе", ancorDetailedServ.getText());
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                ancorDetailedServ.getAttribute("href"));
        ancorDetailedServ.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
        String allText = SectionPay.textFromDetailedServ(driver);
        assertTrue(allText.contains("Оплата банковской картой"));
        assertTrue(allText.contains("Информация о безопасности Интернет-платежей"));
        assertTrue(allText.contains("Условия возврата денежных средств"));
        driver.navigate().back();
    }

    @Test
    @DisplayName("Form check")
    @Description("Проверка placeholder полей формы оплаты, заполнение этих полей, отправка формы и проверка корректности номера телефона и суммы во фрейме.")
    public void testCheckForm() {
        assertEquals("Услуги связи", SectionPay.connection(driver).getText());
        WebElement formPayments = SectionPay.form(driver);
        assertTrue(formPayments.isDisplayed());

        assertEquals(SectionPay.telGetAttr(driver, "placeholder"), "Номер телефона");
        SectionPay.fillInputTel(driver, tel);

        assertEquals(SectionPay.sumGetAttr(driver, "placeholder"), "Сумма");
        SectionPay.fillInputSum(driver, sum);

        assertEquals(SectionPay.emailGetAttr(driver, "placeholder"), "E-mail для отправки чека");
        SectionPay.fillInputEmail(driver, email);

        WebElement butt = SectionPay.continueButt(driver);
        assertEquals("Продолжить", butt.getText());
        butt.click();

        WebDriverWait waitForIframe = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForIframe.until(ExpectedConditions.visibilityOfElementLocated(FramePayment.byFrame));

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
