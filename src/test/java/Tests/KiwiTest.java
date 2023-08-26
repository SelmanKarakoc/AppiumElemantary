package Tests;

import Pages.KiwiPage;
import Utilize.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
            page.continueButton.click();
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
        driver.getKeyboard().pressKey("Freiburg");
    // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }
}
