package widgets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BaseRouter;

import static com.codeborne.selenide.Selenide.$;

public class Images extends BaseRouter {

    private By locator;

    public Images(By selector){
        locator = selector;
    }

    @Step("Кликнуть по картинке/ логотипу")
    public BaseRouter click(){
        $(locator).shouldBe(Condition.enabled).click();
        return this;
    }
}
