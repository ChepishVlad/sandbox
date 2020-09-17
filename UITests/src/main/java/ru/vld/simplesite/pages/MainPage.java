package ru.vld.simplesite.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.vld.simplesite.model.Contact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement upperMenuListItemLink = $("div#nav a");
    private SelenideElement searchStringInput = $("input[name='searchstring']");
    private ElementsCollection contactLineInTable = $$("tr[name='entry']");
    private SelenideElement contactCheckboxInput = $("table#maintable input[type='checkbox']");
    private SelenideElement deleteButton = $("input[value='Delete']");
    private SelenideElement editContactButton = $("table#maintable a[href*='edit']");

    public MainPage() {
        searchStringInput.waitUntil(visible.because("Инпут поиска должен отображаться на главной странице"),
                500);
    }

    public List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        for (SelenideElement e : contactLineInTable) {
            Contact contact = new Contact();
            contact.setLastName(e.findElement(By.xpath(".//td[2]")).getText());
            contact.setFirstName(e.findElement(By.xpath(".//td[3]")).getText());
            contact.setAddress(e.findElement(By.xpath(".//td[4]")).getText());
            contact.setId(Integer.parseInt(e.findElement(By.xpath(".//td[1]//input")).getAttribute("id")));
            contacts.add(contact);
        }
        return contacts;
    }

    public Contact getRandomContactFromTable() {
        Set<Contact> contacts = getContactSet();
        return contacts.iterator().next();
    }

    public Set<Contact> getContactSet() {
        Set<Contact> contacts = new HashSet<>();
        for (SelenideElement e : contactLineInTable) {
            Contact contact = new Contact();
            contact.setLastName(e.findElement(By.xpath(".//td[2]")).getText());
            contact.setFirstName(e.findElement(By.xpath(".//td[3]")).getText());
            contact.setAddress(e.findElement(By.xpath(".//td[4]")).getText());
            contact.setId(Integer.parseInt(e.findElement(By.xpath(".//td[1]//input")).getAttribute("id")));
            contact.setAllPhones(e.findElement(By.xpath(".//td[6]")).getText().replaceAll("\n", " ").trim());
            contact.setAllEmails(e.findElement(By.xpath(".//td[5]")).getText().replaceAll("\n", " ").trim());
            contacts.add(contact);
        }
        return contacts;
    }

    public int countContacts(){
        return contactLineInTable.size();
    }

    public MainPage selectFirstContact() {
        contactCheckboxInput.click();
        return this;
    }

    public void pressDeleteBtn() {
        deleteButton.click();
    }

    public void confirmDeletion() {
        switchTo().alert().accept();
    }

    public AddContactPage pressEditFirstContactBtn() {
        editContactButton.click();
        return new AddContactPage();
    }
}
