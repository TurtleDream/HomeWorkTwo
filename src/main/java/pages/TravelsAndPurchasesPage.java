package pages;

import library.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TravelsAndPurchasesPage extends BasePage {

    public TravelsAndPurchasesPage (WebDriver webDriver){
        super(webDriver);
    }

    public void clickMakeOnlineButton(){
        switchTab("//a[contains (@href, 'viewCalc')]");
    }

    public void checkPageForText(String text) {
        Assert.assertTrue(checkPageContainsText(text));
    }
}
