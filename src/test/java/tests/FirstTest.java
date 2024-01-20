package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstTest {
    AndroidDriver driver;
    ManWomanPage mwp;
    KampanyaPage kp;
    HomePage hp;
    SearchPage sp;
    ProductsPage pp;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1(){
        //ManWoman pagedeki textin doğruluğunu kontrol et.
        mwp.checkText();
    }
    @Test
    public void test2(){
        //Kadın butonuna basıldığında önümüze çıkan kampanya pagedeki texti kontrol et
        mwp.clickKadinButton();
       // kp.checkText();
    }
    @Test
    public void test3(){
        //Home pagede popup message'ın varlığını test et.
        mwp.clickErkekButton();
       // kp.clickCloseButton();
        hp.checkPopUpMessage();
    }
    @Test
    public void test4(){
        //iphone araması yap, aramanın doğru şekilde yapıldığını doğrula.
        mwp.clickErkekButton();
        //kp.clickCloseButton();
        hp.closePopUpMessage();
        hp.selectSearchBar();
        sp.search("iphone");
        pp.checkPopUp();
        pp.checkProduct();

    }

    @Test
    public void dortTestTekMethod(){
        //ManWoman pagedeki textin doğruluğunu kontrol et.
        mwp.checkText();

        //Kadın butonuna basıldığında önümüze çıkan kampanya pagedeki texti kontrol et
        mwp.clickKadinButton();
        // kp.checkText();

        //Home pagede popup message'ın varlığını test et.
        // kp.clickCloseButton();
        hp.checkPopUpMessage();

        //iphone araması yap, aramanın doğru şekilde yapıldığını doğrula.
        hp.closePopUpMessage();
        hp.selectSearchBar();
        sp.search("iphone");
        pp.checkPopUp();
        pp.checkProduct();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
