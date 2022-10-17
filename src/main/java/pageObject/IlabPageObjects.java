package pageObject;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class IlabPageObjects extends BaseClass {
WebDriver driver;

	public IlabPageObjects(WebDriver driver)
	{
	super(driver);

	}

	@FindBy(linkText="Career Opportunities")
	private WebElement  careerLnk;

	@FindBy(linkText="South Africa")
	private WebElement SouthAfricaLnk;

	@FindBy(xpath="(//div[@class='et_pb_module et_pb_text et_pb_text_1  et_pb_text_align_left et_pb_bg_layout_light']/div/ul/li/a)[1]")
	private WebElement firstjoblink;
	@FindBy(name="message")
	private WebElement textAreaMsg;

	@FindBy(xpath="//a[text()='Apply Online ']")
	private WebElement aplyBtn;
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement input_name;
	@FindBy(name="email")
	private WebElement input_email;
	@FindBy(name="phone")
	private WebElement input_phone;
	@FindBy(xpath="//textarea[@id='message']")
	private WebElement input_msg;
	@FindBy(xpath="//div[@class='et_pb_module et_pb_text et_pb_text_1  et_pb_text_align_left et_pb_bg_layout_light']/div/ul/li")
	private List <WebElement> JobApplink;
	@FindBy(xpath="/a")
	private WebElement jobslnk;
	@FindBy(css="[value='Submit']")
	private WebElement btn_submit;
	@FindBy(xpath="//iframe[contains(@id,hs-form-iframe-)][1]")
	private WebElement iframe;
	@FindBy(name="lastname")
	private WebElement txtSurName;
	@FindBy(xpath = "//label[@class='hs-main-font-element']")
	private WebElement txtValidation;


	@FindBy(xpath="//ul[@class='wpjb-errors']/parent::div[@class='wpjb-field']/child::div/following-sibling::ul")
	private WebElement txt_validation;


	public  String getCellNumber(){
		int serviceProviderCode = (int)(Math.random() * (99 - 60) + 60);
		int threeDigitsNumber = (int)(Math.random() * (999 - 100) + 100);
		int fouDegitsNumber = (int)(Math.random() * (9999 - 1000) + 1000);
		String forMatedNumber = "0"+serviceProviderCode+" "+threeDigitsNumber+" "+fouDegitsNumber ;
		return forMatedNumber;


	}




	public boolean clickCareeLink() throws InterruptedException{
		if(seleniumAction.WaitFoElementToBeVisible(careerLnk)){
			seleniumAction.clickElement(careerLnk);
			seleniumAdaptor.JavaScriptClick(careerLnk);
		return true;
		}
		return  false;
			}

	public boolean clickSouthAfrica() throws InterruptedException{
		if(seleniumAction.WaitFoElementToBeVisible(SouthAfricaLnk)){
			seleniumAction.clickElement(SouthAfricaLnk);
			return true;
		}
		return  false;
	}



public boolean swichToFrame(){
		seleniumAction.SwitchToIframe(iframe);
		return  true;
}


	public boolean clickFirstJob() throws InterruptedException{
		if(seleniumAction.WaitFoElementToBeVisible(firstjoblink)){
			seleniumAction.clickElement(firstjoblink);
			return true;
		}
		return  false;
	}


	public boolean CaptureName(String name){
		if(seleniumAction.WaitFoElementToBeVisible(input_name)){
		seleniumAction.typeText(input_name,name);
		return true;
		}
		return false;
	}
	public boolean CaptureSurname(String surName){
		if(seleniumAction.WaitFoElementToBeVisible(txtSurName)){
			seleniumAction.typeText(txtSurName,surName);
			return true;
		}
		return false;
	}
	public boolean CaptureMsg(String msg){
		if(seleniumAction.WaitFoElementToBeVisible(textAreaMsg)){
			seleniumAction.typeText(textAreaMsg,msg);
			return true;
		}
		return false;
	}
	public boolean TypeEmail(String email){
		if(seleniumAction.WaitFoElementToBeVisible(input_email)){
			seleniumAction.clickElement(input_email);
			seleniumAction.typeText(input_email,email);
			return true;
		}
		return false;

	}

	public boolean TypeCellNum(){
		if(seleniumAction.WaitFoElementToBeVisible(input_phone)){
			seleniumAction.typeText(input_phone,getCellNumber());
			return true;
		}
		return false;

	}


	public boolean clickAndValidateMsg() throws InterruptedException {

		if(seleniumAction.WaitFoElementToBeVisible(btn_submit)){
			seleniumAction.clickElement(btn_submit);
		    String actualString = txtValidation.getText();
			assertTrue(actualString.contains("Please complete all required fields."));
			return true;
		}
		return false;



	}




}


