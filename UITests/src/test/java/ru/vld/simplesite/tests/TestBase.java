package ru.vld.simplesite.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.vld.simplesite.pages.Navigation;

public class TestBase {

    protected Navigation navigation = new Navigation();

    @BeforeEach
    public void beforeClass(){
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void clearCookieAndRefresh(){
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }
}
