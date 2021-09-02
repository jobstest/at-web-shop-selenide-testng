package widgets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BaseRouter;

import static com.codeborne.selenide.Selenide.$;

public class DropdownList extends BaseRouter {

    private By locator;

    public DropdownList (By selector){
        this.locator = selector;
    }

    @Step("Выбрать значение из списка")
    public BaseRouter choose(String variant){
        $(locator).selectOption(variant);
        return this;
    }

    @Step("Проверить текст")
    public BaseRouter checkText(String expected){
        $(locator).shouldHave(Condition.text(expected));
        return this;
    }
}
