package ru.vld.simplesite.tests.contact_tests;

import org.junit.jupiter.api.BeforeEach;
import ru.vld.simplesite.Config;
import ru.vld.simplesite.pages.AddContactPage;
import ru.vld.simplesite.pages.GroupsPage;
import ru.vld.simplesite.pages.MainPage;
import ru.vld.simplesite.tests.TestBase;

public class BaseContactTest extends TestBase {

    protected GroupsPage groupsPage;
    protected MainPage mainPage;
    protected AddContactPage addContactPage;

    @BeforeEach
    public void login(){
        navigation.openLoginPage().login(
                Config.getAdminLogin(),
                Config.getAdminPassword());
    }

}
