package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;
import ru.vld.simplesite.model.Contact;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ru.vld.simplesite.generators.DataHelper.cleanPhone;

public class AddContactPage {

    private SelenideElement firstNameInput = $("input[name='firstname']");
    private SelenideElement middleNameInput = $("input[name='middlename']");
    private SelenideElement lastNameInput = $("input[name='lastname']");
    private SelenideElement nicknameInput = $("input[name='nickname']");
    private SelenideElement photoInput = $("input[name='photo']");
    private SelenideElement companyInput = $("input[name='company']");
    private SelenideElement addressTextarea = $("textarea[name='address']");
    private SelenideElement homePhoneInput = $("input[name='home']");
    private SelenideElement mobilePhoneInput = $("input[name='mobile']");
    private SelenideElement workPhoneInput = $("input[name='work']");
    private SelenideElement faxPhoneInput = $("input[name='fax']");
    private SelenideElement firstEmailInput = $("input[name='email']");
    private SelenideElement secondEmailInput = $("input[name='email2']");
    private SelenideElement thirdEmailInput = $("input[name='email3']");
    private SelenideElement homepageInput = $("input[name='homepage']");
    private SelenideElement birthDaySelect = $("select[name='bday']");
    private SelenideElement birthMonthSelect = $("select[name='bmonth']");
    private SelenideElement birthYearInput = $("input[name='byear']");
    private SelenideElement aniversaryDaySelect = $("select[name='aday']");
    private SelenideElement aniversaryMonthSelect = $("select[name='amonth']");
    private SelenideElement aniversaryYearInput = $("input[name='ayear']");
    private SelenideElement groupSelect = $("select[name='new_group']");
    private SelenideElement addressSecondTextarea = $("textarea[name='address2']");
    private SelenideElement homeSecondPhone = $("input[name='phone2']");
    private SelenideElement notesTextarea = $("textarea[name='notes']");
    private SelenideElement firstEnterButton = $x("//input[@name='submit'][1]");
    private SelenideElement firstUpdateButton = $x("//input[@value='Update'][1]");
    private SelenideElement secondEnterButton = $x("//input[@name='submit'][2]");

    public AddContactPage() {
        firstNameInput.waitUntil(visible.because("Страница создания контакта не загрузилась"),
                500);
    }

    private AddContactPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    private AddContactPage setMiddleName(String value){
        middleNameInput.setValue(value);
        return this;
    }

    private AddContactPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    private AddContactPage setNickName(String value){
        nicknameInput.setValue(value);
        return this;
    }

    private AddContactPage setAddress(String value){
        addressTextarea.setValue(value);
        return this;
    }

    private AddContactPage setHomePhone(String value) {
        homepageInput.setValue(value);
        return this;
    }

    private AddContactPage setMobilePhone(String value) {
        mobilePhoneInput.setValue(value);
        return this;
    }

    private AddContactPage setCompany(String value) {
        companyInput.setValue(value);
        return this;
    }

    private AddContactPage setWorkPhone(String value) {
        workPhoneInput.setValue(value);
        return this;
    }

    private AddContactPage setFax(String value) {
        faxPhoneInput.setValue(value);
        return this;
    }

    private AddContactPage setFirstEmail(String value) {
        firstEmailInput.setValue(value);
        return this;
    }

    private AddContactPage setSecondEmail(String value) {
        secondEmailInput.setValue(value);
        return this;
    }

    private AddContactPage setThirdEmail(String value) {
        thirdEmailInput.setValue(value);
        return this;
    }

    private AddContactPage setHomepage(String value) {
        homepageInput.setValue(value);
        return this;
    }

    private AddContactPage setSecondAddress(String value) {
        addressSecondTextarea.setValue(value);
        return this;
    }

    private AddContactPage setHomeSecondPhone(String value) {
        homeSecondPhone.setValue(value);
        return this;
    }

    private AddContactPage setNotes(String value) {
        notesTextarea.setValue(value);
        return this;
    }

    private AddContactPage setGroup(String value) {
        new Select(groupSelect).selectByVisibleText(value);
        return this;
    }

    private AddContactPage setPhoto(File file) {
        photoInput.uploadFile(file);
        return this;
    }

    public void fillContactCreationField(Contact contact, boolean isGroupPresent) {
        fillContactCreationField(contact);
        setGroup(contact.getGroup());
    }

    public void fillContactCreationField(Contact contact) {
        setFirstName(contact.getFirstName());
        setMiddleName(contact.getMiddleName());
        setLastName(contact.getLastName());
        setNickName(contact.getNickName());
        setPhoto(contact.getPhoto());
        setCompany(contact.getCompany());
        setAddress(contact.getAddress());
        setHomePhone(contact.getHomePhone());
        setMobilePhone(contact.getMobilePhone());
        setWorkPhone(contact.getWorkPhone());
        setHomePhone(contact.getHomePhone());
        setFax(contact.getFax());
        setFirstEmail(contact.getFirstEmail());
        setSecondEmail(contact.getSecondEmail());
        setThirdEmail(contact.getThirdEmail());
        setHomepage(contact.getHomepage());
        setSecondAddress(contact.getSecondAddress());
        setHomeSecondPhone(contact.getSecondHome());
        setNotes(contact.getSecondNotes());
    }

    public AddContactPage pressEnterBtn(){
        firstEnterButton.click();
        return this;
    }

    private String buildAllEmails(String firstEmail, String secondEmail, String thirdEmail) {
        String allEmails = "";
        List<String> emails = Arrays.asList(firstEmail, secondEmail, thirdEmail);
        for (String e : emails) {
            if (e != null || !e.equals("")) {
                allEmails = allEmails + e + " ";
            }
        }
        return allEmails.trim();
    }

    public Contact getContact() {
        Contact contact = new Contact();
        contact.setFirstName(firstNameInput.val());
        contact.setMiddleName(middleNameInput.val());
        contact.setLastName(lastNameInput.val());
        contact.setNickName(nicknameInput.val());
        contact.setAddress(addressTextarea.val());
        contact.setCompany(companyInput.val());
        contact.setWorkPhone(workPhoneInput.val());
        contact.setHomePhone(homePhoneInput.val());
        contact.setMobilePhone(mobilePhoneInput.val());
        contact.setFirstEmail(firstEmailInput.val());
        contact.setSecondEmail(secondEmailInput.val());
        contact.setThirdEmail(thirdEmailInput.val());
        contact.setSecondHome(homeSecondPhone.val());
        contact.setAllPhones(buildAllPhones(cleanPhone(contact.getHomePhone()),
                cleanPhone(contact.getMobilePhone()),
                cleanPhone(contact.getWorkPhone()),
                cleanPhone(contact.getSecondHome())));
        contact.setAllEmails(buildAllEmails(contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail()));
        return contact;
    }


    private String buildAllPhones(String homePhone, String mobilePhone, String workPhone, String secondHomePhone) {
        String allPhones = "";
        List<String> phones = Arrays.asList(homePhone, mobilePhone, workPhone, secondHomePhone);
        for (String p : phones) {
            if (p != null || p.equals("")) {
                allPhones = allPhones + p + " ";
            }
        }
        return allPhones.trim();
    }

    public AddContactPage pressUpdateBtn() {
        firstUpdateButton.click();
        return this;
    }

}
