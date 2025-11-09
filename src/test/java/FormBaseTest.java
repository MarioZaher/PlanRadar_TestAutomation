import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class FormBaseTest
{
    // Create Web Driver
    WebDriver driver ;
    SoftAssert SoftAssert=new SoftAssert();


    // Precondtion
    @BeforeTest
    public void OpenBrowserThenLogin() throws InterruptedException {
        driver = new ChromeDriver();
        LoginPage_POM WebOject_1 = new LoginPage_POM(driver);

        //Open Chrome Browser
        WebOject_1.OpenBrowser();

        // Open Browser then Login by Username & Password
        WebOject_1.Enter_UserName_And_Password("mario.zaher.ayoub@gmail.com","Mario771995#");


    }

    @Test

    public void Create_Form_Check_Default_Mandatory_Config_of_Short_And_Long_Text_Items() throws InterruptedException
    {
        CreateForm_POM Form_test    = new CreateForm_POM(driver);
        Projects_POM   Project_test = new Projects_POM(driver);
        Tickets_POM    Ticket_test  = new Tickets_POM(driver);

        //Navigate to Form
        Form_test.navigate_to_form();

        //Create Form Named By "Selenuim Test Form1"
        Form_test.Create_form("Selenuim Test Form1");

        //Add Short Text Item
        Form_test.Add_Items_To_Form(CreateForm_POM.Select_Item.Short_Text,"Write A Short Text Note",true);
        //Add Long Text Item
        Form_test.Add_Items_To_Form(CreateForm_POM.Select_Item.Long_Text,"Write A Long Text Note",true);

        // Save Form and Close Page
        Form_test.Click_Save_Form_Button_And_Close_Form();
        Thread.sleep(5000);

        // Add Form to the current Project
        Project_test.Add_Created_Form_To_Project();

        // Create Ticket
        Ticket_test.Create_Ticket(Form_test);


        Thread.sleep(3000);


        // Assert Short Text * Manadatory field is applied for Short Text
        SoftAssert.assertEquals(driver.findElement(By.xpath("//p[normalize-space()='* Short Text']")).getText().contains("* Short Text"),true);
        // Assert Default Value of Short Text "Write A Short Text Note"
        SoftAssert.assertEquals(driver.findElement(By.xpath("//input[@data-testid='ticket_form_field_Short_Text']")).getText(),"Write A Short Text Note");

        // Assert Long Text * Manadatory field is applied for Long Text
        SoftAssert.assertEquals(driver.findElement(By.xpath("//p[normalize-space()='* Long Text']")).getText().contains("* Short Text"),true);
        // Assert Default Value of Long Text "Write A Long Text Note"
        SoftAssert.assertEquals(driver.findElement(By.xpath("//textarea[@data-testid='ticket_form_field_Long_Text']")).getText(),"Write A Long Text Note");

    }
    @AfterTest
    public void Close_The_Browser() throws InterruptedException {

        Thread.sleep(5000);
        // Close the Browser
        driver.quit();
    }


}
