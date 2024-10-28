package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramePayment {
    public static By byFrame = By.className("bepaid-iframe");
    public static By byWrap = By.cssSelector(".app-wrapper__content");
    public static By byPayButt = By.xpath("//button");

    public FramePayment() {}
    
    public static WebElement frame(WebDriver driver) {
        return driver.findElement(By.className("bepaid-iframe"));
    }

    public static WebElement wrap(WebDriver driver) {
        return driver.findElement(byWrap);
    }

    public static By bySum(String sum) {
        return By.xpath("//*[contains(text(), '" + sum + " BYN')]");
    }

    public static WebElement sum(WebDriver driver, String sum) {
        return wrap(driver).findElement(bySum(sum));
    }

    public static WebElement tel(WebDriver driver, String tel) {
        return wrap(driver).findElement(By.xpath("//*[contains(text(), 'Оплата: Услуги связи\r\n" + "Номер:375" + tel + "')]"));
    }

    public static WebElement payButt(WebDriver driver, String sum) {
        return wrap(driver).findElement(By.xpath("//button[contains(text(), 'Оплатить  " + sum + " BYN')]"));
    }

}
