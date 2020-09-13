package ru.vld.simplesite.generators;

public class DataHelper {

    public static String cleanPhone(String phone) {
        return phone.trim().replaceAll("[-()]]", "")
                .replaceAll("\\s", "");
    }

}
