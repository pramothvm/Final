package seleniumadaptor;

import base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumaction.SeleniumAction;

import java.util.ArrayList;
import java.util.List;

public class SeleniumAdaptor extends BaseClass {

//    public WebDriver wdriver;

    WebDriverWait wait;

    public Actions act ;
    private static final Logger logger= LogManager.getLogger(SeleniumAdaptor.class);

    public SeleniumAdaptor(WebDriver driver) {
        this.driver = driver;

    }


    public void DropdownValue (WebElement webElement, String value){
        try {
            Select selct = new Select(webElement);
            selct.selectByVisibleText(value);

        }catch (StaleElementReferenceException var5){
            Select selct = new Select(webElement);
            selct.selectByVisibleText(value);

        }
    }


    public void getDropdownValue (WebElement webElement, int index){
        try {
            Select selct = new Select(webElement);
            selct.selectByIndex(index);

        }catch (StaleElementReferenceException var5){
            Select selct = new Select(webElement);
            selct.selectByIndex(index);

        }
    }


    public WebElement explicitWait(WebElement ele){
    WebDriverWait wait = new WebDriverWait(this.driver, 10L);
       boolean done = false;
       int iLoop = 0;
       byte loop = 20;

       while(!done && iLoop <= loop) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ele));
            done = true;
            } catch (Exception va7){
                ++iLoop;
            }
        }
            return done ? ele : null;
            }


            public void sendKeysAndTryMultiple(WebElement ele, String value, int attempts){

         boolean done = false;
         int iLoop = 0;

         while(!done && iLoop <= attempts) {
            try {
                Thread.sleep(2000L);
                ele.sendKeys(new CharSequence[]{value});
                done = true;
            } catch (Exception va7){
                ++iLoop;
            }
        }

    }


    public void pauseFor(int seconds){
            try {
                Thread.sleep((long)(seconds * 1000));

            } catch (InterruptedException var3){
               var3.printStackTrace();
            }
        }


    public void openNewTabJS(int seconds){
      ((JavascriptExecutor)this.driver).executeScript("window.open('about:blank', '-blank')",new Object[0]);
    }


    public void switchToTab(int tabNum){
       ArrayList<String> tabs = new ArrayList(this.driver.getWindowHandles());
       this.driver.switchTo().window((String)tabs.get(tabNum));
}



    public void switchToFrame(WebElement ele){
    try {
        this.driver.switchTo().frame(ele);

    } catch (Exception var3){
        System.out.println("Not able to locate iframe" +ele);
    }
}


    public void switchTodefaultContent(){ this.driver.switchTo().defaultContent();}

    public WebElement WaitForVisibility(WebElement ele, int waitTime){
        WebDriverWait webDriverWait =  new WebDriverWait(this.driver, (long)waitTime);
      return(WebElement) webDriverWait.until(ExpectedConditions.visibilityOf(ele));
    }


    public List<WebElement> WaitForListVisibility(List<WebElement> listOfWebElements,  int waitTime){
        WebDriverWait webDriverWait =  new WebDriverWait(this.driver, (long)waitTime);
    try {
        return(List) webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfWebElements));

        } catch (Exception var5){
            return null;
        }
    }

    public void JavaScriptClick(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("arguments[0].click();", new Object[]{webElement});
    }

    public WebElement WaitForElementToPresent(WebElement webElement, int seconds){
        WebDriverWait webDriverWait =  new WebDriverWait(this.driver, (long)seconds);
        return(WebElement) webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }


    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("window.scrollBy(0,100);", new Object[]{});
    }

    public void waitUntilElementDisappears(List<WebElement> ele) {
        WebDriverWait wait = new WebDriverWait(this.driver, 150L);
        wait.until(ExpectedConditions.invisibilityOfAllElements(ele));
    }

    public WebElement waitTillClickable(WebElement ele, int waitTime) {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, (long)waitTime);
        return(WebElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void scrollToElement(WebElement ele) {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("arguments[0].scrollIntoView();", new Object[]{ele});
    }

    public void scrollToEndOfPage() {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
    }


   public void clickAndTryMultiple(WebElement ele, int attempts){
    boolean done = false;
    int iLoop = 0;

    while(!done && iLoop<= attempts){
        try {
            Thread.sleep(2000L);
            ele.click();
            done = true;
        } catch (Exception var8){
            ++iLoop;
            if (iLoop == attempts){
                try {
                    this.JavaScriptClick(ele);
                } catch (Exception var7){
                    ;
                }
            }

        }
    }
 }







}
