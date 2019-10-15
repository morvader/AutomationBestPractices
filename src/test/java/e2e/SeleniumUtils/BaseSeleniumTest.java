package e2e.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSeleniumTest {
    private final String url = "https://duckduckgo.com/";
    private final String searchFromHomeId = "search_form_input_homepage";
    private final String firstResultLinkByCss = "#r1-0 a";

    final String expectedSeleniumUrl = "seleniumhq.org/";
    final String expectedTittle = "Selenium - Web Browser Automation";

    protected void RunSeleniumTest(WebDriver driver) {
        driver.get(url);
        driver.findElement(By.id(searchFromHomeId)).sendKeys("SeleniumHQ");
        driver.findElement(By.id(searchFromHomeId)).sendKeys(Keys.RETURN);
        final String firstLink = driver.findElement(By.cssSelector(firstResultLinkByCss)).getAttribute("href");

        assertThat(firstLink, endsWith(expectedSeleniumUrl));

        driver.findElement(By.cssSelector(firstResultLinkByCss)).click();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains(expectedTittle));
        String tituloActual = driver.getTitle();
        assertEquals(tituloActual, expectedTittle);

    }
}
