package base;


//import org.apache.log4j.Logger;

//import io.cucumber.core.api.Scenario;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import seleniumaction.SeleniumAction;
import seleniumadaptor.SeleniumAdaptor;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.google.common.io.Files.copy;


public class BaseClass {

    String broserName="Edge";
    public SeleniumAction seleniumAction;

    public SeleniumAdaptor seleniumAdaptor;
    public static   WebDriver driver;
//    public static  WebDriver drivers;
    String webDriverlocationpath=  System.getProperty("user.dir")+File.separator +"src"+ File.separator+"test"+File.separator+"resources"+File.separator+"webdriver";

    public   BaseClass(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seleniumAction= new SeleniumAction(driver);
        seleniumAdaptor= new SeleniumAdaptor(driver);

    }

    public BaseClass() {
    }

    public WebDriver openBrowser(String url) throws Exception {

        if(broserName.equalsIgnoreCase("chrome")){
         System.setProperty("webdriver.chrome.driver",webDriverlocationpath+"\\chromedriver.exe");
            driver = new ChromeDriver();
               }
        else if(broserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.firefox.marionette", webDriverlocationpath+ "\\geckodriver.exe");
            driver =new FirefoxDriver();
        }
        else if(broserName.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver",webDriverlocationpath+"\\msedgedriver.exe");
            //create Edge instance
            driver =new EdgeDriver();
       }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");}
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000l, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
    public static String generateRandomString(int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        return sb.toString();
    }
    public static void takeScreenShot(Scenario scenario) {
        try {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String time = java.time.LocalTime.now().toString();
            String [] timeStr = time.split(":");
            String x = timeStr[0]+""+timeStr[1]+""+timeStr[2];
            String screenshotName = x.substring(0,8);
//            File destinationPath = new File("\\PriscillaAssesment\\target" + screenshotName +"_"+ generateRandomString(5) + ".png");
            File destinationPath = new File("C:\\Reg\\Screenshots/screenshot" + screenshotName +"_"+ generateRandomString(5) + ".png");
            copy(sourcePath, destinationPath);
            Reporter.addScreenCaptureFromPath(destinationPath.toString());
        }
        catch (Exception e) {
            System.out.println("Unable to take screenshot");
            System.out.println(e);

        }
    }
}


