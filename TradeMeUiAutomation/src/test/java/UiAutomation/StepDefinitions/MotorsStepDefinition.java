package UiAutomation.StepDefinitions;

import UiAutomation.PageObjects.CarDetailsPage;
import UiAutomation.PageObjects.MotorsPage;
import UiAutomation.PageObjects.UsedCarsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class MotorsStepDefinition {
    private WebDriver driver;
    MotorsPage motorsPage = new MotorsPage(this.driver);
    UsedCarsPage usedCarsPage = new UsedCarsPage(this.driver);
    CarDetailsPage carDetailsPage = new CarDetailsPage(this.driver);

    @Given("I am on Trade Me Motors page")
    public void iAmOnTradeMeMotorsPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/ludmillachellemben/workspace/Trade Me/TradeMeUiAutomation/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz/motors?oauth_token=A64BA5151518CDB218722F577C4B00BA&oauth_verifier=EC9AF47EC9DE954AD140E6951AA70BDD");
    }

    @When("I click on Cars for sale link")
    public void iClickOnCarsForSaleLink() {
        motorsPage.clickCarsForSaleLink(this.driver);
    }

    @Then("I can see {string} car make exists")
    public void iCanSeeKiaCarMakeExists(String carMake) {
       Boolean carMakeFound =usedCarsPage.getMakeTableCells(this.driver,carMake);
       Assert.assertTrue(carMakeFound);
    }

    @Then("I should see used cars listing")
    public void iShouldSeeUsedCarsListing() {
        int currentListing = usedCarsPage.countCarListings(this.driver);
        Assert.assertTrue(currentListing >0);
    }

    @And("I select the first car listing")
    public void iSelectTheFirstCarListing() {
        usedCarsPage.clickFirstListing(this.driver);
    }

    @And("the car has the following details {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void theCarHasTheFollowingDetailsAnd(String numberPlate, String kilometres, String body, String seat, String fuelType, String engine, String transmission, String history, String registrationExpires, String wofExpires, String modelDetail) {
        int expectedMatchFields = 9;
        carDetailsPage.verifyEachCarDetail(this.driver,numberPlate, kilometres, body, fuelType, engine, transmission, history, registrationExpires, wofExpires);
        int actualMatchedFields = carDetailsPage.fieldsValueMatched;
        Assert.assertEquals(expectedMatchFields,actualMatchedFields);
    }
}
