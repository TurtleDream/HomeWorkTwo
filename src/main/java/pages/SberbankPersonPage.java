package pages;

import library.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberbankPersonPage extends BasePage {

    @FindBy (xpath = "//span[contains(text(), 'Страхование')]")
    private WebElement insurance;

    @FindBy (xpath = "//a[contains(text(), 'Путешествия и покупки')]")
    private WebElement travelsAndPurchases;

    public SberbankPersonPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SberbankPersonPage goToPage(){
        webDriver.get("http://www.sberbank.ru/ru/person");
        return this;
    }

    public void goToTravelsAndPurchases(){
        click(insurance);
        click(travelsAndPurchases);
    }
}
