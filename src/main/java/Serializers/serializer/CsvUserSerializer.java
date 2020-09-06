package Serializers.serializer;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CsvUserSerializer implements UserSerializer {

    @Override
    public void serialize(Collection<User> userCollection, String outFileName) {

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        CsvSchema schema = csvMapper.schemaFor(User.class).withHeader();
        File out = new File(outFileName);

        try {
            csvMapper.writer(schema).writeValue(out, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
