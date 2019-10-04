package e2e.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSeleniumTest {
    private final String url = "https://duckduckgo.com/";
    private final String searchFromHomeId = "search_form_input_homepage";
    private final String firstResultLinkByCss = "#r1-0 a";

    final String expectedSeleniumUrl = "https://docs.seleniumhq.org/";
    final String expectedTittle = "Selenium - Web Browser Automation";

    protected void RunSeleniumTest(WebDriver driver) {
        driver.get(url);
        driver.findElement(By.id(searchFromHomeId)).sendKeys("Selenium");
        driver.findElement(By.id(searchFromHomeId)).sendKeys(Keys.RETURN);
        final String firstLink = driver.findElement(By.cssSelector(firstResultLinkByCss)).getAttribute("href");

        assertEquals(expectedSeleniumUrl,firstLink );

        driver.findElement(By.cssSelector(firstResultLinkByCss)).click();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs(expectedTittle));
        String tituloActual = driver.getTitle();
        assertEquals(tituloActual, expectedTittle);

    }
}
