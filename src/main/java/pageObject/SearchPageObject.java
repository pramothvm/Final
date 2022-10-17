package pageObject;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumaction.SeleniumAction;
import seleniumadaptor.SeleniumAdaptor;

import java.util.List;

public class SearchPageObject extends BaseClass {
    public SearchPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    SeleniumAction seleniumAction= new SeleniumAction(driver);

    SeleniumAdaptor seleniumAdaptor= new SeleniumAdaptor(driver);
@FindBy(name="search")
    private WebElement txtsearch;
    @FindBy(xpath="(//button[text()='Add to Cart'])[1]")
    private WebElement productnamebtn;

    public void Seach(String name){

        txtsearch.sendKeys(name);
        txtsearch.sendKeys(Keys.ENTER);

    }

    public void clickProduct(){

        List <WebElement> applience= driver.findElements(By.xpath("//a[@class='product-anchor sponsored product-card-module_product-anchor_TUCBV']"));
        for(int x = 0; x == applience.size(); x++)


            productnamebtn.click();
    }

    public void ClickButton(){
        //seleniumAction.click(productnamebtn);

    }
    }





