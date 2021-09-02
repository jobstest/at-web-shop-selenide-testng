package pages;

import static com.codeborne.selenide.Selenide.page;

public class BaseRouter {
    public AuthPage authPage(){
        return page(AuthPage.class);
    }
    public HeaderPage headerPage(){
        return page(HeaderPage.class);
    }
}
