import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;

public class JsonModifyer {
    public static Object JSONgetter() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("items.json");

        Object obj  = parser.parse(reader);

        return(obj);
    }
}
