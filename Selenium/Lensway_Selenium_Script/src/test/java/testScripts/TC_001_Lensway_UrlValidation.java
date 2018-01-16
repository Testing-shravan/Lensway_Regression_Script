package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import testBase.TestBase;

public class TC_001_Lensway_UrlValidation extends TestBase{



    public void setuUp()
    {

        init();

    }


    public void endTest()
    {
    driver.close();
    }
}
