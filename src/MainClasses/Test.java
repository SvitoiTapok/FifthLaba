package MainClasses;

import InnerClasses.Person;
import enums.HairColor;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(8);
        set.addAll(Stream.of(1).collect(Collectors.toSet()));
        System.out.println(set);
        long x = 456454564564L;
        for (int i = 0; i<12;i++) {
            Date data = new Date(456454564564L+ i * 2592000000L);
            System.out.println(data);
        }
        //System.out.println(HairColor.valueOf(null));
        ProductCollection person = ProductCollection.PRODUCT_COLLECTION;
        System.out.println(person);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            objectMapper.writeValue(new File("Data/ProductsData.json"), person.getProducts());

        }catch (Exception e){
            e.printStackTrace();
        }
        Cat cat = new Cat();
        xx(cat);
        System.out.println(cat.getName());

    }
    public static void xx(Cat cat){
        cat.setName("adfsas");
    }
}
class Cat{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


class Main {
    public static void main(String[] args) {
        try {
            // Создание InputStream для чтения данных из файла, например
            InputStream inputStream = new FileInputStream("example.txt");

            // Создание PushbackInputStream для сохранения исходного InputStream
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);

            // Создание InputStreamReader для чтения символов из PushbackInputStream
            InputStreamReader inputStreamReader = new InputStreamReader(pushbackInputStream);

            // Создание BufferedReader для буферизации чтения символов
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Считывание строки из BufferedReader
            String line = bufferedReader.readLine();

            // Печать считанной строки
            System.out.println("Прочитанная строка: " + line);

            // Проверка на конец файла
            if (line == null) {
                System.out.println("Достигнут конец файла.");
            }

            // Возвращение символов обратно в поток
            pushbackInputStream.unread(line.getBytes());

            // Закрытие потоков
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
