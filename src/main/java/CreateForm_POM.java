import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


class CreateForm_POM
{
    WebDriver driver;
    enum Select_Item{Short_Text,Long_Text,Date,CheckBox,Time,User};
    public String Global_Rename_Form;

    public CreateForm_POM(WebDriver driver)
    {
        this.driver=driver;
    }

    public void navigate_to_form() throws InterruptedException
    {
        //Navigate to Form & Lists
        Thread.sleep(7000);
        driver.findElement(By.xpath("//div[@class='toggle flex items-center w-full  bg-navigation']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//div[@data-id='navigation_formsandlists']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//div[@ data-testid ='navigation_forms']")).click();

    }

    public void Create_form(String FormName)
    {
        // click on create form button
        driver.findElement(By.xpath("//div[@class='ui-button-v2 ui-btn-create']")).click();
        // Rename Form
        driver.findElement(By.xpath("//input[@placeholder='Enter form name']")).sendKeys(FormName);

        //save Formname to use it in Selection of form in create Tickets class
        Global_Rename_Form = FormName;
    }

    public void Add_Items_To_Form(Select_Item selectItem,String DefaultValue , Boolean isMandatory) throws InterruptedException {

        if(selectItem == Select_Item.Short_Text)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-testid='ticket_type_form_field_Short Text']")).click();
            driver.findElement(By.xpath("//input[@data-id='Setup_Forms_ShortText_DefaultValue']")).sendKeys(DefaultValue);
            if(isMandatory == true)
            {
                driver.findElement(By.xpath("//span[@class='relative flex items-center justify-center size-8 rounded-md m-[10px] border-2 border-[#69737C] bg-white peer-disabled:border-border !m-0']")).
                click();
            }
        }
        if(selectItem == Select_Item.Long_Text)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-testid='ticket_type_form_field_Long Text']")).click();

            driver.findElement(By.xpath("//input[@data-id='Setup_Forms_LongText_DefaultValue']")).sendKeys(DefaultValue);
            if(isMandatory == true)
            {
                driver.findElement(By.xpath("//span[@class='relative flex items-center justify-center size-8 rounded-md m-[10px] border-2 border-[#69737C] bg-white peer-disabled:border-border !m-0']")).
                        click();
            }
        }
        if(selectItem == Select_Item.CheckBox)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-testid='ticket_type_form_field_Checkbox']")).click();

        }
        if(selectItem == Select_Item.Date)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-id='setup_forms_date']")).click();

        }
        if(selectItem == Select_Item.User)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-testid='ticket_type_form_field_User']")).click();
        }
        if(selectItem == Select_Item.Time)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@data-testid='ticket_type_form_field_Time']")).click();
        }


    }


    public void Click_Save_Form_Button_And_Close_Form() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='ui-button-v2 ui-btn-primary w-32']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='ui-button-v2 ui-btn-plain icon-only']")).click();
    }

}
