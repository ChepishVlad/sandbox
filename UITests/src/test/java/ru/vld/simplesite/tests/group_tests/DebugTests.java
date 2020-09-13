package ru.vld.simplesite.tests.group_tests;

import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Group;
import ru.vld.simplesite.pages.GroupsPage;

import java.util.List;

public class DebugTests extends BaseGroupsTest{

    private GroupsPage groupsPage;

    @Test
    public void testGroupCollection(){
        groupsPage = navigation.openGroupsPage();
        List<Group> groups = groupsPage.getGroupsList();
        System.out.printf("Groups in list: %s%n", groups.size());
        for (Group group : groups) {
            System.out.println(group);
        }
        System.out.printf("Random groups is: %s%n", groupsPage.getRandomGroup(groups));
    }

}
