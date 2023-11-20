import Pages.BasePage;
import Pages.SimpleFormPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleFormTests extends BasePage {

    private SimpleFormPage simpleFormPage;

    private final By simpleFormDemoLink = By.linkText("Simple Form Demo");

    @BeforeMethod
    public void setUp() {
        super.setUp();
        simpleFormPage = new SimpleFormPage(driver);

    }

    @Test
    public void enterMessageAndClickGetCheckedValue() {
        driver.findElement(simpleFormDemoLink).click();
        simpleFormPage.enterTextInTextField("Test");
        simpleFormPage.clickOnGetValueButton();

        String actualResult = driver.findElement(By.id("message")).getText();
        {
            Assert.assertTrue(actualResult.contains("Test"));
            driver.manage().window().maximize();
        }
    }


    @AfterMethod /*olosim @AfterMethod daca vrem sa inchidem browserul dupa fiecare test case in parte*/
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



