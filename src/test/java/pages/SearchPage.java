package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class SearchPage {
    AndroidDriver driver;

    public SearchPage(AndroidDriver webDriver) {
        driver = webDriver;
    }

    By searchBar = By.id("trendyol.com:id/edittext_search_view");


    public void search(String str) {
        driver.findElement(searchBar).sendKeys(str);
        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
    }


}

