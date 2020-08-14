package UiAutomation.PageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MotorsPage {
    private WebDriver driver;
    private By carsForSale = By.linkText("Cars for sale");

    public MotorsPage(WebDriver driver){
        this.driver = driver;
    }

    public UsedCarsPage clickCarsForSaleLink(WebDriver driver){
        driver.findElement(carsForSale).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(carsForSale)));
        return new UsedCarsPage(driver);
    }
}
