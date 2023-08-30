package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiwiPage {
    public KiwiPage(){
        //PageFactory.initElements ((WebDriver)Driver.getAndroidDriver(),this);//bunu hoca yapti ama bunsuz da calisiyor
        PageFactory.initElements (Driver.getAndroidDriver(),this);
    }
    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement asaGuest;

    @FindBy(id = "com.skypicker.main:id/primary_button")
    public WebElement passButton;

    @FindBy(id = "com.skypicker.main:id/search_type_label_text_view")
    public WebElement oneWayIdButton;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement fromButton;

    @FindBy(id = "com.skypicker.main:id/button_search_input_delete")
    public WebElement fromClose;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement toButton;

    @FindBy(id = "com.skypicker.main:id/departure_label_text_view")
    private WebElement departureButton;

    public void departureButtonClick(){
        departureButton.click();
    }

    @FindBy(id = "com.skypicker.main:id/saveButton")
    public WebElement setDateButton;

    @FindBy(id = "com.skypicker.main:id/search_button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Sorting']")
    public WebElement sortingButton;

    @FindBy(xpath = "//*[@text='Cheapest']")
    public WebElement cheapestButton;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopsButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonStopButton;

    @FindBy(id = "com.skypicker.main:id/price")
    public WebElement price;
}
