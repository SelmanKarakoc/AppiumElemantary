import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
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

        driver.findElement(By.xpath("//*[@text='İlan ver']")).click();


    }
}
