package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class firstStep {

    AndroidDriver<MobileElement> driver; //MobileElement yerine AndroidElement de kullanılabilir
    //AppiumDriver<MobileElement> driver; // hem ios hem android için

    @BeforeTest
    public void test01() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\selma.DESKTOP-KJR7OP7\\IdeaProjects\\appium_elemantary\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Test
    public void carpma() {

        driver.findElementByAccessibilityId("8").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();

        String actualResult = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(actualResult);

        int expectedResult = 80 * 20;

        Assert.assertEquals(Integer.parseInt(actualResult), expectedResult);
    }

    @Test
    public void toplama() {

        driver.findElementByAccessibilityId("3").click();
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("5").click();

        String actualResult = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(actualResult);

        int expectedResult = 34 + 15;

        Assert.assertEquals(Integer.parseInt(actualResult), expectedResult);
    }

    @Test
    public void test02(){
        driver.activateApp("com.google.android.calculator");

    }
}


