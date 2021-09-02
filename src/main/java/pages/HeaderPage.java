package pages;

import org.openqa.selenium.By;
import widgets.Button;
import widgets.Images;
import widgets.InputLine;

public class HeaderPage {

    public Images logo = new Images(By.xpath("//div[@class='header-logo']/a"));
    public Button link_register = new Button(By.xpath("//a[text()='Register']"));
    public Button link_account = new Button(By.xpath("//div[@class='header-links']//a[@class='account']"));
    public Button link_login = new Button(By.xpath("//a[text()='Log in']"));
    public Button link_logout = new Button(By.xpath("//a[text()='Log out']"));
    public Button link_shopping = new Button(By.xpath("//span[contains(text(), 'Shopping cart')]"));
    public Button link_wishlist = new Button(By.xpath("//span[contains(text(), 'Wishlist')]"));
    public InputLine line_search = new InputLine(By.id("small-searchterms"));
    public Button btn_search = new Button((By.xpath("//input[@value='Search']")));
}
