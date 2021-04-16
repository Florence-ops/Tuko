package Pages;

import PageObject.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjects {

    @FindBy(xpath = "/html/body/header/div[2]/nav/a[5]")
    private WebElement sports;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/section/section/div[1]/article[1]/a[2]")
    private WebElement newsArticle;

    @FindBy(id = "onesignal-slidedown-cancel-button")
    private  WebElement cancel;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/section/section/div/div/a[1]")
    private WebElement fbIcon;

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "loginbutton")
    private WebElement loginBtn;

    @FindBy(name = "xhpc_message_text")
    private WebElement saySomething;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/section/section/div[1]/article[1]/a[2]")
    private WebElement getImg;

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/section/section/div[1]/article[1]/a[2]")
    private WebElement getfbImage;




    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSports(){

        this.sports.click();

    }


    public void clickNews(){

        // this.newsArticle.click();

        WebElement nts = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/section/section/div[1]/article[1]/a[2]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",nts);

    }


    public void clickFacebookIcon(){

        //this.fbIcon.click();

        WebElement nts = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/section/section/div/div/a[1]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",nts);
    }


    public void loginToFacebook(){

        // new tab

        String ParentWindowHandle = driver.getWindowHandle();
        for(String childTab:driver.getWindowHandles()){

            driver.switchTo().window(childTab);
        }

        System.out.println(driver.getTitle());


        this.username.sendKeys("njeradine@gmail.com");
        this.password.sendKeys("puckerman");


        WebElement nts = driver.findElement(By.id("loginbutton"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",nts);



    }

    public void comment(){

        this.saySomething.sendKeys("Interesting read");

        //u_0_27_oR


        // this.saySomething.click();
        System.out.println("test test");

        WebElement nt = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div[2]/table/tbody/tr/td/button[2]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",nt);




    }

}
