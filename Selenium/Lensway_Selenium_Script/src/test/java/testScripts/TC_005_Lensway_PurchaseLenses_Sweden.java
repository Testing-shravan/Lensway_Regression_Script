package testScripts;

import lenswayPages.HomePage;
import lenswayPages.LensPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.TestBase;



public class TC_005_Lensway_PurchaseLenses_Sweden extends TestBase {


    @BeforeClass

    public void setUp()
    {
        init();

    }

    @Test

    public void lensValidation()   {
        log.info("#######################Starting test to LensValidation#####################################");
         homePage=new HomePage(driver);
        lensPage=new LensPage(driver);
        homePage.login_Lensway("Testuat@lenswaygroup.com", "Test@1231");
        lensPage.LensProduct();

        log.info("#######################Finished test to LensValidation#####################################");

    }

    @AfterClass

   public void endTest()
   {
       driver.close();

   }

}

