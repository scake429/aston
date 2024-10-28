package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SectionPay {
    // private static WebElement sectPay;
    private static WebElement formPayments;
    
    public SectionPay() {}

    public static WebElement section(WebDriver driver) {
        return driver.findElement(By.cssSelector(".pay"));
    }
        
    public static WebElement head(WebDriver driver) {
        return section(driver).findElement(By.tagName("h2"));
    }
    
    public static WebElement partnersList(WebDriver driver) {
        return section(driver).findElement(By.cssSelector(".pay__partners ul"));
    }
    
    public static List<WebElement> partnersListArr(WebDriver driver) {
        return partnersList(driver).findElements(By.cssSelector("li>img"));
    }
    
    public static WebElement detailedServ(WebDriver driver) {
        return driver.findElement(By.cssSelector(".pay")).findElement(By.cssSelector("a"));
    }
    
    public static WebElement connection(WebDriver driver) {
        return driver.findElement(By.cssSelector("#pay-section .select__now"));
    }
    
    public static WebElement form(WebDriver driver) {
        formPayments = driver.findElement(By.id("pay-connection"));
        return formPayments;
    }

    public static WebElement tel(WebDriver driver) {
        return formPayments.findElement(By.id("connection-phone"));
    }

    public static String telGetAttr(WebDriver driver, String attr) {
        return tel(driver).getAttribute(attr);
    }
    
    public static void fillInputTel(WebDriver driver, String tel) {
        WebElement inputTel = formPayments.findElement(By.id("connection-phone"));
        inputTel.clear();
        inputTel.click();
        inputTel.sendKeys(tel);
    }

    public static WebElement sum(WebDriver driver) {
        return formPayments.findElement(By.id("connection-sum"));
    }

    public static String sumGetAttr(WebDriver driver, String attr) {
        return sum(driver).getAttribute(attr);
    }
    
    public static void fillInputSum(WebDriver driver, String sum) {
        WebElement inputSum = formPayments.findElement(By.id("connection-sum"));
        inputSum.clear();
        inputSum.click();
        inputSum.sendKeys(sum);
    }

    public static WebElement email(WebDriver driver) {
        return formPayments.findElement(By.id("connection-email"));
    }

    public static String emailGetAttr(WebDriver driver, String attr) {
        return email(driver).getAttribute(attr);
    }
    
    public static void fillInputEmail(WebDriver driver, String email) {
        WebElement inputEmail = formPayments.findElement(By.id("connection-email"));
        inputEmail.clear();
        inputEmail.click();
        inputEmail.sendKeys(email);
    }
    
    public static WebElement continueButt(WebDriver driver) {
        return formPayments.findElement(By.cssSelector("button[type=\"submit\"]"));
    }
}
