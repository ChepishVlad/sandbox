package ru.vld.simplesite.tests.group_tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomGroup;

public class GroupCreationTest extends BaseGroupsTest{

    @Test
    @Description("Тест создающий группу")
    public void testGroupCreation(){
        groupsPage = navigation.openGroupsPage();
        int groupsBefore = groupsPage.getGroupsList().size();
        Group group = generateRandomGroup();
        groupsPage.pressAddNewGroupBtn()
                .fillGroupCreationFields(group)
                .pressEnterInformationBtn()
                .clickOnReturnLink();
        int groupAfter = groupsPage.getGroupsList().size();
        assertEquals(groupsBefore + 1, groupAfter,
                "Количество групп до должно быть на одну меньше, чем количество групп после");
    }
}
