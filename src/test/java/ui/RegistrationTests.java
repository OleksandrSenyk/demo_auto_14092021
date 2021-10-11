package ui.registrationTests;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public MainPage mainPage;
    public ui.pages.InputPage inputPage;
    public Faker faker = new Faker();


    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        mainPage = new MainPage(webDriver);
        inputPage = new ui.pages.InputPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();

    }

    private final String TEXT1 = "safest cities";
    private final String TEXT2 = "boxing";
    private final String EMAIL = faker.internet().emailAddress();
    private final String PASSWORD = "asdasd34534s";
    private final String PASSWORD2 = "ddd";


    @Test
    public void testPositive1() {
        mainPage.openUrl("https://www.bbc.co.uk/learningenglish/");
        inputPage.openSearchLink(TEXT1);
        inputPage.clickSearchButton();
        inputPage.openArticleVienne();
        Assert.assertEquals("Vienna ranked as most liveable city in the world",
                inputPage.checkTitle());
    }

    @Test
    public void testPositive2() {
        mainPage.openUrl("https://www.bbc.co.uk/learningenglish/");
        inputPage.openSearchLink(TEXT2);
        inputPage.clickSearchButton();
        inputPage.clickArticleBoxing();
        Assert.assertEquals("Fight Talk: Tyson Fury beats Deontay Wilder in stunning bout - how the boxing world reacted",
                inputPage.checkBoxingTitle());
    }

    @Test
    public void testNegative1() {
        mainPage.openUrl("https://www.bbc.co.uk/learningenglish/");
        inputPage.clickSignInLink();
        inputPage.inputEmail(EMAIL);
        inputPage.inputPassword(PASSWORD);
        inputPage.clickSubmitButton();
        Assert.assertEquals("Sorry, we can’t find an account with that email. You can register for a new account or get help here.",
                inputPage.checkErrorTitle());
    }

    @Test
    public void testNegative2() {
        mainPage.openUrl("https://www.bbc.co.uk/learningenglish/");
        inputPage.clickSignInLink();
        inputPage.inputEmail(EMAIL);
        inputPage.inputPassword(PASSWORD2);
        inputPage.clickSubmitButton();
        Assert.assertEquals("It needs to be eight characters or more.",
                inputPage.checkPasswError());
    }


}



