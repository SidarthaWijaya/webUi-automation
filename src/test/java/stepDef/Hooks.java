package stepDef;

import io.cucumber.java.*;

import java.util.Objects;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {
    String tagsRunning = null;

    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All");
    }

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Before Test");
        startDriver();
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        System.out.println("After Test");
        quitDriver();
    }
}
