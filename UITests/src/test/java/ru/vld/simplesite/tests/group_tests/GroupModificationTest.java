package ru.vld.simplesite.tests.group_tests;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Group;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomGroup;

public class GroupModificationTest extends BaseGroupsTest{

    @BeforeEach
    public void precondition(){
        groupsPage = navigation.openGroupsPage();
        if (groupsPage.getGroupsList().size() == 0) {
            Group group = generateRandomGroup();
            groupsPage.pressAddNewGroupBtn()
                    .fillGroupCreationFields(group)
                    .pressEnterInformationBtn()
                    .clickOnReturnLink();
        }
        groupsPage = navigation.openGroupsPage();
    }

    @Test()
    @Description("Тест изменяющий группу")
    public void testGroupModification(){
        List<Group> groupsBefore = groupsPage.getGroupsList();
        Group modifiedGroup = groupsPage.getRandomGroup(groupsBefore);
        Group group = generateRandomGroup();
        group.setGroupId(modifiedGroup.getGroupId());
        groupsPage.selectGroupById(modifiedGroup.getGroupId());
        groupsPage.pressEditGroupBtn()
                .fillGroupCreationFields(group)
                .pressUpdateBtn()
                .clickOnReturnLink();
        List<Group> groupsAfter = groupsPage.getGroupsList();
        assertEquals(groupsBefore.size(), groupsAfter.size(),
                "Количество групп не должно было измениться в процессе выполнения теста");
        groupsBefore.remove(modifiedGroup);
        groupsBefore.add(group);
        Comparator<? super Group> byId = Comparator.comparingInt(Group::getGroupId);
        groupsBefore.sort(byId);
        groupsAfter.sort(byId);
        assertEquals(groupsBefore, groupsAfter,
                "После выполнения теста и замены элемента в финальном списке - спики должны совпадать");
    }
}
