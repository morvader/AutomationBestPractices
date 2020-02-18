package e2e;

import e2e.SeleniumUtils.BaseSeleniumTest;
import e2e.SeleniumUtils.LocalStorage;
import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.restassured.http.Cookies;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumAPICalls extends BaseSeleniumTest {

    final String authorListUrl = "https://thepulper.herokuapp.com/apps/pulp/gui/reports/authors/list/navigation";

    final String createAuthorUrl = "https://thepulper.herokuapp.com/apps/pulp/gui/create/author";

    @RegisterExtension
    static SeleniumExtension seleniumExtension = new SeleniumExtension();

    LocalStorage localStorage;

    @Test
    void checkAuthorsList(@Arguments("--headless") ChromeDriver driver) {
        driver.get(authorListUrl);

        //Copy cookie
        Set<Cookie> seleniumCookies = driver.manage().getCookies();
        List restAssuredCookies = new ArrayList();
        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            restAssuredCookies.add(new io.restassured.http.Cookie.Builder(cookie.getName(), cookie.getValue()).build());
        }

        String NewAuthor = "FRAN";

        //Insert new author API
        given()
                .cookies(new Cookies(restAssuredCookies))
                .formParam("name", NewAuthor)
                .post(createAuthorUrl).then().statusCode(200);

        driver.get(authorListUrl);

        //Check new author is presents
        List<WebElement> authorsList = driver.findElementsByCssSelector(".Authors-list-item");
        boolean encontrado = false;
        for (WebElement author : authorsList) {
            encontrado = author.getText().contains(NewAuthor);
            if (encontrado) break;
        }

        assertTrue(encontrado, "No se ha encontrado el autor buscado");

    }
}
