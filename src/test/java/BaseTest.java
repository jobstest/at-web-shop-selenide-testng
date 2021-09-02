import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BaseRouter;
import utils.TestConfig;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {

    public static TestConfig testConfig = new TestConfig();
    public BaseRouter baseRouter = new BaseRouter();

    @BeforeMethod
    protected void openSite(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Configuration.browserSize = "1920x1070";
        closeWebDriver();
        open(testConfig.getSiteUrl());
    }

    @AfterMethod
    protected void closeSite(){
        closeWebDriver();
    }

}
