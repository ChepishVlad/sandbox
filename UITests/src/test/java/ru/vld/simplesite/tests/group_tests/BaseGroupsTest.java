package ru.vld.simplesite.tests.group_tests;

import org.junit.jupiter.api.BeforeEach;
import ru.vld.simplesite.Config;
import ru.vld.simplesite.pages.GroupsPage;
import ru.vld.simplesite.tests.TestBase;

public class BaseGroupsTest extends TestBase {

    protected GroupsPage groupsPage;

    @BeforeEach
    public void login(){
        navigation.openLoginPage().login(
                Config.getAdminLogin(),
                Config.getAdminPassword());
    }
}
