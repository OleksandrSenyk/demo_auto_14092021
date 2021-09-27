package simpleTests;

import net.bytebuddy.asm.Advice;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SimpleTests {

    WebDriver webDriver;
    Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",fileChromeDriver.getAbsolutePath());

        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Wait seconds: 10");
        webDriver.get("https://finance.i.ua/converter/");
        logger.info("Browser was opened");

    }

    @After
    public void quit(){
        webDriver.quit();
    }

    @Test
    public void siteTest() {

        webDriver.getCurrentUrl();
        System.out.println(webDriver.getTitle());
        String exTitle = webDriver.findElement(By.xpath("//*[@id='graph_type_selector']/li[2]/a")).getText();
        Assert.assertEquals("Наличный рынок", exTitle);
        String exTitle1 = webDriver.findElement(By.xpath("//*[@id='type_selector']/li[2]/a")).getText();
        Assert.assertEquals("EUR", exTitle1);
        String exTitle2 = webDriver.findElement(By.xpath("//div[@class='form_item']/ul/li[2]/a")).getText();
        Assert.assertEquals("купить",exTitle2);


    }





}
