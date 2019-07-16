package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class BasePage {
    protected WebDriver webDriver;
    private WebDriverWait webDriverWaitVisible;
    private WebDriverWait webDriverWaitClickable;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWaitVisible = new WebDriverWait(webDriver, 15);
        webDriverWaitClickable = new WebDriverWait(webDriver, 15);
    }

    private void wait (WebElement webElement){
        webDriverWaitVisible.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWaitClickable.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void click(WebElement webElement){
        wait(webElement);
        webElement.click();
    }

    protected boolean checkPageContainsText(String text){
        return webDriver.getPageSource().contains(text);
    }

    protected synchronized void setText(WebElement webElement, String text){
        wait(webElement);
        webElement.sendKeys(text);
    }

    protected void switchTab (String tab){
        Set<String> oldWindowsSet = webDriver.getWindowHandles();
        webDriver.findElement(By.xpath(tab)).click();
        Set<String> newWindowsSet = webDriver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        webDriver.switchTo().window(newWindowHandle);
    }
}