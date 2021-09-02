package widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BaseRouter;

import static com.codeborne.selenide.Selenide.$;

public class Button extends BaseRouter {

    private By locator;

    public Button(By selector){
        locator = selector;
    }

    @Step("Кликнуть по кнопке")
    public BaseRouter click(){
        $(locator).shouldBe(Condition.enabled).click();
        return this;
    }

    @Step("Навести курсор")
    public BaseRouter hover(){
        $(locator).hover();
        return this;
    }

    @Step("Получить текст")
    public String getText(){
        return $(locator).text();
    }

    @Step("Проверить заданный текст")
    public BaseRouter checkText(String expected){
        $(locator).shouldHave(Condition.text(expected));
        return this;
    }

    @Step("Проверить, что кнопка исчезла")
    public BaseRouter waitDisappear(int seconds){
        try {
            Configuration.timeout = 1000 * seconds;
            $(locator).should(Condition.disappear);
        }
        finally {
            Configuration.timeout = 3000;
        }
        return this;
    }

    @Step("Проверить, что кнопка присутствует")
    public BaseRouter shouldExist(){
        $(locator).should(Condition.exist);
        return this;
    }

    @Step("Проверить, что кнопка отсутствует")
    public BaseRouter shoulNotExist(){
        $(locator).should(Condition.not(Condition.exist));
        return this;
    }
}
