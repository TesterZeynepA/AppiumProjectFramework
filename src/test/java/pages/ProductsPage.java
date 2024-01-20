package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPage {
    AndroidDriver driver;

    public ProductsPage(AndroidDriver webDriver) {
        driver = webDriver;
    }

    By popup = By.id("trendyol.com:id/textViewTooltipTitle");

    By popupClose = By.id("trendyol.com:id/imageViewTooltipClose");

    By product = By.id("trendyol.com:id/edittext_search_view");

    public void checkPopUp(){
        Assert.assertTrue(driver.findElement(popup).isDisplayed());
    }

    public void checkProduct(){
        driver.findElement(popupClose).click();
        Assert.assertTrue(driver.findElement(product).getText().contains("İphone"));
    }


}
