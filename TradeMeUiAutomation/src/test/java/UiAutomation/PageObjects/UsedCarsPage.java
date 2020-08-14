package UiAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsedCarsPage {
    private WebDriver driver;
    private By makeTable = By.id("makes");
    private By carListings = By.className("tmm-search-card-list-view__card");

    public UsedCarsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean getMakeTableCells(WebDriver driver,String carMake) {
        boolean isFound = false;
        WebElement makeTbl = driver.findElement(makeTable);
        List<WebElement> rows = makeTbl.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cols.size(); j++) {
                if (cols.get(j).getText().contains(carMake)) {
                   isFound = true;
                   break;
                }
           }
      }
        return isFound;
    }

    public int countCarListings(WebDriver driver){
        int numberOfCarListings = 0;
        List<WebElement> currentCarListings = driver.findElements(carListings);
        numberOfCarListings = currentCarListings.size();
        return numberOfCarListings;
    }

    public CarDetailsPage clickFirstListing(WebDriver driver){
        List<WebElement> currentCarListings = driver.findElements(carListings);
        currentCarListings.get(9).click();
        return new CarDetailsPage(this.driver);
    }
}
