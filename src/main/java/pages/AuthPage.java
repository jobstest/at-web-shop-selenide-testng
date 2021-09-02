package pages;

import org.openqa.selenium.By;
import widgets.Button;
import widgets.Checkbox;
import widgets.InputLine;

public class AuthPage {
    public InputLine email = new InputLine(By.id("Email"));
    public InputLine password = new InputLine(By.id("Password"));
    public Checkbox remember = new Checkbox(By.id("RememberMe"));
    public Button forgot_password = new Button(By.xpath("//span[@class='forgot-password']/a"));
    public Button btn_login = new Button(By.xpath("//input[@value='Log in']"));
    public Button register = new Button(By.xpath("//input[@value='Register']"));
    public Checkbox radio_btn_male = new Checkbox(By.id("gender-male"));
    public Checkbox radio_btn_female = new Checkbox(By.id("gender-female"));
    public InputLine first_name = new InputLine(By.id("FirstName"));
    public InputLine last_name = new InputLine(By.id("LastName"));
    public InputLine conf_password = new InputLine(By.id("ConfirmPassword"));
    public Button btn_recover = new Button(By.xpath("//input[@value='Recover']"));
    public InputLine error_message = new InputLine(By.xpath("//div[@class='validation-summary-errors']/span"));
}
