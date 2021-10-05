package ui.registrationTests;

import com.github.javafaker.Faker;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.MyAccount;
import ui.pages.Registration2Page;
import ui.pages.RegistrationPage;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public MyAccount myAccount;
    public Faker faker = new Faker();


    @Before
    public void setUp () {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccount = new MyAccount(webDriver);
    }

    @After
    public void tearDown () {
        webDriver.quit();

    }

    private final String EMAIL = faker.internet().emailAddress();
    private final String FIRST_NAME = "Stepan";
    private final String LAST_NAME = "Shevchenko";
    private final String PASSWORD = "qwasf124";
    private final String STREET = "streen Boston, 14";
    private final String CITY = "Boston";
    private final int STATE = 30;
    private final String POST_CODE = "12345";
    private final String MOBILE_PHONE = "1234567890";



    @Test
    public void registrationTests () {
        mainPage.openUrl("http://automationpractice.com/");
        registrationPage.openSignInPage();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(EMAIL);
        registrationPage.inputPassword(PASSWORD);
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputStreet(STREET);
        registrationPage.inputCity(CITY);
        registrationPage.selectState(STATE);
        registrationPage.inputPostcode(POST_CODE);
        registrationPage.inputMobilePhone(MOBILE_PHONE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccount.checkTitle());
        myAccount.checkTitle("Title", myAccount.checkTitleTextOnPage("My account - My Store"), true);


    }

    @Test
    public void registrationTest2() {
        mainPage.openUrl("http://automationpractice.com/");
        registration2Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputStreet(STREET)
                .inputCity(CITY)
                .selectState(STATE)
                .inputPostcode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccount.checkTitle());


    }

    @Test
    public void registrationMyTest() {
        mainPage.openUrl("http://automationpractice.com/");
        registrationPage.openSignInPage();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(EMAIL);
        registrationPage.inputPassword(PASSWORD);
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputStreet(STREET);
        registrationPage.inputCity(CITY);
        registrationPage.inputPostcode(POST_CODE);
        registrationPage.inputMobilePhone(MOBILE_PHONE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccount();
        Assert.assertEquals("There is 1 error",
                registrationPage.checkError1());
        Assert.assertEquals("This country requires you to choose a State.",
                registrationPage.checkErrorMessage());


    }


}
