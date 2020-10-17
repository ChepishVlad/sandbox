package ru.vld.simplesite.tests.contact_tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vld.simplesite.model.Contact;
import ru.vld.simplesite.model.Group;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomContact;
import static ru.vld.simplesite.generators.CustomObjectsGenerator.generateRandomGroup;

public class ContactCreationTest extends BaseContactTest {

    private String groupName;

    @BeforeEach
    public void loginMethod() {
        groupsPage = navigation.openGroupsPage();
        if (groupsPage.getGroupsList().size() == 0) {
            Group group = generateRandomGroup();
            groupsPage.pressAddNewGroupBtn()
                    .fillGroupCreationFields(group)
                    .pressEnterInformationBtn()
                    .clickOnReturnLink();
        }
        groupsPage = navigation.openGroupsPage();
        groupName = groupsPage.getFirstGroupName();
        mainPage = navigation.openMainPage();
    }

    @Test()
    @Description("Тестирование создания контакта")
    public void testContactCreation() {
        List<Contact> contactsBefore = mainPage.getContactList();
        File photo = new File("src/test/resources/photo.jpg");
        Contact contact = generateRandomContact();
        contact.setGroup(groupName);
        contact.setPhoto(photo);
        addContactPage = navigation.openAddContactPage();
        addContactPage.fillContactCreationField(contact, true);
        addContactPage.pressEnterBtn();
        navigation.openMainPage();
        List<Contact> contactsAfter = mainPage.getContactList();
        assertEquals(contactsAfter.size(), contactsBefore.size() + 1,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");

        contact.setId(contactsAfter.stream().max(comparingInt(Contact::getId)).get().getId());
        contactsBefore.add(contact);
        Comparator<? super Contact> byId = Comparator.comparingInt(Contact::getId);
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        assertEquals(contactsBefore, contactsAfter,
                "После выполнения теста и змены элементов - списки должны совпадать");
    }
}
