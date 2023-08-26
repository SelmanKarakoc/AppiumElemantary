package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamApp {

    AppiumDriver<MobileElement> driver;

    final String deviceName="Pixel";
    final String platformName="Android";
    final String platformVersion="10.0";
    final String automationName="UiAutomator2";

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);
        // false uygulamayı sıfırlar
        // true uygulamayı sıfırlamaz kaldığı yerden devam eder
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}

    @Test
    public void arabamtest(){

        //driver.findElement(By.xpath("//*[@text='İlan ver']")).click();
        driver.findElement(By.xpath("//*[@text='Arabam kaç para?']")).click();
        driver.findElement(By.id("com.dogan.arabam:id/btn_google_login")).click();
        //ekran kaydırma
        /*TouchAction action=new TouchAction<>(driver);

        action.press(PointOption.point(543,1732)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                moveTo(PointOption.point(543,381)).
                release().perform();
*/
        //bilgi girme
        //driver.getKeyboard().pressKey("190000");
        //driver.findElementById().sendKeys();



    }
}
