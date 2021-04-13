package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {



    //instance of webdriver
    protected WebDriver driver;

    //constructor for pageobject
    public PageObjects(WebDriver driver){
        this.driver = driver;

        //init elements
        PageFactory.initElements(driver,this);

    }

}
