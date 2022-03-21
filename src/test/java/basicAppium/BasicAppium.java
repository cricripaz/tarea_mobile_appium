package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppium {

    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","sdk_gphone_x86");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApplication(){
      //  appiumDriver.quit();
    }

    @Test
    public void verifyTask() throws InterruptedException {

        String title = "Task 1";
        String text = "aoqwboviqwhvw qwuvbqwiovbwq";

        //click 2 com.android.calculator2:id/digit_2
        appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.vrproductiveapps.whendo:id/fab']")).click();


        appiumDriver.findElement(By.xpath("//android.widget.EditText[@text='Title']")).sendKeys(title);
        appiumDriver.findElement(By.xpath("//android.widget.EditText[@text='Notes']")).sendKeys(text);

        appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/saveItem']")).click();

        String expectedResult = title;
        String actualResult = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text']")).getText();
//
//

        Assertions.assertEquals(expectedResult,actualResult,"ERROR");

        
//
//        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta");

    }
}
