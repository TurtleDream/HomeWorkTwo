import library.BaseTest;
import org.junit.Test;
import pages.SberbankInsurancePage;
import pages.SberbankPersonPage;
import pages.TravelsAndPurchasesPage;
import java.util.HashMap;
import java.util.Map;

public class HomeWorkTest extends BaseTest {

    @Test
    public void signUp() {
        SberbankPersonPage sberbankPersonPage = new SberbankPersonPage(BaseTest.webDriver);
        TravelsAndPurchasesPage travelsAndPurchasesPage = new TravelsAndPurchasesPage(BaseTest.webDriver);
        SberbankInsurancePage sberbankInsurancePage = new SberbankInsurancePage(BaseTest.webDriver);
        Map<String, String> personalInfo = new HashMap<String, String>();
        personalInfo.put("engFirstName", "Petr");
        personalInfo.put("engLastName", "Petrov");
        personalInfo.put("dateOfBirth", "12041995");
        personalInfo.put("firstName", "Сидр");
        personalInfo.put("lastName", "Сидоров");
        personalInfo.put("middleName", "Сидорович");
        personalInfo.put("dateOfBirthS", "11051993");
        personalInfo.put("sex", "m");
        personalInfo.put("passportSeries", "4815");
        personalInfo.put("passportNumber", "162342");
        personalInfo.put("dateOfIssue", "15012013");
        personalInfo.put("issuedBy", "Puten");

        sberbankPersonPage.goToPage();
        sberbankPersonPage.goToTravelsAndPurchases();

        travelsAndPurchasesPage.checkPageForText("Страхование путешественников");
        travelsAndPurchasesPage.clickMakeOnlineButton();

        sberbankInsurancePage.policySelection();
        sberbankInsurancePage.formFilling(personalInfo);
        sberbankInsurancePage.checkFilling(personalInfo);
        sberbankInsurancePage.checkErrorMsg();
    }
}
