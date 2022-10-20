import org.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;

public class JsonModifyer {
    private static void main(String args[]) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("items.json");

        Object obj  = parser.parse(reader);
        System.out.println(obj);



    }
}
