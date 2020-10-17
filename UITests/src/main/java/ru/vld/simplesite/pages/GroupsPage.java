package ru.vld.simplesite.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.vld.simplesite.model.Group;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupsPage extends BasePage{

    private SelenideElement groupsPageHeader = $x("//h1[text()='Groups']");
    private SelenideElement createGroupButtonUpper = $x("//input[@name='new'][1]");
    private ElementsCollection groupInList = $$("span.group");
    private SelenideElement groupCheckboxInput = $("input[type='checkbox']");
    private SelenideElement deleteGroupButtonUpper = $x("//input[@name='delete'][1]");
    private SelenideElement editGroupButtonUpper = $x("//input[@name='edit'][1]");
    private SelenideElement firstGroupInList = $x("//span[@class='group'][1]");
    private String groupById = "input[value='%s']";

    public GroupsPage() {
        groupsPageHeader.waitUntil(visible.because("Страница групп не загрузилась"), 500);
    }

    @Step("Получить список групп")
    public List<Group> getGroupsList() {
        return groupInList.stream().map(s -> new Group(
                s.text(),
                Integer.parseInt(s.$x(".//input").val())))
                .collect(Collectors.toList());
    }

    @Step("Выбрать случайную группу из списка")
    public Group getRandomGroup(List<Group> groups){
        return groups.get((int) (Math.random() * groups.size()));
    }

    @Step("Нажать на кнопку добавиления новой группы")
    public AddGroupPage pressAddNewGroupBtn(){
        createGroupButtonUpper.click();
        return new AddGroupPage();
    }

    @Step("Получить название первой групапы")
    public String getFirstGroupName() {
        return firstGroupInList.text();
    }

    @Step("Удалить группу")
    public GroupsPage deleteGroup(Group group) {
        selectGroupById(group.getGroupId());
        pressDeleteGroupBtn();
        checkMessageBox();
        return this;
    }

    @Step("Выбрать группу {id} по id")
    public GroupsPage selectGroupById(int id) {
        $(String.format(groupById, id)).click();
        return this;
    }

    @Step("Нажать на кнопку удаления группы")
    public GroupsPage pressDeleteGroupBtn() {
        deleteGroupButtonUpper.click();
        return this;
    }

    public GroupsPage checkMessageBox() {
        assertTrue(getTextFromMessageBox().contains("Group has been removed"),
                "Текст в сообщении не содежрит необходимую часть");
        return this;
    }

    @Step("Нажать на кноку редактирования группы")
    public AddGroupPage pressEditGroupBtn(){
        editGroupButtonUpper.click();
        return new AddGroupPage();
    }
}
