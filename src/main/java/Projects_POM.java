import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Projects_POM
{


    WebDriver driver;

    Projects_POM(WebDriver driver)
    {
        this.driver=driver;
    }

    // Get the selectors of projects Tab
    By Projects_Path= By.xpath("//div[@data-testid='navigation_projects']");
    By Select_Project= By.xpath("//div[@aria-rowindex='1']");
    By Select_FormTab_Inside_project= By.xpath("//div[@data-id='Projects_Toolbar_FormsTab']");
    By Asigned_Form_Button=By.xpath("//div[@class='ui-button-v2 ui-btn-primary']");
    By Click_on_add_form=By.xpath("//div[@class='ui-button-v2 ui-btn-plain icon-only']");
    By Click_on_Apply=By.xpath("//button[@data-id='Projects_Forms_Form_Apply']");


    public void Add_Created_Form_To_Project() throws InterruptedException
    {
        Thread.sleep(3000);
        // Click on Projects Tab
        driver.findElement(Projects_Path).click();

        Thread.sleep(3000);
        // Click on "Example Project"
        driver.findElement(Select_Project).click();

        Thread.sleep(3000);
        // Select Form upside tab
        driver.findElement(Select_FormTab_Inside_project).click();

        Thread.sleep(3000);
        // Click on (Assign form) button on the selected Project
        driver.findElement(Asigned_Form_Button).click();

        Thread.sleep(3000);
        // Add The Form to project
        driver.findElement(Click_on_add_form).click();

        Thread.sleep(3000);
        // Add The Form to project
        driver.findElement(Click_on_Apply).click();
    }



}
