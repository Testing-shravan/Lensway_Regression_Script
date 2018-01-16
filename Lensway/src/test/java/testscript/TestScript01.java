package testscript;

import BaseClass.TestBase1;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.IOException;

public class TestScript01 extends TestBase1{

    HomePage homePage;


    @BeforeClass

    public void init() throws IOException {

        setUp();

    }


public void loginTest()
{

    homePage=new HomePage(driver);
    homePage.login_Lensway();
}




}
