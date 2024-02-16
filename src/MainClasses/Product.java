package MainClasses;

import InnerClasses.Coordinates;
import InnerClasses.Person;
import enums.UnitOfMeasure;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class Product implements Comparable<Product>{
    public static long countOfProducts = 1;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле не может быть null, Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле не может быть null

    public Product(String name, Coordinates coordinates, Float price, UnitOfMeasure unitOfMeasure, Person owner) {
        this.id = countOfProducts++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    public Product(){}

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", unitOfMeasure=" + unitOfMeasure +
                ", owner=" + owner +
                '}';
    }

    public boolean setName(String name) {
        if(name == null || name.isEmpty()){
            return false;
        }
        this.name = name;
        return true;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean setPrice(Float price) {
        if(price<=0){
            return false;
        }
        this.price = price;
        return true;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
