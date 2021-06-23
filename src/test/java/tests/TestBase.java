package tests;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    //static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
        Configuration.startMaximized = true;
        //fof remote run autotest
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("ScreenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        closeWebDriver();
    }

}