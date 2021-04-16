package Tests;

import Pages.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tests {

    private static final WebDriver driver = new ChromeDriver();


    @BeforeSuite
    public static void main(String[]args){

        System.setProperty("webdriver.chrome.driver","Utils.CHROME_DRIVER_LOCATION") ;

    }

    @Test(testName = "Tuko Automation")
    public static void load() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.tuko.co.ke/408263-mikel-arteta-pin-points-decision-cost-arsenal-win-slavia-prague.html");




        HomePage hp = new HomePage(driver);
        hp.clickSports();
        Thread.sleep(9000);
        hp.clickNews();
        Thread.sleep(8000);
        hp.clickFacebookIcon();
        Thread.sleep(5000);

        hp.loginToFacebook();
        Thread.sleep(10000);

        hp.comment();
        Thread.sleep(15000);


        String ACTUAL_TITLE = driver.getTitle();
        String EXPECTED_TITLE = driver.getTitle();

        Assert.assertEquals(ACTUAL_TITLE,EXPECTED_TITLE);


    }

    @AfterSuite
    public  static void tearDown(){

        Date d = new Date();
        System.out.println(d.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("D:\\Screenshots\\"+sdf.format(d)+".png"));
        } catch (IOException e) {

            e.printStackTrace();

        }


        driver.manage().deleteAllCookies();
        driver.close();
    }

}
