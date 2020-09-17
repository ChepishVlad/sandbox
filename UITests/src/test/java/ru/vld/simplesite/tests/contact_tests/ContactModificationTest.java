package ru.vld.simplesite.tests.contact_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Contact;
import ru.vld.simplesite.model.Group;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomContact;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomGroup;

public class ContactModificationTest extends BaseContactTest{

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
    public void testContactModification() {
        List<Contact> contactsBefore = mainPage.getContactList();
        Contact contact = generateRandomContact(true);
        contact.setId(contactsBefore.get(0).getId());
        addContactPage = mainPage.pressEditFirstContactBtn();
        addContactPage.fillContactCreationField(contact);
        addContactPage.pressUpdateBtn();
        navigation.openMainPage();
        List<Contact> contactsAfter = mainPage.getContactList();
        assertEquals(contactsAfter.size(), contactsBefore.size(),
                "Количество контактов не должно было измениться по результатам работаы теста");

        contactsBefore.remove(0);
        contactsBefore.add(contact);
        Comparator<? super Contact> byId = Comparator.comparingInt(Contact::getId);
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        assertEquals(contactsBefore, contactsAfter,
                "После выполнения теста и змены элементов - списки должны совпадать");
    }

}
