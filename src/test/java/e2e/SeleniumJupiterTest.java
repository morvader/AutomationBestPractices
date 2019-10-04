package e2e;

import e2e.SeleniumUtils.BaseSeleniumTest;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static io.github.bonigarcia.seljup.BrowserType.CHROME;

public class SeleniumJupiterTest extends BaseSeleniumTest {

    @RegisterExtension
    static SeleniumExtension seleniumExtension = new SeleniumExtension();

    @BeforeAll
    static void setup() {
        seleniumExtension.getConfig().setVnc(true);
    }

    @Test
    public void testLocalChrome(ChromeDriver driver) {
        RunSeleniumTest(driver);
    }

    @Test
    public void testChrome(@DockerBrowser(type = CHROME, version = "latest") RemoteWebDriver driver) {
        RunSeleniumTest(driver);
    }
}
