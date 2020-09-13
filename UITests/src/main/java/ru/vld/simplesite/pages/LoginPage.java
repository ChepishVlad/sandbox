package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;

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

    public LoginPage typeLogin(String value){
        loginInput.sendKeys(value);
        return this;
    }

    public LoginPage typePassword(String value){
        passInput.sendKeys(value);
        return this;
    }

    public LoginPage enterSubmitBtn(){
        submitBtn.click();
        return this;
    }

    public MainPage login(String login, String pass){
        typeLogin(login);
        typePassword(pass);
        enterSubmitBtn();
        return new MainPage();
    }

}
