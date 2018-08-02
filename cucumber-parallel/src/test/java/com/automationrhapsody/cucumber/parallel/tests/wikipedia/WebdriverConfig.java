package com.automationrhapsody.cucumber.parallel.tests.wikipedia;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;

public class WebdriverConfig {


    private static final String CHROME = "Chrome";
    private static final String FIREFOX = "Firefox";
    private static final String REMOTE_EDGE = "RemoteEdge";
    private static final String EDGE = "Edge";
    private static final String HTMLUNIT = "htmlUnit";
    private static final String USERNAME = "anton1007";
    private static final String AUTOMATE_KEY = "123";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    private static String browserName = "Chrome";

    public static WebDriver webDriver(String chrome) throws IOException {
        WebDriver res = null;
////            //if (System.getProperty("os.name").toLowerCase().contains("win")) {
////            //local run in process at win-based OS
////            res = initChrome();
////            //} else {
////            //git-lab CI run in process
////            res = initRemoteEdge();
////            //}
//
//        driverHolder.setInstance(res);
        if (chrome.compareTo("Chrome") == 0){
            res=initChrome();
        }else if (chrome.compareTo("Firefox") == 0){
            res=initFirefox();
        }else if(chrome.compareTo("Edge") == 0){
            res=initEdge();
        }

        return res;
    }

    private static WebDriver initFirefox() {
        FirefoxDriverManager.getInstance().arch32().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //return new WrappedWebdriver(driver);
        return (driver);
    }

    private static WebDriver initChrome() {
        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu", "--no-sandbox");
        //chromeOptions.addArguments("--headless");
        capabilities.setCapability(CAPABILITY, chromeOptions);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        return (driver);
    }

    private static WebDriver initEdge() {
        EdgeDriverManager.getInstance().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return (driver);
    }

//        private static WebDriver initRemoteEdge() {
//            BrowserStackLocal.startInstance(AUTOMATE_KEY);
//
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("os", "WINDOWS");
//            caps.setCapability("os_version", "10");
//            caps.setCapability("browser", "edge");
//            caps.setCapability("browser_version", "16.0");
//            caps.setCapability("resolution", "1600x1200");
//            caps.setCapability("browserstack.debug", "true");
//            caps.setCapability("browserstack.local", "true");
//            //caps.setCapability("browserstack.forceLocal", "true");
//            caps.setCapability("browserstack.networkLogs", "true");
//            caps.setCapability("build", "First build");
//            WebDriver driver = null;
//            try {
//                driver = new RemoteWebDriver(new URL(URL), caps);
//                driver.manage().window().maximize();
//            }catch(Exception e){
//                e.printStackTrace();
//                System.out.println("*** Failed to init remote BrowserStack driver! ***");
//            }
//            return (driver);
//        }

}

