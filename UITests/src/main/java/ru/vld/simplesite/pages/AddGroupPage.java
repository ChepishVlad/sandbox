package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;
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

    public AddGroupPage setGroupName(String value){
        groupNameInput.setValue(value);
        return this;
    }

    public AddGroupPage setGroupHeader(String value){
        groupHeaderTextarea.setValue(value);
        return this;
    }

    public AddGroupPage setGroupFooter(String value){
        groupFooterTextarea.setValue(value);
        return this;
    }

    public SuccessCreationGroupPage pressEnterInformationBtn(){
        subminBtn.click();
        return new SuccessCreationGroupPage();
    }

    public SuccessCreationGroupPage pressUpdateBtn(){
        updateBtn.click();
        return new SuccessCreationGroupPage();
    }

    public AddGroupPage fillGroupCreationFields(Group group){
        setGroupName(group.getGroupName());
        setGroupHeader(group.getGroupHeader());
        setGroupFooter(group.getGroupFooter());
        return this;
    }

}
