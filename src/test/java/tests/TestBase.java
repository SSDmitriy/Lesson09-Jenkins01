package tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    //static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        /Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }



}