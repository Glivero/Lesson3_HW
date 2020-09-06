package Serializers.deserializer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CsvUserDeserializer implements UserDeserializer {

    @Override
    public Collection<User> deserialize(String inFileName) throws IOException {

        CsvMapper objectMapper = new CsvMapper();
        File in = new File(inFileName);
        objectMapper.schemaFor(User.class).withoutHeader();
        Object o = objectMapper.readerFor(Collection.class).readValue(in);
        Collection<User> userCollection = (ArrayList<User>) o;

        return userCollection;
    }
}
