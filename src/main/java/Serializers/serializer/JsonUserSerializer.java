package Serializers.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonUserSerializer implements UserSerializer {

    @Override
    public void serialize(Collection<User> userCollection, String outFileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        File out = new File(outFileName);
        try {
            objectMapper.writerFor(userCollection.getClass()).writeValue(out, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

