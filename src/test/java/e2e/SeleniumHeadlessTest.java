package e2e;


import e2e.SeleniumUtils.BaseSeleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SeleniumHeadlessTest extends BaseSeleniumTest {


    @BeforeAll
    public  static  void setUp() {
        WebDriverManager.chromedriver().setup();
    }


    @Test()
    @RepeatedTest(5)
    void seleniumTest_Headless() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("window-sized1200,600");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        RunSeleniumTest(driver);

        driver.quit();

    }

    @Test
    @RepeatedTest(5)
    void seleniumTest_NoHeadless() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        RunSeleniumTest(driver);

        driver.quit();
    }

}
