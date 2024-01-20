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

    public void checkProduct(){
        Assert.assertTrue(driver.findElement(popup).isDisplayed());
    }

}
