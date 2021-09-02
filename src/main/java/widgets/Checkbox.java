package widgets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BaseRouter;

import static com.codeborne.selenide.Selenide.$;

public class Checkbox extends BaseRouter {

    private By locator;

    public Checkbox (By selector){
        locator = selector;
    }

    @Step("Чекбокс включен")
    public boolean isSelected(){
        return $(locator).isSelected();
    }

    @Step("Включить или отключить чекбокс")
    public BaseRouter set(boolean flag){
        if (flag){
            if (!isSelected()) $(locator).click();
        } else {
            if (isSelected()) $(locator).click();
        }
        return this;
    }

    @Step("Включить чекбокс")
    public BaseRouter setTrue(){
        if (!isSelected()){
            $(locator).click();
        }
        return this;
    }

    @Step("..")
    public BaseRouter checkTrue(){
        $(locator).shouldBe(Condition.selected);
        return  this;
    }

    @Step("Отключить чекбокс")
    public BaseRouter setFelse(){
        if (isSelected()) $(locator).click();
        return this;
    }

    @Step("..")
    public BaseRouter chckFalse(){
        $(locator).shouldBe(Condition.not(Condition.selected));
        return this;
    }

    @Step("Нажать на чекбокс")
    public BaseRouter clickBox() {
        $(locator).click();
        return this;
    }

    @Step("Чебокс недоступен для редактирования!!")
    public BaseRouter checkIsUnclickable(){
        $(locator).shouldBe(Condition.disabled);
        return this;
    }





}
