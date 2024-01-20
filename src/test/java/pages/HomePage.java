package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {
    AndroidDriver driver;

    public HomePage(AndroidDriver webdriver) {
        driver = webdriver;
    }

    By popupText = By.id("trendyol.com:id/textViewTooltipTitle");
    By popupCloseButton = By.id("trendyol.com:id/imageViewTooltipClose");
    By searchBar = By.id("trendyol.com:id/edittext_search_view");

    public void checkPopUpMessage(){
        Assert.assertTrue(driver.findElement(popupText).isDisplayed());
    }

    public void closePopUpMessage(){
        driver.findElement(popupCloseButton).click();
    }

    public void selectSearchBarAndSearchIphone(){
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys("iphone");
        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
    }

}