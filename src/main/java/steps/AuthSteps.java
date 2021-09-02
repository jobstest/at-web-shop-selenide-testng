package steps;

import io.qameta.allure.Step;
import models.User;

public class AuthSteps extends BaseSteps{

    @Step("Авторизация через правильные логин и пароль")
    public BaseSteps login(User user){
        baseRouter.headerPage().link_login.click()
                .authPage().email.fill(user.getEmail())
                .authPage().password.fill(user.getPassword())
                .authPage().btn_login.click()
                .headerPage().link_logout.shouldExist();
        return this;
    }

}
