package widgets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BaseRouter;

import static com.codeborne.selenide.Selenide.$;

public class LineRead extends BaseRouter {

    private By locator;

    public LineRead (By selector){
        this.locator = selector;
    }

    @Step("Получить текст")
    public String getText(){
        return $(locator).shouldBe(Condition.visible).getText();
    }

    @Step("Сравнить текст с заданным")
    public BaseRouter checkText(String expected){
        $(locator).shouldHave(Condition.text(expected));
        return this;
    }
}
