package junitTests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class JunitTests {


    @RegisterExtension
    public String text = "";

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before class input");

    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After class input");

    }

    @BeforeEach
    public void before () {
        System.out.println("Before test");
    }

    @AfterEach
    public void after () {
        System.out.println("After test");
    }

    @Test
    public void test() {
        System.out.println("test");

    }

}

