package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginInput = $("input[name='user']");
    private SelenideElement passInput = $("input[name='pass']");
    private SelenideElement submitBtn = $("input[value='Login']");

    public LoginPage() {
        $(loginInput).waitUntil(visible.because("Инпут логина должен отображаться на странице"),
                500);
    }

    @Step("Ввести в поле логин: '{value}'")
    public void typeLogin(String value){
        loginInput.sendKeys(value);
    }

    @Step("Ввести в поле пароль: '{value}'")
    public void typePassword(String value){
        passInput.sendKeys(value);
    }

    @Step("Нажать на кнопку  ")
    public void enterSubmitBtn(){
        submitBtn.click();
    }

    public MainPage login(String login, String pass){
        typeLogin(login);
        typePassword(pass);
        enterSubmitBtn();
        return new MainPage();
    }

}
