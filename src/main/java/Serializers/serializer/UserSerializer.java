package Serializers.serializer;

import model.User;

import java.util.Collection;

public interface UserSerializer {

    void serialize(Collection<User> userCollection, String outFileName);
}
