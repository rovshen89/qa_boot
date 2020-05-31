package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitSelenium {
    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUp(){
        baseUrl = "https://letskodeit.teachable.com/";
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
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
        driver.navigate().refresh();
        System.out.println("@BeforeEach - executed once before EVERY test methods in this class");
    }

    @AfterEach
    public void done(){
        driver.navigate().refresh();
        System.out.println("@AfterEach - executed once after EVERY test methods in this class");
    }

    @Test
    public void test1(){
        driver.findElement(By.cssSelector("a.navbar-brand.header-logo")).click();
        System.out.println("@Test1 - executed test");
    }

    /*@Test
    public void test2(){
        System.out.println("@Test2 - executed test");
    }

    @Test
    public void test3(){
        System.out.println("@Test3 - executed test");
    }*/
}
