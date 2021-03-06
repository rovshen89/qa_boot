package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitClass {
    static WebDriver driver;
    static String baseURL;

    @BeforeAll
    public static void setUp(){
        baseURL = "https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("@BeforeAll - executed once before ALL test methods in this class");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("@AfterAll - executed once before ALL test methods in this class");
    }

    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach - executed once before EVERY test methods in this class");
    }

    @AfterEach
    public void done(){
        System.out.println("@AfterEach - executed once after EVERY test methods in this class");
    }

    @Test
    public void test1(){
        System.out.println("@Test1 - executed test");
    }
    @Test
    public void test2(){
        System.out.println("@Test2 - executed test");
    }

    @Test
    public void test3(){
        System.out.println("@Test3 - executed test");
    }
}
