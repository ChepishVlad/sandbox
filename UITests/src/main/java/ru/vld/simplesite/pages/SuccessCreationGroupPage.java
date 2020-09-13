package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessCreationGroupPage extends BasePage{

    private SelenideElement returnToGroupPageLink = $("div.msgbox a[href*='group']");

    public SuccessCreationGroupPage() {
        returnToGroupPageLink.waitUntil(visible.because("Страница успешного создания группы не отображается"),
                500);
    }

    public GroupsPage clickOnReturnLink(){
        returnToGroupPageLink.click();
        return new GroupsPage();
    }

}
