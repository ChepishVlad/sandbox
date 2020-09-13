package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    protected SelenideElement messageBox = $("div.msgbox");

    public String getTextFromMessageBox(){
        return messageBox.text();
    }

}
