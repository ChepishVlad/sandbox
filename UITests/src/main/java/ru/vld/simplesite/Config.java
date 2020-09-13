package ru.vld.simplesite;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("cfg.properties")
public class Config {

    private static Config config = new Config();

    @Property("web.admin.login")
    private static String adminLogin;

    @Property("web.admin.pass")
    private static String adminPassword;

    @Property("base.url")
    private static String baseUrl;

    @Property("selenoid.addr")
    private static String selenoidUrl;

    private Config() {
        PropertyLoader.populate(this);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getAdminLogin() {
        return adminLogin;
    }

    public static String getAdminPassword() {
        return  adminPassword;
    }

    public static String getSelenoid(){
        return selenoidUrl;
    }
}
