package mvp.cc.testing.CCTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by asalonga on 22/08/2018.
 */
public class Application {
    private final String _baseurl = "http://72.52.222.78:8080/cc/ClaimCenter.do";
//    private final String _baseurl = "http://localhost:8080/cc/ClaimCenter.do";

    private static WebDriver _driver;
    private static Actions _actions;
    private static WebDriverWait _wait;
    private static Logger _logger;

    public Application() {
        BasicConfigurator.configure();
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _driver.get(_baseurl);
        _wait = new WebDriverWait(_driver, 30);

        _actions = new Actions(_driver);
        _logger = LogManager.getLogger(Application.class.getName());
    }

    public WebDriver getDriver(){
        return _driver;
    }
}
