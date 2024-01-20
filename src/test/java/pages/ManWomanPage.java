package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ManWomanPage {
    AndroidDriver driver;
    public ManWomanPage(AndroidDriver androidDriver){
    driver = androidDriver;
    }
    By erkekButton= By.id("trendyol.com:id/buttonSelectGenderMan");

    By text = AppiumBy.className("android.widget.TextView");

    By kadinButton = AppiumBy.id("trendyol.com:id/buttonSelectGenderWoman");

    By closeButton = AppiumBy.id("trendyol.com:id/buttonDismiss");

    By image = AppiumBy.xpath("//android.widget.LinearLayout/android.widget.ImageView");

    public void clickErkekButton(){
        driver.findElement(erkekButton).click();
    }
    public void clickKadinButton(){
        driver.findElement(kadinButton).click();
    }

    public void clickCloseButton(){
        driver.findElement(closeButton).click();
    }
    public void checkText(){
        String str = "Sana en uygun ürünleri sunabilmemiz için bize yardımcı olur musun?";
       Assert.assertEquals(driver.findElement(text).getText(), str);
    }

    public void checkImage(){
        Assert.assertTrue(driver.findElement(image).isDisplayed());
    }
}
