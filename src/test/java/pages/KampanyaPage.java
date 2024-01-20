package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class KampanyaPage {
    AndroidDriver driver;
    public KampanyaPage(AndroidDriver androidDriver){
        driver = androidDriver;
    }
    By closeButton = By.id("trendyol.com:id/imageButtonClose");
    By notification = By.id("trendyol.com:id/textViewOpenNotification");
    By image = By.className("android.widget.ImageView");
    By yesButton = By.id("trendyol.com:id/buttonAccept");

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public void checkImage(){
        Assert.assertTrue(driver.findElement(image).isDisplayed());
    }
    public void checkText(){
        String str= "Yeni ürün ve kampanyaları önce sen öğrenmek ister misin?";
        String eleText = driver.findElement(notification).getText();
        Assert.assertEquals(eleText,str);
    }
}
