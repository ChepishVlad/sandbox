package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.vld.simplesite.model.Group;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddGroupPage {

    private SelenideElement groupNameInput = $("input[name='group_name']");
    private SelenideElement groupHeaderTextarea = $("textarea[name='group_header']");
    private SelenideElement groupFooterTextarea = $("textarea[name='group_footer']");
    private SelenideElement subminBtn = $("input[name='submit']");
    private SelenideElement updateBtn = $("input[name='update']");

    public AddGroupPage() {
        groupNameInput.waitUntil(visible.because("Страница создания групп не загрузилась"), 500);
    }

    public SuccessCreationGroupPage pressEnterInformationBtn(){
        subminBtn.click();
        return new SuccessCreationGroupPage();
    }


    public SuccessCreationGroupPage pressUpdateBtn(){
        updateBtn.click();
        return new SuccessCreationGroupPage();
    }

    @Step("Заполенить форму создания группу: {group}")
    public AddGroupPage fillGroupCreationFields(Group group){
        groupNameInput.setValue(group.getGroupName());
        groupHeaderTextarea.setValue(group.getGroupHeader());
        groupFooterTextarea.setValue(group.getGroupFooter());
        return this;
    }

}
