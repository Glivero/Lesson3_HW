package Serializers.deserializer;

import model.User;

import java.io.IOException;
import java.util.Collection;

public interface UserDeserializer {

    Collection<User> deserialize(String inFileName) throws IOException;

}

