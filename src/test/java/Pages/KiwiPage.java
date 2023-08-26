package Pages;

import Utilize.Driver;
import org.openqa.selenium.support.PageFactory;

public class KiwiPage {
    public KiwiPage(){
        //PageFactory.initElements ((WebDriver)Driver.getAndroidDriver(),this);//bunu hoca yapti ama bunsuz da calisiyor
        PageFactory.initElements (Driver.getAndroidDriver(),this);
    }

}
