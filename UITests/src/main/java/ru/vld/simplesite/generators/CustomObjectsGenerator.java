package ru.vld.simplesite.generators;

import com.github.javafaker.Faker;
import ru.vld.simplesite.model.Contact;
import ru.vld.simplesite.model.Group;

import java.io.File;
import java.util.Locale;

import static ru.vld.simplesite.generators.DataGenerator.generateEmail;
import static ru.vld.simplesite.generators.DataGenerator.generateString;

public class CustomObjectsGenerator {

    public static Contact generateRandomContact(){
        return generateRandomContact(false);
    }

    public static Contact generateRandomContact(boolean isPhotoNeeded){
        Faker faker = new Faker(new Locale("ru"));
        Contact contact = new Contact();
        contact.setFirstName(faker.name().firstName())
                .setMiddleName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setNickName(faker.name().username())
                .setCompany(faker.company().name())
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
        Faker faker = new Faker(new Locale("ru"));
        return new Group(
                faker.name().title(),
                faker.name().title(),
                faker.name().title());
    }
}
