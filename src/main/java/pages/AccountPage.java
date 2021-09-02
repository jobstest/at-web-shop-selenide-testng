package pages;

import org.openqa.selenium.By;
import widgets.Button;
import widgets.Checkbox;
import widgets.DropdownList;
import widgets.InputLine;

public class AccountPage {

    public Button customer_info = new Button(By.xpath("//a[text()='Customer info']"));
    public Checkbox radio_btn_male = new Checkbox(By.id("gender-male"));
    public Checkbox radio_btn_female = new Checkbox(By.id("gender-female"));
    public InputLine first_name = new InputLine(By.id("FirstName"));
    public InputLine last_name = new InputLine(By.id("LastName"));
    public InputLine email = new InputLine(By.id("Email"));
    public Button btn_save = new Button(By.xpath("//input[@value='Save']"));

    public Button addresses = new Button(By.xpath("//div[@class='listbox']//a[text()='Addresses']"));
    public Button btn_add_new = new Button(By.xpath("//input[@value='Add new']"));
    public InputLine address_fname = new InputLine(By.id("Address_FirstName"));
    public InputLine address_lname = new InputLine(By.id("Address_LastName"));
    public InputLine address_email = new InputLine(By.id("Address_Email"));
    public InputLine company = new InputLine(By.id("Address_Company"));
    public DropdownList country = new DropdownList(By.id("Address_CountryId"));
    public DropdownList state = new DropdownList(By.id("Address_StateProvinceId"));
    public InputLine city = new InputLine(By.id("Address_City"));
    public InputLine address1 = new InputLine(By.id("Address_Address1"));
    public InputLine address2 = new InputLine(By.id("Address_Address2"));
    public InputLine zip = new InputLine(By.id("Address_ZipPostalCode"));
    public InputLine phone = new InputLine(By.id("Address_PhoneNumber"));
    public InputLine fax = new InputLine(By.id("Address_FaxNumber"));
}
