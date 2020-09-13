package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;
import ru.vld.simplesite.Config;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Navigation {

    protected SelenideElement logoutBtn = $("a[onclick=\"document.logout.submit();\"]");
    protected SelenideElement groupsUpperMenuLink = $("div#nav a[href*='group']");
    protected SelenideElement addContactUpperMenuLink = $("div#nav a[href*='edit']");
    protected SelenideElement homePageUpperMenuLink = $("div#nav a[href='./']");
    protected SelenideElement messageBox = $("div.msgbox");

    public LoginPage openLoginPage(){
        open(Config.getBaseUrl());
        return new LoginPage();
    }

    public GroupsPage openGroupsPage(){
        groupsUpperMenuLink.click();
        return new GroupsPage();
    }

    public MainPage openMainPage(){
        homePageUpperMenuLink.click();
        return new MainPage();
    }

//    public AddContactPage openAddContactPage(){
//        addContactUpperMenuLink.click();
//        return new AddContactPage();
//    }

}
