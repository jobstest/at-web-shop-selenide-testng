import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static testData.Users.user;
import static utils.InputsGenerator.*;
public class AdminTest extends BaseTest{

    @Test
    @Description("Авторизация с правильными почтой и паролем")
    public void auth(){
        baseRouter
                .headerPage().link_login.click()
                .authPage().email.fill(user.getEmail())
                .authPage().password.fill(user.getPassword())
                .authPage().btn_login.click()
                .headerPage().link_logout.shouldExist();
    }

    @Test
    @Description("Авторизация с неправильным паролем")
    public void authInvalidPassword(){
        baseRouter
                .headerPage().link_login.click()
                .authPage().email.fill(user.getEmail())
                .authPage().password.fill(getShortLatinStr())
                .authPage().btn_login.click()
                .authPage().error_message.shouldExist();
    }

    @Test
    @Description("Авторизация с неправильной почтой")
    public void authInvalidEmail(){
        baseRouter
                .headerPage().link_login.click()
                .authPage().email.fill(getRandomEmail())
                .authPage().password.fill(user.getPassword())
                .authPage().btn_login.click()
                .authPage().error_message.shouldExist();
    }




}
