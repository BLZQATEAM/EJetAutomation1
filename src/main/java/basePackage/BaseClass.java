package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public Properties prop;

    public BaseClass() throws IOException {


            prop = new Properties();
            FileInputStream ip;
            ip = new FileInputStream(
                    "src/main/java/config/Webinar.properties");
            prop.load(ip);
    }

    public void initialization() {
        driver = WebDriverManager.chromedriver().create();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
