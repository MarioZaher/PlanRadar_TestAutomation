import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_POM
{

    WebDriver driver;

    LoginPage_POM(WebDriver driver)
    {
        this.driver = driver;

    }


    public void OpenBrowser() throws InterruptedException
    {
        //Navigate to PlanRadar
         driver.navigate().to("https://www.planradar.com/");

        // maximize the window and wait a time
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Click on accept all cookies
        driver.findElement(By.xpath("//button[@title='Accept all cookies']")).click();
        Thread.sleep(1000);

        // Click on login Button
        driver.findElement(By.xpath("//li[@id='menu-item-26230']")).click();
        Thread.sleep(1000);
    }
    //Handle UserName & Password Field Locators
    private WebElement UserNamePOM(WebDriver Driver) throws InterruptedException {
        Thread.sleep(1000);
        By username = By.xpath("//input[@name='email']");
        return Driver.findElement(username);

    }
    private WebElement PasswordOM(WebDriver Driver) throws InterruptedException {
        Thread.sleep(1000);
        By password = By.xpath("//input[@name='password']");
        return Driver.findElement(password);
    }

    // Private Method for Enter UserName & Password
    public void Enter_UserName_And_Password(String UserName, String PassWord) throws InterruptedException
    {
        UserNamePOM(driver).sendKeys(UserName);
        UserNamePOM(driver).sendKeys(Keys.ENTER);

        PasswordOM(driver).sendKeys(PassWord);
        PasswordOM(driver).sendKeys(Keys.ENTER);


    }





}
