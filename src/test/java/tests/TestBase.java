package tests;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.Creds;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class TestBase {

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
        Configuration.startMaximized = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        //fof remote run autotest
        Configuration.remote = "https://" +
                Creds.myCredsFactory.login() + ":" + Creds.myCredsFactory.password() +
                                                            "@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    public void tearDown() {
        String sessionId = getSessionId();

        Attach.screenshotAs("ScreenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        closeWebDriver();

        Attach.addVideo(sessionId);
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }
}