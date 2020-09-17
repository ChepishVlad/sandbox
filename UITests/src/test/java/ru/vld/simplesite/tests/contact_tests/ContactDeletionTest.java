package ru.vld.simplesite.tests.contact_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Contact;
import ru.vld.simplesite.model.Group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomContact;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomGroup;

public class ContactDeletionTest extends BaseContactTest {

    private String groupName;

    @BeforeEach
    public void loginMethod() {
        mainPage = navigation.openMainPage();
        if (mainPage.countContacts() == 0) {
            groupsPage = navigation.openGroupsPage();
            if (groupsPage.getGroupsList().size() == 0) {
                Group group = generateRandomGroup();
                groupsPage.pressAddNewGroupBtn()
                        .fillGroupCreationFields(group)
                        .pressEnterInformationBtn()
                        .clickOnReturnLink();
            }
            groupName = groupsPage.getFirstGroupName();
            Contact contact = generateRandomContact();
            contact.setGroup(groupName);
            addContactPage = navigation.openAddContactPage();
            addContactPage.fillContactCreationField(contact, true);
            addContactPage.pressEnterBtn();
            navigation.openMainPage();
        }
    }

    @Test()
    public void testContactDeletion() {
        int contactsNumberBefore = mainPage.countContacts();
        mainPage.selectFirstContact();
        mainPage.pressDeleteBtn();
        mainPage.confirmDeletion();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        assertEquals(contactsNumberAfter + 1, contactsNumberBefore,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");
    }

}
