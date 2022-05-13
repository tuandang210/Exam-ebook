package cmcglobal.ebook.readFile;

import cmcglobal.ebook.entity.Provider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import org.hibernate.mapping.Array;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJSONTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/header.json")) {
            Object obj = jsonParser.parse(reader);

//          doc header từ jsonfile
            System.out.println(obj);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray providerHeader = (JSONArray) jsonObject.get("provider");

            ArrayList<Object> objects = new ArrayList<>();
            for ( Object e:providerHeader
                 ) {
                System.out.println(e);
                objects.add(e);

            }
//          ghi value of object
            Provider provider = new Provider();
            provider.setCode("NXB6");
            provider.setName("Nhà xuất bản thứ 6");
            Provider provider7 = new Provider();
            provider.setCode("NXB7");
            provider.setName("Nhà xuất bản thứ 7");




            System.out.println(provider.getClass());




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ;
    }

    private static   void  parseHeader(){

    }
}
