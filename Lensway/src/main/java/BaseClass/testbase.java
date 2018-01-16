package BaseClass;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class testbase {
    public WebDriver driver;
    public static ExtentReports extentreportval;
    public static ExtentTest  testextent;
    int waitvalue=90;
/*
static{
 Calendar cal=Calendar.getInstance();
 SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

}*/

    public void getreport(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            testextent.log(LogStatus.PASS, result.getName()+"test is pass");
        }else if (result.getStatus()==ITestResult.SKIP){
            testextent.log(LogStatus.SKIP, result.getName()+"test is skip"+result.getThrowable());
        }else if(result.getStatus()==ITestResult.FAILURE){
            testextent.log(LogStatus.ERROR, result.getName()+"test is failed"+result.getThrowable());
        }else if (result.getStatus()==ITestResult.STARTED){
            testextent.log(LogStatus.INFO, result.getName()+"test is started");
        }
    }

    @AfterMethod()
    public void aftermethod(ITestResult result){
        getreport(result);
    }

    @BeforeMethod()
    public void beforemethod(Method result){
        testextent=extentreportval.startTest(result.getName());
        testextent.log(LogStatus.INFO, result.getName()+"test started");

    }

    @AfterClass(alwaysRun=true)
    public void endtest(){
        extentreportval.endTest(testextent);
        extentreportval.flush();
    }


    public  void Browserinit( String browserName,String url){
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        extentreportval=new ExtentReports(System.getProperty("user.dir")+"/src/com.altoromutual.TestReport/test.html",false);
        if (browserName.equalsIgnoreCase("firefox"))
        {
            driver= new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\kavitha\\Downloads\\chromedriver_win32(3)\\chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if (browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver","D:\\Selenium-Artifacts\\Selenium Softwares\\IEDriverServer.exe");
            driver= new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        driver.manage().window().maximize();
        driver.get(url);
    }


    public void explicitwait(int waitvalue,WebElement webelementval){
        WebDriverWait wt= new WebDriverWait(driver,waitvalue);
        wt.until(ExpectedConditions.visibilityOf(webelementval));
    }




}

