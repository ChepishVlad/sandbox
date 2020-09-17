package ru.vld.simplesite.generators;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    protected static final Faker FAKER = new Faker(new Locale("ru"));

    public static String firstName(){
        return FAKER.name().firstName();
    }

    public static String middleName(){
        return FAKER.name().firstName();
    }

    public static String lastName(){
        return FAKER.name().lastName();
    }

    public static String title(){
        return FAKER.name().title();
    }

    public static String userName(){
        return FAKER.name().username();
    }

    public static String campanyName(){
        return FAKER.company().name();
    }


    public static String generateString(int length) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String generateEmail(){
        String name = generateString(7);
        String domain = generateString(4);
        String zone = generateString(3);

        return (name + "@" + domain + "." + zone).toLowerCase();
    }

    public static String geniratorNumeric(int length){
        char[] chars = "012345679".toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String generatePassword(int length){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012345679".toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

}
