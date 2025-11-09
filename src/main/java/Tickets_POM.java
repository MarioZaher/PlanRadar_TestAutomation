import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Tickets_POM {
    WebDriver driver;

    public Tickets_POM(WebDriver driver) {
        this.driver = driver;
    }

    By Create_Ticket_Button = By.xpath("//button[@data-id='tickets_listview_createticket']");
    By Tickets_Path = By.xpath("//div[@data-testid='navigation_tickets']");
    By Dropdown_menu = By.cssSelector(".css-1rnstzd-control");

    public void Create_Ticket(CreateForm_POM DriverCreated_Tkt) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(Tickets_Path).click();
        Thread.sleep(2000);

        driver.findElement(Create_Ticket_Button).click();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(Dropdown_menu);
        dropdown.click();

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-3-input")));


        input.sendKeys(DriverCreated_Tkt.Global_Rename_Form);
        Thread.sleep(1000);
        input.sendKeys(Keys.ENTER);

    }
}
