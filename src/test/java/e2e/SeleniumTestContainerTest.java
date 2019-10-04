package e2e;

import e2e.SeleniumUtils.BaseSeleniumTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class SeleniumTestContainerTest extends BaseSeleniumTest {

    @Container
    private BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions());

    @Test
    void TestContainerTest() {
        RemoteWebDriver driver = chrome.getWebDriver();
        RunSeleniumTest(driver);
    }
    @Test
    void TestContainerTest2() {
        RemoteWebDriver driver = chrome.getWebDriver();
        RunSeleniumTest(driver);
    }
}
