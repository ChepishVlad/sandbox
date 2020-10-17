package ru.vld.simplesite.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.vld.simplesite.Config;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Navigation {

    protected SelenideElement logoutBtn = $("a[onclick=\"document.logout.submit();\"]");
    protected SelenideElement groupsUpperMenuLink = $("div#nav a[href*='group']");
    protected SelenideElement addContactUpperMenuLink = $("div#nav a[href*='edit']");
    protected SelenideElement homePageUpperMenuLink = $("div#nav a[href='./']");

    @Step("Открыть страницу Авторизации")
    public LoginPage openLoginPage(){
        open(Config.getBaseUrl());
        return new LoginPage();
    }

    @Step("Открыть страницу 'Группы'")
    public GroupsPage openGroupsPage(){
        groupsUpperMenuLink.click();
        return new GroupsPage();
    }

    @Step("Открыть главную страницу")
    public MainPage openMainPage(){
        homePageUpperMenuLink.click();
        return new MainPage();
    }

    @Step("Открыть страницу добавления контакта")
    public AddContactPage openAddContactPage(){
        addContactUpperMenuLink.click();
        return new AddContactPage();
    }

}
