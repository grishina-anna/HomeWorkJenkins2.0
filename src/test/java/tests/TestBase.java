package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub1");
        String login = System.getProperty("login", "user11");
        String pass = System.getProperty("pass", "12341");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = browser;
        Configuration.browserVersion = version;

   //     Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        String url = "https://" + login + ":" + pass + "@" + remoteUrl;

        Configuration.remote = url;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Version: ", version);
        Attach.attachAsText("Remote Url: ", remoteUrl);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @AfterAll
    static void AfterAll() {
        Selenide.closeWebDriver();
    }
}


