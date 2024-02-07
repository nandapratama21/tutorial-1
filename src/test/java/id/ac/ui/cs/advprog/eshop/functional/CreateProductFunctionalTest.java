package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void CreateProduct_isCorrect(ChromeDriver driver) throws Exception {
        // Create Product
        driver.get(baseUrl + "/product/create");

        driver.findElement(By.id("nameInput")).sendKeys("Sampo Pak Bango");
        driver.findElement(By.id("quantityInput")).sendKeys("500");
        driver.findElement(By.linkText("Create Product")).click(); // Submit form

        driver.get(baseUrl + "/product/list");

        // Verify isCorrect
        WebElement productList = driver.findElement(By.tagName("body"));
        assertTrue(productList.getText().contains("Sampo Pak Bango"));
        assertTrue(productList.getText().contains("500"));



    }

}