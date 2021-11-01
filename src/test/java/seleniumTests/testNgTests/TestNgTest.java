package seleniumTests.testNgTests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class input");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class input");
    }

    @BeforeMethod
    public static void before() {
        System.out.println("Before test");
    }

    @AfterMethod
    public static void after() {
        System.out.println("After test");
    }

    @Test(groups = "method 1")
//    @Test(expectedExceptions = ArithmeticException.class)
    public void test1() {
        System.out.println("text");
        Assert.assertEquals("res","res");
    }
}
