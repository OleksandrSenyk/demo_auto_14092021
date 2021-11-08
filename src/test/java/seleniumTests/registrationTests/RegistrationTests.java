package seleniumTests.registrationTests;

import seleniumTests.baseTest.BaseTest;
import dataProviders.RegistrationPageDataProvider;
import io.qameta.allure.*;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    private final String EMAIL = faker.internet().emailAddress();
    private final String GENDER = "Mr.";
    private final String FIRST_NAME = "Stepan";
    private final String LAST_NAME = "Shevchenko";
    private final String PASSWORD = "qwasf124";
    private final String DAY = "1";
    private final String MONTH = "12";
    private final String YEAR = "1980";
    private final String STREET = "street Boston, 14";
    private final String CITY = "Boston";
    private final String STATE = "New York";
    private final String COUNTRY = "USA";
    private final String POST_CODE = "12345";
    private final String MOBILE_PHONE = "1234567890";



//    @Test
//    public void registrationTests () {
//        mainPage.openUrl("http://automationpractice.com/");
//        signInPage.clickSignIn();
//        signInPage.inputEmailCreate(EMAIL);
//        signInPage.submitButtonCreate();
//        registrationPage.selectGender(GENDER);
//        registrationPage.inputCustomerFN(FIRST_NAME);
//        registrationPage.inputCustomerLN(LAST_NAME);
//        registrationPage.inputEmail(EMAIL);
//        registrationPage.inputPassword(PASSWORD);
//        registrationPage.selectBirthDay(DAY);
//        registrationPage.selectBirthMonth(MONTH);
//        registrationPage.selectBirthYear(YEAR);
//        registrationPage.inputFirstName(FIRST_NAME);
//        registrationPage.inputLastName(LAST_NAME);
//        registrationPage.inputStreet(STREET);
//        registrationPage.inputCity(CITY);
//        registrationPage.selectState(STATE);
//        registrationPage.selectCountry(COUNTRY);
//        registrationPage.inputPostcode(POST_CODE);
//        registrationPage.inputMobilePhone(MOBILE_PHONE);
//        registrationPage.inputAlias(EMAIL);
//        registrationPage.clickSubmitAccount();
//        Assert.assertEquals("MY ACCOUNT",
//                myAccountPage.checkTitle());
//        myAccountPage.checkTitle(myAccountPage.titleRegisteredAccount.isDisplayed(), true);
//
//
//    }

    @Test
    public void registrationTest2() {
        mainPage.openUrl("http://automationpractice.com/");
        signInPage
                .clickSignIn()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate();
        registration2Page
                .selectGender(GENDER)
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .selectBirthDay(DAY);
                registration2Page.selectBirthMonth(MONTH);
                registration2Page.selectBirthYear(YEAR);
                registration2Page.inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputStreet(STREET)
                .inputCity(CITY)
                .selectState(STATE)
                .selectCountry(COUNTRY)
                .inputPostcode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccountPage.checkTitle());


    }

    @Epic(value= "Registration")
    @Story(value= "User can registration for this test")
    @Description(value = "Test registration new user account")
    @Issue("GS-213")
    @TmsLink(value = "TL-2134")
    @Link(value = "link", url = "url")
    @Owner(value= "Stepan")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        mainPage.openUrl("http://automationpractice.com/");
        signInPage
                .clickSignIn()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate();
        registration2Page.registrationNewUser(userAccount).clickSubmitAccount();
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());

    }

}
