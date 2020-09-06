package model;

import Serializers.deserializer.CsvUserDeserializer;
import Serializers.deserializer.JsonUserDeserializer;
import Serializers.deserializer.UserDeserializer;
import Serializers.deserializer.XmlUserDeserializer;
import Serializers.serializer.CsvUserSerializer;
import Serializers.serializer.JsonUserSerializer;
import Serializers.serializer.UserSerializer;
import Serializers.serializer.XmlUserSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class UserTest {

    @Test
    void jsonSerialize() throws IOException {
        File jsonFile = new File("users.json");
        Collection<User> userCollection = testData();
        UserSerializer userSerializer = new JsonUserSerializer();
        userSerializer.serialize(userCollection, jsonFile.getName());

        Assertions.assertTrue(new File("users.json").exists());

        UserDeserializer userDeserializer = new JsonUserDeserializer();
        Collection<User> newUsers = userDeserializer.deserialize(jsonFile.getName());
//        org.assertj.core.api.Assertions.assertThat(userCollection).containsExactlyElementsOf(newUsers);
    }

    @org.junit.jupiter.api.Test
    void xmlSerialize() throws IOException {
        File xmlFile = new File("users.xml");
        Collection<User> userCollection = testData();
        XmlUserSerializer xmlUserSerializer = new XmlUserSerializer();
        xmlUserSerializer.serialize(userCollection, xmlFile.getName());

        Assertions.assertTrue(new File("users.xml").exists());

        UserDeserializer userDeserializer = new XmlUserDeserializer();
        Collection<User> newUsers = userDeserializer.deserialize(xmlFile.getName());
//        org.assertj.core.api.Assertions.assertThat(userCollection).containsExactlyElementsOf(newUsers);

    }

    @org.junit.jupiter.api.Test
    void csvSerialize() throws IOException {
        File csvFile = new File("users.csv");
        Collection<User> userCollection = testData();
        CsvUserSerializer csvUserSerializer = new CsvUserSerializer();
        csvUserSerializer.serialize(userCollection, csvFile.getName());

        Assertions.assertTrue(new File("users.csv").exists());

        UserDeserializer userDeserializer = new CsvUserDeserializer();
        Collection<User> newUsers = userDeserializer.deserialize(csvFile.getName());
//        org.assertj.core.api.Assertions.assertThat(userCollection).containsExactlyElementsOf(newUsers);

    }

    private List<User> testData() {
        ArrayList<User> userCollection = new ArrayList<>();
        userCollection.add(new User(1, "Denis", "Denis@mail.ru"));
        userCollection.add(new User(2, "Boris", "Boris@mail.ru"));
        userCollection.add(new User(3, "Ivan", "Ivan@mail.ru"));
        userCollection.add(new User(4, "Gena", "Gena@mail.ru"));
        userCollection.add(new User(5, "Anna", "Anna@mail.ru"));
        userCollection.add(new User(6, "Ira", "Ira@mail.ru"));
        userCollection.add(new User(7, "Andrey", "Andrey@mail.ru"));
        userCollection.add(new User(8, "Vasily", "Vasily@mail.ru"));
        userCollection.add(new User(9, "Evgeniy", "Evgeniy@mail.ru"));
        userCollection.add(new User(10, "Artem", "Artem@mail.ru"));
        return userCollection;
    }
}