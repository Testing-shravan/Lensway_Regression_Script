package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    public static final Logger Log=Logger.getLogger(HomePage.class.getName());

    public WebDriver driver;


    //Page Factory

    @FindBy(xpath="//span[text()='Logga in']")
    private WebElement signin;

    @FindBy(xpath="//input[@name='j_username']")
    private WebElement username;

    @FindBy(xpath="//input[@name='j_password']")
    private WebElement password;

    @FindBy(xpath="//input[@value='Logga in']")
    private WebElement login;

    @FindBy(xpath="//path[contains@class='stVCJ99']")
    private WebElement lenswayimage;

    @FindBy(xpath="//input[@value='Återställ lösenord']")
    private WebElement forgotpwd;

    @FindBy(partialLinkText="Registrera dig här")
    private WebElement regbtn;

    @FindBy(xpath="//input[@name='email']")
    private List<WebElement> regemail;

    @FindBy(name="email-repeat")
    private WebElement regrepemail;

    @FindBy(xpath="//input[@name='j_password']")
    private List<WebElement> regpwd;

    @FindBy(name="i_agree")
    private WebElement agreechk;

    @FindBy(xpath="//input[@value='Registrera konto']")
    private WebElement register;

    @FindBy(xpath="//span[text()='Inloggad']")
    private WebElement regsuccess;

    @FindBy(linkText="Logga ut")
    private WebElement logout;


    public HomePage(WebDriver driver)
    {
        this.driver=driver;  // driver needs to be initialized
        PageFactory.initElements(driver, this);

    }

    public void login_Lensway(String uname,String pwd)
    {
        signin=driver.findElement(By.xpath("//span[text()='Logga in']"));
        Actions action= new Actions(driver);
        action.moveToElement(signin).build().perform();
        Log.info("Mousehovered to login button = " +signin.toString());

        username.sendKeys(uname);
        Log.info("Entered the username = " +username.toString());
        password.sendKeys(pwd);
        Log.info("Entered the password = " +password.toString());
        login.click();
        Log.info("Clicked login button = " +login.toString());
    }

    public void registration_Lensway()
    {
        Actions action= new Actions(driver);
        action.moveToElement(signin).build().perform();
        Log.info("Mousehovered to login button = " +signin.toString());

        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Registrera dig här")));
        regbtn.click();
        Log.info("Clicked register button = " +regbtn.toString());


        List<WebElement> list=regemail;
        int var_ele_size= regemail.size();
        regemail.get(var_ele_size-1).click();
        regemail.get(var_ele_size-1).sendKeys("Test32@gmail.com");
        Log.info("Entered email to register = " +regemail.toString());
        regrepemail.sendKeys("Test32@gmail.com");
        Log.info("Rentered email to register = " +regrepemail.toString());

        List<WebElement> list1=regpwd;
        int var_ele_size1= regpwd.size();
        regpwd.get(var_ele_size-1).click();
        regpwd.get(var_ele_size-1).sendKeys("Test@1234");
        Log.info("Entered password to register = " +password.toString());

        agreechk.click();
        Log.info("Checked agree to register = " +agreechk.toString());
        register.click();
        Log.info("clicked the register button = " +regbtn.toString());
        logout.click();
        Log.info("clicked the logout button = " +regbtn.toString());
    }



    public boolean registrationSuccess()
    {
        try{
            regsuccess.isDisplayed();
            return true;
        }   catch (Exception e){
            return false;
        }
    }
}
