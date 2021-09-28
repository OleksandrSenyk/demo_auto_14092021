package ui.registrationTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public MainPage mainPage;

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
    }

    @After
    public void tearDown () {
        webDriver.quit();

    }

    @Test
    public void registrationTests () {
        mainPage.openUrl("https://finance.i.ua/converter/");
        System.out.println(webDriver.getTitle());
        String exTitle = webDriver.findElement(By.xpath("//*[@id='graph_type_selector']/li[2]/a")).getText();
        Assert.assertEquals("Наличный рынок", exTitle);
        String exTitle1 = webDriver.findElement(By.xpath("//*[@id='type_selector']/li[2]/a")).getText();
        Assert.assertEquals("EUR", exTitle1);
        String exTitle2 = webDriver.findElement(By.xpath("//div[@class='form_item']/ul/li[2]/a")).getText();
        Assert.assertEquals("купить",exTitle2);

    }
}
