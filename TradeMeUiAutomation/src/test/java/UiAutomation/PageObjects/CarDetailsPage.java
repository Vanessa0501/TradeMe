package UiAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarDetailsPage {
    private WebDriver driver;
    private By carDetails = By.className("key-details-attribute-value");

    public int fieldsValueMatched = 0;
    public int fieldsValueUnMatched = 0;

    public CarDetailsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void verifyEachCarDetail(WebDriver driver, String numberPlate, String kilometres, String body, String fuelType, String engine, String transmission, String history, String registrationExpires, String wofExpires) {
        List<WebElement> actualCarDetails = driver.findElements(carDetails);
        //Verify the Number plate value is correct
        compareDetail(actualCarDetails.get(0).getText(),numberPlate);
        //Verify the Kilometres value is correct
        compareDetail(actualCarDetails.get(1).getText(),kilometres);
        //Verify the body value is correct
        compareDetail(actualCarDetails.get(2).getText(),body);
        //Verify the fuel type value is correct
        compareDetail(actualCarDetails.get(3).getText(),fuelType);
        //Verify the engine value is correct
        compareDetail(actualCarDetails.get(4).getText(),engine);
        //Verify the transmission value is correct
        compareDetail(actualCarDetails.get(5).getText(),transmission);
        //Verify the history value is correct
        compareDetail(actualCarDetails.get(6).getText(),history);
        //Verify the registration expires value is correct
        compareDetail(actualCarDetails.get(7).getText(),registrationExpires);
        //Verify the WOF expires value is correct
        compareDetail(actualCarDetails.get(8).getText(),wofExpires);
    }

    public void compareDetail(String actualFieldValue, String expectedFieldValue){
        if (actualFieldValue.equals(expectedFieldValue)){
            fieldsValueMatched=fieldsValueMatched+1;
        }
        else{
            fieldsValueUnMatched = fieldsValueUnMatched+1;
        }
    }
}