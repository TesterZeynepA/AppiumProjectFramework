package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class UsageOfReusableMethods {
    ReusableMethods methods;
    AndroidDriver driver;
    ManWomanPage mwp;
    KampanyaPage kp;
    HomePage hp;
    SearchPage sp;
    ProductsPage pp;
    By ikinciEl = By.xpath("//android.widget.TextView[@text=\"İkinci El Kategorileri\"]");
    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("EML L09")
                .setUdid("BPN0218608003129")
                .setAppPackage("trendyol.com")
                .setAppActivity("com.trendyol.common.splash.impl.ui.SplashActivity")
                .setNoReset(false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        mwp = new ManWomanPage(driver);
        kp = new KampanyaPage(driver);
        hp = new HomePage(driver);
        pp = new ProductsPage(driver);
        sp = new SearchPage(driver);
        methods = new ReusableMethods(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
        methods.volumeUp();
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
        methods.volumeDown();
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_MUTE));
        methods.clickBackButton();
        methods.clickHomeButton();
        methods.clickAppSwitchButton();
        driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
       // System.out.println("methods.appYuklumu(\"com.pozitron.hepsiburada\") = " + methods.appYuklumu("com.pozitron.hepsiburada"));
       // methods.terminateApp("trendyol.com");
       // Thread.sleep(3000);
       // methods.activateApp("trendyol.com");
        Thread.sleep(3000);
        methods.arkaplandaCalistir(10);
       if (methods.cihazKapalimi()){
           methods.cihazAc();
       }else methods.cihazKapat();

       methods.cihazAc();
       methods.bildirimleriAc();
       methods.wifi();
       methods.wifi();
      // methods.activateApp("com.pozitron.hepsiburada");


    }

    @Test
    public void test3() throws InterruptedException {
       // methods.sendFakeMessage("+90532", "first message");
       // Thread.sleep(3000);
       // methods.fakeAramaYap("+905418488285");
       // Thread.sleep(9000);
       // methods.aramayiKapat("+905418488285");

        mwp.clickKadinButton();
       // kp.clickCloseButton();
        hp.closePopUpMessage();

      // methods.scrollDown();
      // methods.scrollDown();
      // methods.scrollDown();
      // methods.scrollDown();
      // methods.scrollDown();
      // methods.scrollUp();
      // methods.scrollUp();
      // methods.scrollUp();
      // methods.scrollUp();
      // methods.scrollUp();

      // methods.swipeLeftInElement(By.id("trendyol.com:id/recyclerViewSliderProduct"));
      // methods.swipeLeftInElement(By.id("trendyol.com:id/recyclerViewSliderProduct"));
      // methods.swipeLeftInElement(By.id("trendyol.com:id/recyclerViewSliderProduct"));

      methods.finalScrollMethod(ikinciEl);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
