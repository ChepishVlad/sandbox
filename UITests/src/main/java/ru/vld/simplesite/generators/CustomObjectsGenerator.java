package ru.vld.simplesite.generators;

import com.github.javafaker.Faker;
import ru.vld.simplesite.model.Contact;
import ru.vld.simplesite.model.Group;

import java.io.File;
import java.util.Locale;

import static ru.vld.simplesite.generators.DataGenerator.*;

public class CustomObjectsGenerator {

    public static Contact generateRandomContact(){
        return generateRandomContact(false);
    }

    public static Contact generateRandomContact(boolean isPhotoNeeded){
        Faker faker = new Faker(new Locale("ru"));
        Contact contact = new Contact();
        contact.setFirstName(firstName())
                .setMiddleName(middleName())
                .setLastName(lastName())
                .setNickName(userName())
                .setCompany(campanyName())
                .setAddress(faker.address().streetAddress())
                .setMobilePhone(faker.phoneNumber().phoneNumber())
                .setHomePhone(faker.phoneNumber().phoneNumber())
                .setWorkPhone(faker.phoneNumber().phoneNumber())
                .setFax(faker.phoneNumber().phoneNumber())
                .setFirstEmail(generateEmail())
                .setSecondEmail(generateEmail())
                .setThirdEmail(generateEmail())
                .setHomepage(generateString(21))
                .setSecondAddress(faker.address().secondaryAddress())
                .setSecondHome(faker.phoneNumber().cellPhone())
                .setSecondNotes(faker.lorem().paragraph());
        if (isPhotoNeeded){
            contact.setPhoto(new File("src/test/resources/photo.jpg"));
        }
        return contact;
    }

    public static Group generateRandomGroup(){
        return new Group(title(), title(), title());
    }
}
