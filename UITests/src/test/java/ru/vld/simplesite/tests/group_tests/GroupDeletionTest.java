package ru.vld.simplesite.tests.group_tests;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Group;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomGroup;

public class GroupDeletionTest extends BaseGroupsTest{

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
    @Description("Тест удаляющий группу")
    public void testGroupDeletion(){
        List<Group> groupsBefore = groupsPage.getGroupsList();
        Group delGroup = groupsPage.getRandomGroup(groupsBefore);
        groupsPage.deleteGroup(delGroup);
        navigation.openGroupsPage();
        List<Group> groupsAfter = groupsPage.getGroupsList();
        assertEquals(groupsBefore.size(), groupsAfter.size() + 1,
                "Количество групп после должно быть на одну меньше, чем количество групп до");
        groupsBefore.remove(delGroup);
        assertEquals(groupsAfter, groupsBefore,
                "Списки групп должны совпадать");
    }
}
