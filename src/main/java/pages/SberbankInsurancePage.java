package pages;

import library.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;

public class SberbankInsurancePage extends BasePage {

    @FindBy (xpath = "//div[@class='b-form-prog-block ng-scope'][1]")
    private WebElement minSumInsurance;

    @FindBy (xpath = "//span[contains(text(), 'Оформить')]")
    private WebElement issue;

    @FindBy (name = "insured0_surname")
    private WebElement surnameField;

    @FindBy (name = "insured0_name")
    private WebElement givenNamesField;

    @FindBy (name = "insured0_birthDate")
    private WebElement dateOfBirth;

    @FindBy (name = "surname")
    private WebElement surname;

    @FindBy (name = "name")
    private WebElement name;

    @FindBy (name = "middlename")
    private WebElement middlename;

    @FindBy (name = "birthDate")
    private WebElement birthDate;

    @FindBy (name = "male")
    private WebElement male;

    @FindBy (name = "female")
    private WebElement female;

    @FindBy (name = "passport_series")
    private WebElement passport_series;

    @FindBy (name = "passport_number")
    private WebElement passport_number;

    @FindBy (name = "issueDate")
    private WebElement issueDate;

    @FindBy (name = "issuePlace")
    private WebElement issuePlace;

    @FindBy (xpath = "//span[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    @FindBy (xpath = "//div[contains(text(), 'Заполнены не все обязательные поля')]")
    private WebElement errorMsg;

    public SberbankInsurancePage(WebDriver webDriver){
        super(webDriver);
    }

    public void policySelection (){
        click(minSumInsurance);
        click(issue);
    }

    public void formFilling (Map<String, String> map) {
        setText(surnameField, map.get("engFirstName"));
        setText(givenNamesField, map.get("engLastName"));
        setText(dateOfBirth, map.get("dateOfBirth"));
        setText(name, map.get("firstName"));
        setText(surname, map.get("lastName"));
        setText(middlename, map.get("middleName"));
        setText(birthDate, map.get("dateOfBirthS"));

        if(map.get("sex") == "f") click(female);

        setText(passport_series, map.get("passportSeries"));
        setText(passport_number, map.get("passportNumber"));
        setText(issueDate, map.get("dateOfIssue"));
        setText(issuePlace, map.get("issuedBy"));
    }

    public void checkFilling (Map<String, String> map){
        Assert.assertEquals(
                "",
                map.get("engFirstName"),
                surnameField.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("engLastName"),
                givenNamesField.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("dateOfBirth"),
                dateOfBirth.getAttribute("value").replace(".",""));
        Assert.assertEquals(
                "",
                map.get("lastName"),
                surname.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("firstName"),
                name.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("middleName"),
                middlename.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("dateOfBirthS"),
                birthDate.getAttribute("value").replace(".",""));
        Assert.assertEquals(
                "",
                map.get("passportSeries"),
                passport_series.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("passportNumber"),
                passport_number.getAttribute("value"));
        Assert.assertEquals(
                "",
                map.get("dateOfIssue"),
                issueDate.getAttribute("value").replace(".",""));
        Assert.assertEquals(
                "",
                map.get("issuedBy"),
                issuePlace.getAttribute("value"));

        if(map.get("sex") == "m") Assert.assertTrue(
                "Ошибка!\n Ожидалось: " + map.get("sex"),
                male.isSelected());
        else if (map.get("sex") == "f") Assert.assertTrue(
                "Ошибка!\n Ожидалось: " + map.get("sex"),
                female.isSelected());
    }

    public void checkErrorMsg(){
        click(continueButton);
        Assert.assertEquals(
                "Ошибка!\n" +
                        "Ожидалось: Заполнены не все обязательные поля\n" +
                        "Получено: " + errorMsg.getAttribute("value"),
                "Заполнены не все обязательные поля",
                errorMsg.getText());
    }
}
