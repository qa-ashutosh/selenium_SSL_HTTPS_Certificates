package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_HTTPS_Certificates {
    public static void main(String[] args) {

        // Desired capabilities are general chrome profiles
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

        // First way of accepting certificates..
        //desiredCapabilities.acceptInsecureCerts();

        // Second way of accepting certificates..
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // These belongs to local browser, now we are merging desired capabilities to chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);

        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("website url containing HTTPS/SSL certificates");
    }
}
