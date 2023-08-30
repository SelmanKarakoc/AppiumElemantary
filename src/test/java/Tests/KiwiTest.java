package Tests;

import Pages.KiwiPage;
import Utilities.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KiwiTest {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    KiwiPage page=new KiwiPage();

    @Test
    public void test01() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"),"uygulama yuklenemedi");
    // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.asaGuest.isDisplayed(), "uygulama başarıyla açılıyor");
    // misafir olarak devam et e tiklanir
        page.asaGuest.click();
    // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        for (int i = 0; i < 4; i++) {
            page.passButton.click();
            Thread.sleep(500);
        }

    // Trip type,one way olarak secilir
        Thread.sleep(500);
        page.oneWayButton.click();
        page.oneWayButton.click();
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.fromButton.click();
        page.fromClose.click();
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("Izmir");
        driver.findElementByXPath("//*[@text='İzmir, Turkey']").click();
        page.chooseButton.click();
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        page.toButton.click();
        Thread.sleep(500);
        driver.getKeyboard().pressKey("Basel");
        driver.findElementByXPath("//*[@text='Basel, Switzerland']").click();
        page.chooseButton.click();
    // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        Thread.sleep(500);
        page.departureButtonClick();
        Thread.sleep(500);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(538,1323)).release().perform();
        page.setDateButton.click();

    // search butonuna tiklanir
        page.searchButton.click();
        Thread.sleep(2000);
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.sortingButton.click();
        page.cheapestButton.click();
        Thread.sleep(3000);
        page.stopsButton.click();
        page.nonStopButton.click();
        Thread.sleep(5000);
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

        String price=page.price.getText();
        driver.sendSMS("12345678",price);


    }
}
