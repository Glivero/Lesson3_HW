package Serializers.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JsonUserDeserializer implements UserDeserializer {

    @Override
    public Collection<User> deserialize(String inFileName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File in = new File(inFileName);
        Object o = objectMapper.readerFor(Collection.class).readValue(in);
        Collection<User> userCollection = (ArrayList<User>) o;

        return userCollection;
    }
}