package Serializers.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class XmlUserDeserializer implements UserDeserializer {

    @Override
    public Collection<User> deserialize(String inFileName) throws IOException {

        ObjectMapper objectMapper = new XmlMapper();
        File in = new File(inFileName);
        Object o = objectMapper.readerFor(Collection.class).readValue(in);
        Collection<User> userCollection = (ArrayList<User>) o;

        return userCollection;
    }
}
