package junitTests;

import org.junit.*;

public class junitTests {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class input");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class input");
    }

    @Before
    public void before() {
        System.out.println("Before test");
    }

    @After
    public void after() {
        System.out.println("After test");
    }

    @Test
    public void test() {
        System.out.println("text");
        Assert.assertEquals("text", "text");
    }

    @Test(timeout = 1000)
    public void test2() {
        System.out.println("text2");
        Assert.assertEquals("text", "text");
    }

}
