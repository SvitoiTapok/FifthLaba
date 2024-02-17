package Commands;

import MainClasses.ProductCollection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.json.simple.JSONObject;

import java.io.*;

public class Save implements Command {
    public static final Save SAVE = new Save();

    private Save() {
    }

    @Override
    public void execute(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String json = objectMapper.writeValueAsString(ProductCollection.PRODUCT_COLLECTION.getProducts());
//            System.out.println(System.getenv("NAME5"));
//            System.out.println(System.getenv("FIFTH_LAB_PATH"));
//            System.out.println(System.getenv("PATH"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Lenovo/IdeaProjects/ITMO/FifthLaba/Data/ProductsData.json"));
            String[] splitedJson = json.split("}},");
            for (int i = 0; i<splitedJson.length; i++){
                if(i!=splitedJson.length-1)
                    writer.write(splitedJson[i]+"}},");
                else
                    writer.write(splitedJson[i]);
                writer.newLine();
                writer.flush();
            }

            System.out.println("файл успешно сохранен!");
        } catch (IOException e) {
                System.out.println("ошибка записи файла");
        }
     }
}

