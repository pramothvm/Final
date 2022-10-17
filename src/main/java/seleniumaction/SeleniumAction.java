package seleniumaction;

import base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAction extends BaseClass{
    //public WebDriver driver;

    private WebDriver webDriver;
    WebDriverWait wait;

    public Actions act ;
    private static final Logger logger= LogManager.getLogger(SeleniumAction.class);

    public SeleniumAction(WebDriver driver) {
        this.driver = driver;

    }

    public boolean clickElement(WebElement element) {
        try {
            element.click();
            return true;
        }
        catch (Exception Var3){
            logger.error(String.format("element  %s did not become visible with 15s",element.toString()));
            return  false;
        }

    }
    public boolean SwitchToIframe(WebElement element) {
        try {

            wait = new WebDriverWait(driver, 30l);
            wait.until(ExpectedConditions.visibilityOf(element));
            this.driver.switchTo().frame(element);
            return true;
        } catch (Exception Var) {
            logger.error(String.format("element  %s did not become visible with 15s", element.toString()));
            return false;
        }
    }


        public boolean typeText(WebElement element,String text){
        try{
            element.sendKeys(text);
            //new CharSequence[]{text}
            return true;
        }
            catch(Exception var3) {

                logger.error(String.format("text not successfully typed into a field", element.toString()));
                return false;
            }
        }
        public boolean scrollDown(){
        act= new Actions(driver);
            act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
            System.out.println("Scroll down perfomed");
            return false;
        }
    public boolean scrollBy(String x, String y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor)this.driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", new Object[0]);
             return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean WaitFoElementToBeVisible(WebElement element) {
        try {
            wait = new WebDriverWait(driver, 30l);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception var3) {
            logger.error(String.format("element  %s did not become visible with 15s", element.toString()));
            return false;
        }
    }





    public boolean findElementByLinkText(String textName){
        try {
            this.webDriver.findElement(By.linkText(textName));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Failed to find elemement %s", textName));
            return false;

        }
    }

    public boolean findElementByName(String name){
        try {
            this.webDriver.findElement(By.name(name));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Failed to find elemement by name locator  %s", name));
            return false;

        }
    }
    public boolean findElementByXpath(String xPath){
        try {
            this.webDriver.findElement(By.xpath(xPath));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Failed to find elemement %s", xPath));
            return false;

        }
    }

    public boolean findElementByCssSelector(String css){
        try {
            this.webDriver.findElement(By.cssSelector(css));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Failed to find elemement by CssSelector locator %s", css));
            return false;

        }
    }

    public boolean findElementById(String id){
        try {
            this.webDriver.findElement(By.id(id));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Failed to find elemement by id locator %s", id));
            return false;

        }
    }


    public boolean findElementByBy(By by){
        try {
            this.webDriver.findElement(by);
            return true;
        }catch (Exception var3){
            logger.error(String.format("Failed to find elemement by  %s", by.toString()));
            return false;

        }
    }

    public boolean clickElementByXpath(String xPath){
        try {
            WebElement webElement = this.webDriver.findElement(By.xpath(xPath));
            return this.clickElement(webElement);
        }catch (Exception var4){
            logger.error(String.format("Failed to click element   %s",xPath));
            return false;

        }
    }
    public boolean clickElementByID(String id){
        try {
            WebElement webElement = this.webDriver.findElement(By.id(id));
            return this.clickElement(webElement);
        }catch (Exception var4){
            logger.error(String.format("Failed to click element   %s",id));
            return false;

        }
    }


    public boolean clickElementByTagName(String tagName){
        try {
            WebElement webElement = this.webDriver.findElement(By.tagName(tagName));
            return this.clickElement(webElement);
        }catch (Exception var4){
            logger.error(String.format("Failed to click element   %s",tagName));
            return false;

        }
    }


    public boolean clickElementByCssSelector(String css){
        try {
            WebElement webElement = this.webDriver.findElement(By.cssSelector(css));
            return this.clickElement(webElement);
        }catch (Exception var4){
            logger.error(String.format("Failed to click element %s",css));
            return false;

        }
    }

    public boolean clickElementByCssSelector(By by){
        try {
            WebElement webElement = this.webDriver.findElement(by);
            return this.clickElement(webElement);
        }catch (Exception var4){
            logger.error(String.format("Failed to click element %s",by.toString()));
            return false;

        }
    }

    public boolean clickElement(Object element){
        try {
            ((WebElement)element).click();
            return true;
        }catch (Exception var3){
            logger.error(String.format("Element not successfully clicked %s",element.toString()));
            return false;

        }
    }

    public boolean clickWebElementObject(WebElement webElement){
        try {
            return this.clickElement(webElement);

        }catch (Exception var3){
            logger.error(String.format("Failed to click element %s",webElement.getTagName()));
            return false;

        }
    }

    public boolean verifyTextPresent(String textToVerify){
        try {
            return this.webDriver.getPageSource().contains(textToVerify);

        }catch (Exception var3){
            logger.error(String.format("Text %s not present on page - %s",var3.getMessage()));
            return false;

        }
    }

    public boolean waitForElementToBePresent(Object by){
        try {
            WebDriverWait wait = new WebDriverWait(this.webDriver, 15L);
            wait.until(ExpectedConditions.presenceOfElementLocated((By)by));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Element did not become present within 15s %s",by.toString()));
            return false;

        }
    }

//    public boolean waitForElementToHaveText(WebElement webElement){
//        try {
//            (new WebDriverWait(this.webDriver, 12L)).until((d) -> {
//                return webElement.getText().length() != 0;
//            });
//            return true;
//        }catch (Exception var3){
//            logger.error(String.format("Element was not populated with text within 12s %s",webElement));
//            return false;
//
//        }
//    }

    public boolean replaceText(Object element, String  replacementText){
        try {
            String text = ((WebElement)element).getText();
            String newText = text.replaceAll(text, replacementText);
            ((WebElement)element).clear();
            ((WebElement)element).sendKeys(new CharSequence[] {newText});
            return true;

        }catch (Exception var5){
            logger.error(String.format("Text not successfully replaced in element %s",element));
            return false;

        }
    }

    public boolean clearText(Object element){
        try {
            ((WebElement)element).clear();
            return true;

        }catch (Exception var3){
            logger.error(String.format("Text not successfully cleared from element %s",element));
            return false;

        }
    }

    public boolean waitForElementToBeClickable(WebElement webElement){
        try {
            WebDriverWait wait = new WebDriverWait(this.webDriver, 12L);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        }catch (Exception var3){
            logger.error(String.format("Element did not become clickable within 12s %s",webElement));
            return false;

        }
    }





    public boolean typeTextById(String id, String text){
        try {
            WebElement webElement = this.webDriver.findElement(By.id(id));
            webElement.sendKeys(new CharSequence[]{text});
            return true;
        }catch (Exception var4){
            logger.error(String.format("Text in id-located text field not typed in successfully %s",text));
            return false;

        }
    }
    public boolean typeTextByName(String name, String text){
        try {
            WebElement webElement = this.webDriver.findElement(By.name(name));
            webElement.sendKeys(new CharSequence[]{text});
            return true;
        }catch (Exception var4){
            logger.error(String.format("Text in name-located text field not typed in successfully %s",text));
            return false;

        }
    }

    public boolean typeTextByXpath(String xpath, String text){
        try {
            WebElement webElement = this.webDriver.findElement(By.xpath(xpath));
            webElement.sendKeys(new CharSequence[]{text});
            return true;
        }catch (Exception var4){
            logger.error(String.format("Text in xpath-located text field not typed in successfully %s",text));
            return false;

        }
    }
    public boolean typeTextByCssSelector(String css, String text){
        try {
            WebElement webElement = this.webDriver.findElement(By.cssSelector(css));
            webElement.sendKeys(new CharSequence[]{text});
            return true;
        }catch (Exception var4){
            logger.error(String.format("Text in css selector-located field not typed in successfully %s",text));
            return false;

        }
    }

    public boolean typeTextByByBy(By by, String text){
        try {
            WebElement webElement = this.webDriver.findElement(by);
            webElement.sendKeys(new CharSequence[]{text});
            return true;
        }catch (Exception var4){
            logger.error(String.format("Text in css selector-located field not typed in successfully %s",text));
            return false;

        }
    }

    public boolean typeText(Object element, String text){
        try {
            ((WebElement)element).sendKeys(new CharSequence[]{text});

            return true;
        }catch (Exception var4){
            logger.error(String.format("Text not successfully typed into textfield%s",text));
            return false;

        }
    }

    public boolean typeKeys(Object element, Object keys){
        try {
            ((WebElement)element).sendKeys(new CharSequence[]{(Keys)keys});

            return true;
        }catch (Exception var4){
            logger.error(String.format("Keys not successfully pressed into/from textfield %s",keys.toString()));
            return false;

        }
    }

    public boolean scrollUp(){
        try {
            JavascriptExecutor jse = (JavascriptExecutor)this.webDriver;
            jse.executeScript("window.scrollBy(0,-300)", new Object[]{""});
            return true;

        }catch (Exception var2){
            logger.error("Scroll down failed for value");
            return false;

        }
    }




    public boolean maximiseWindow(){
        try {
            this.webDriver.manage().window().maximize();

            return true;

        }catch (Exception var2){
            logger.error("Window was not maximised successfully");
            return false;

        }
    }


//    public boolean switchToWindow(String windowName){
//        try {
//            this.webDriver.switchTo().window(windowName);
//
//            return true;
//
//        }catch (Exception var3){
//            logger.error("Window was switched to successfully %s", windowName);
//            return false;
//
//        }
//    }

    public boolean refresh(){
        try {
            this.webDriver.navigate().refresh();

            return true;

        }catch (Exception var2){
            logger.error("Page not refreshed successfully %s");
            return false;

        }
    }


    public String getPageSource(){
        try {
            return this.webDriver.getPageSource();

        }catch (Exception var2){

            return null;

        }
    }

    public String getPageTitle(){
        try {
            return this.webDriver.getTitle();

        }catch (Exception var2){
            logger.error("Page title not refreshed successfully %s");
            return null;

        }
    }

//    public boolean hoverMouseOverElement(Object element){
//        try {
//            Actions actions = new Actions(this.webDriver);
//            actions.moveToElement((WebElement)element);
//
//            return true;
//
//        }catch (Exception var3){
//            logger.error("Element not howered to/over successfully %s", element);
//            return false;
//
//        }
//    }

//    public boolean hoverMouseOverElement(WebElement element){
//        try {
//            Actions actions = new Actions(this.webDriver);
//            actions.moveToElement(element);
//
//            return true;
//
//        }catch (Exception var3){
//            logger.error("Element not howered to/over successfully %s", element);
//            return false;
//
//        }
//    }

    public boolean hoverMouseOverElement(By by){
        try {
            Actions actions = new Actions(this.webDriver);
            actions.moveToElement(this.webDriver.findElement(by));

            return true;

        }catch (Exception var3){
            logger.error(String.format("Element located with By object not howered to/over successfully %s", by.toString()));
            return false;

        }
    }

    public boolean isElementDisplayed(Object element){
        try {
            return ((WebElement)element).isDisplayed();

        }catch (Exception var3){
            logger.error(String.format("Element % not successfully displayed", element.toString()));
            return false;

        }
    }








}


