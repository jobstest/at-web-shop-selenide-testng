package widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import pages.BaseRouter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import static com.codeborne.selenide.Selenide.$;
@Log
public class InputLine extends BaseRouter {

    private By locator;

    public InputLine (By selector){
        this.locator = selector;
    }

    @Step("Очистить поле")
    public BaseRouter clear(){
        $(locator).clear();
        //backspaces to get error
        $(locator).sendKeys("a");
        $(locator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Ввести текст")
    public BaseRouter fill(String text){
        $(locator).sendKeys(text);
        return this;
    }

    @Step("Вставить текст")
    public BaseRouter insert(String text){
        // 'ctrl+c' for local browser
        try {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
        }
        catch (HeadlessException e){
            log.info("....");
        }
        // 'ctrl+v'
        $(locator).sendKeys(Keys.CONTROL + "v");
        return this;
    }

    @Step("Очисть поле и заполнить")
    public BaseRouter clearWithFill(String text){
        $(locator).clear();
        $(locator).sendKeys(text);
        return this;
    }

    @Step("Заполнить поле и нажать Enter")
    public BaseRouter fillWithEnter(String text){
        $(locator).sendKeys(text);
        $(locator).pressEnter();
        return this;
    }

    @Step("Получить текст")
    public String getText(){
        return $(locator).getAttribute("value");
    }

    @Step("Сравнить текст с заданным")
    public BaseRouter checkText(String expected){
        String current = $(locator).getAttribute("value");
        if (!current.equals(expected))
            throw new AssertionError("Line content is incorrect! "+ "Expected '" + expected + "', get '" + current + "'!" );
        return this;
    }

    @Step("Запонить поле!!!")
    public BaseRouter actionsFill(String text){
    // useful for js-filling fields
    Action action = new Actions(WebDriverRunner.getWebDriver())
            .moveToElement($(locator).shouldBe(Condition.exist).toWebElement())
            .click()
            .sendKeys(text)
            .build();
    action.perform();
    return this;
    }

    @Step("Очистить поле!!!")
    public BaseRouter actionClear(){
        // useful for js-filling fields
        Action action = new Actions(WebDriverRunner.getWebDriver())
                .moveToElement($(locator).shouldBe(Condition.exist).toWebElement())
                .click()
                .sendKeys("a")
                .sendKeys(Keys.BACK_SPACE)
                .build();
        action.perform();
        return this;
    }

    @Step("Проверить, что строка присутствует")
    public BaseRouter shouldExist(){
        $(locator).should(Condition.exist);
        return this;
    }





}
