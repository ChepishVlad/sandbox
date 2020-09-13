package ru.vld.simplesite.model;

import java.io.File;
import java.util.Objects;

public class Contact {

    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String company;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String fax;
    private String firstEmail;
    private String secondEmail;
    private String thirdEmail;
    private String homepage;
    private String secondAddress;
    private String secondHome;
    private String secondNotes;
    private String group;
    private String allEmails;
    private String allPhones;
    private int id;
    private File photo;

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Contact setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public Contact setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public Contact setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Contact setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Contact setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public Contact setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public Contact setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public Contact setFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public Contact setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public Contact setThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public Contact setHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public Contact setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;
    }

    public String getSecondHome() {
        return secondHome;
    }

    public Contact setSecondHome(String secondHome) {
        this.secondHome = secondHome;
        return this;
    }

    public String getSecondNotes() {
        return secondNotes;
    }

    public Contact setSecondNotes(String secondNotes) {
        this.secondNotes = secondNotes;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Contact setGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public void setAllEmails(String allEmails) {
        this.allEmails = allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public void setAllPhones(String allPhones) {
        this.allPhones = allPhones;
    }

    public File getPhoto() {
        return photo;
    }

    public Contact setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(middleName, contact.middleName) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(nickName, contact.nickName) &&
                Objects.equals(company, contact.company) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(homePhone, contact.homePhone) &&
                Objects.equals(mobilePhone, contact.mobilePhone) &&
                Objects.equals(workPhone, contact.workPhone) &&
                Objects.equals(fax, contact.fax) &&
                Objects.equals(firstEmail, contact.firstEmail) &&
                Objects.equals(secondEmail, contact.secondEmail) &&
                Objects.equals(thirdEmail, contact.thirdEmail) &&
                Objects.equals(homepage, contact.homepage) &&
                Objects.equals(secondAddress, contact.secondAddress) &&
                Objects.equals(secondHome, contact.secondHome) &&
                Objects.equals(secondNotes, contact.secondNotes) &&
                Objects.equals(group, contact.group) &&
                Objects.equals(allEmails, contact.allEmails) &&
                Objects.equals(allPhones, contact.allPhones) &&
                Objects.equals(photo, contact.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, nickName, company, address, homePhone, mobilePhone, workPhone, fax, firstEmail, secondEmail, thirdEmail, homepage, secondAddress, secondHome, secondNotes, group, allEmails, allPhones, id, photo);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", firstEmail='" + firstEmail + '\'' +
                ", secondEmail='" + secondEmail + '\'' +
                ", thirdEmail='" + thirdEmail + '\'' +
                ", homepage='" + homepage + '\'' +
                ", secondAddress='" + secondAddress + '\'' +
                ", secondHome='" + secondHome + '\'' +
                ", secondNotes='" + secondNotes + '\'' +
                ", group='" + group + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", id=" + id +
                ", photo=" + photo +
                '}';
    }
}
