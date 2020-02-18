package e2e;

import e2e.SeleniumUtils.LocalStorage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumAPICalls {

    final String url = "https://www.alimerkaonline.es/ali-web/index.html";

    WebDriver driver;

    @Test
    void loadChartFirts() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        final LocalStorage localStorage = new LocalStorage(driver);

        driver.get(url);
        localStorage.setItemInLocalStorage("__amplify__cliente", "{\"data\":{\"id_cliente\":0,\"fechanacimiento\":null,\"cphabitual\":\"33008\",\"sexo\":0,\"iauthtoken\":\"d4dd0d98637b34c87b6e00907b447805dc77927d\",\"nombreCompleto\":\" \",\"carritoCompra\":{\"cesta\":{\"idCesta\":1495996,\"idTipoCesta\":1,\"nombre\":\"Cesta de la compra\",\"fcreacion\":1569786088000,\"articulos\":[],\"subtotal\":\"0,00\",\"total\":\"0,00\",\"descuento\":\"0,00\",\"recargoequivalencia\":0,\"detalledescuento\":[],\"numeroActualizacionCesta\":1,\"numeroProductos\":0}}},\"expires\":null}");
        driver.get(url);
        assertTrue(driver.findElement(By.id("btn-mi-carrito")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
