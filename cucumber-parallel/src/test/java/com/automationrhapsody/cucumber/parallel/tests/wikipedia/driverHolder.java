package com.automationrhapsody.cucumber.parallel.tests.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class driverHolder {
    private static WebDriver instance = null;

    public static void setInstance(WebDriver instance) {
        driverHolder.instance = instance;
    }

    public static synchronized WebDriver getInstance() {
        try {
            if (instance == null) {
                instance = WebdriverConfig.webDriver("Chrome");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    public static synchronized void restart() {
        try {
            if (instance != null) {
                instance.close();
                instance =  WebdriverConfig.webDriver("Chrome");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
