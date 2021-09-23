package simpleTests;

import net.bytebuddy.asm.Advice;
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

    @Before
    public void setUp(){
        File fileChromeDriver = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",fileChromeDriver.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://football.ua");

    }

    @After
    public void quit(){
        webDriver.quit();
    }

    @Test
    public void siteTest() {

        webDriver.getCurrentUrl();
        System.out.println(webDriver.getTitle());
        String exTitle = webDriver.findElement(By.xpath("//*[@id='ctl00_columnTop']/div[2]/article/h3")).getText();
        Assert.assertEquals("ГЛАВНОЕ ЗА СУТКИ", exTitle);
        webDriver.findElement(By.xpath("//*[@id='ctl00_menu']/li[15]/a")).click();
        String exTitle1 = webDriver.findElement(By.xpath("//*[@id='ctl00_columnLeft']/article[1]/h3")).getText();
        Assert.assertEquals("ПОСЛЕДНИЕ МАТЧИ", exTitle1);
        webDriver.findElement(By.xpath("//*[@id='aspnetForm']/footer/div/div/nav/div[2]/ul/li[2]/a")).click();
        String exTitle2 = webDriver.findElement(By.xpath("//*[@id='ctl00_columnRight']/article/h1")).getText();
        Assert.assertEquals("ФУТБОЛ В АНГЛИИ: НОВОСТИ",exTitle2);



    }

    @Test
    public void siteTest2(){
        webDriver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("Реал");
        WebElement dynamicElem = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchInput']")));
        System.out.println(dynamicElem.getTagName());
        webDriver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys(Keys.ENTER);
        String exTitleSearch = webDriver.findElement(By.xpath("//*[@id='ctl00_columnTop']/article/div[5]/div[2]/div/h4/a")).getText();
        Assert.assertEquals("Реал Мадрид",exTitleSearch);

    }



}
