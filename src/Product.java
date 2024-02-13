import enums.UnitOfMeasure;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Product implements Comparable<Product>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int price; //Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле может быть null

    public Product(Integer id, String name, Coordinates coordinates, Date creationDate, int price, UnitOfMeasure unitOfMeasure, Person owner) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }

    @Override
    public int compareTo(Product p) {
        if(p.name.equals(name))
            return 0;
        String [] a = {p.name, this.name};
        List<String> list = Arrays.stream(a).sorted().toList();
        if(list.get(0).equals(p.name))
            return -1;
        else
            return 1;
    }
}
