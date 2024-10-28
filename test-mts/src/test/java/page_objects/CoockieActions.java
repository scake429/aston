package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoockieActions {
    public CoockieActions() {}
    public static WebElement coockieWrap(WebDriver driver) {
        return driver.findElement(By.cssSelector(".cookie__wrapper"));
    }
    public static WebElement buttonCancel(WebDriver driver) {
        return driver.findElement(By.cssSelector(".cookie__wrapper .cookie__cancel"));
    }
    public static WebElement buttonOk(WebDriver driver) {
        return driver.findElement(By.id("cookie-agree"));
    }
}
