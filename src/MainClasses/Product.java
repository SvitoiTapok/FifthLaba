package MainClasses;

import InnerClasses.Coordinates;
import InnerClasses.Person;
import enums.Country;
import enums.EyeColor;
import enums.HairColor;
import enums.UnitOfMeasure;

import java.io.BufferedReader;
import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Product implements Comparable<Product> {
    public static long countOfProducts = 1;
    public static ArrayList<Long> ID = new ArrayList<>();
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле не может быть null, Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле не может быть null

    public Product(String name, Coordinates coordinates, Float price, UnitOfMeasure unitOfMeasure, Person owner) {
        while (ID.contains(countOfProducts))
            countOfProducts++;
        this.id = countOfProducts++;
        ID.add(id);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    public Product(long id){
        this.id = id;
        ID.add(id);
        this.creationDate = ZonedDateTime.now();
    }
    public Product() {
        while (ID.contains(countOfProducts))
            countOfProducts++;
        this.id = countOfProducts++;
        ID.add(id);
        this.creationDate = ZonedDateTime.now();
    }

    @Override
    public int compareTo(Product p) {
        if (p.name.equals(name))
            return 0;
        String[] a = {p.name, this.name};
        List<String> list = Arrays.stream(a).sorted().toList();
        if (list.get(0).equals(p.name))
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
        if (name == null || name.isEmpty()) {
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
        if (price <= 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public long getId() {
        return id;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public static long getCountOfProducts() {
        return countOfProducts;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public static ArrayList<Long> getID() {
        return ID;
    }

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }


    //если мы создаем продукт с не заданным id, передаем null
    public static Product createProduct(Long id, InputStream inputStream) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(inputStream));
        Product addedProduct;
        if (id == null) {
            addedProduct = new Product();
        }
        else
            addedProduct = new Product(id);
        Person productOwner = new Person();
        Coordinates productCoordinates = new Coordinates();
        int step = 0;
        List<String> messages = new ArrayList<>();
        messages.add("Введите наименование продукта(ввод не может быть пустым)");
        messages.add("Введите координаты объекта(координаты могут быть не целыми, они вводятся через пробел, значение x должно быть больше -627, y не должен превышать 677, оба они должны существовать");
        messages.add("Введите цену продукта(она может быть не целой, но обязательно положительной)");
        messages.add("Введите единицу измерения продукта(введите одно из 3-х слов: kilograms, grams, square_meters");
        messages.add("Введите имя владельца");
        messages.add("Введите ID паспорта владельца(не может быть пустым)");
        messages.add("Введите цвет глаз владельца(введите одно из 3-х слов: green, white, brown");
        messages.add("Введите цвет волос владельца(введите одно из 4-х слов: green, black, orange, white");
        messages.add("Введите национальность владельца(введите одно из 5 слов: united_kingdom, usa, spain, italy, north_korea");


        System.out.println("Пожалуйста, следуйте указаниям по вводу, чтобы создать новый продукт. Если вы хотите прервать ввод и вернуться к другим командам, введите exit. \nТакже вы можете вернуться к предыдущему параметру, введя z(но будьте осторожны! предыдущее значение будет стерто. Для введения в поле значения null просто введите пустую строку");
        String input="";
        while (step != -1 && step != 9) {
            try {
                System.out.println(messages.get(step));
                input = sc.readLine();
                if (input.equals("exit")) {
                    step = -1;

                    break;
                }
                if (input.equals("z")) {
                    step--;
                    continue;
                }
                switch (step) {
                    //product name
                    case (0):
                        if (!addedProduct.setName(input)) {
                            throw new Exception();
                        }
                        step++;
                        break;
                    //product coordinates
                    case (1):
                        String[] separatedInput = input.split(" ");
                        if (!(separatedInput.length == 2)) {
                            throw new Exception();
                        }
                        if (!productCoordinates.setX(Double.parseDouble(separatedInput[0])))
                            throw new Exception();
                        if (!productCoordinates.setY(Float.parseFloat(separatedInput[1])))
                            throw new Exception();
                        addedProduct.setCoordinates(productCoordinates);
                        step++;
                        break;
                    //product price
                    case (2):
                        if (!addedProduct.setPrice(Float.parseFloat(input)))
                            throw new Exception();
                        step++;
                        break;
                    case (3):
                        addedProduct.setUnitOfMeasure(UnitOfMeasure.valueOf(input.toUpperCase()));
                        step++;
                        break;
                    case (4):
                        if (!productOwner.setName(input))
                            throw new Exception();
                        step++;
                        break;
                    case (5):
                        if (!productOwner.setPassportID(input))
                            throw new Exception();
                        step++;
                        break;
                    case (6):
                        productOwner.setEyeColor(EyeColor.valueOf(input.toUpperCase()));
                        step++;
                        break;
                    case (7):
                        productOwner.setHairColor(HairColor.valueOf(input.toUpperCase()));
                        step++;
                        break;
                    case (8):
                        productOwner.setNationality(Country.valueOf(input.toUpperCase()));
                        step++;
                        addedProduct.setOwner(productOwner);
                        //ProductCollection.PRODUCT_COLLECTION.addProducts(addedProduct);

                        break;

                }
            } catch (Exception e) {
                System.out.println("некорректный ввод!");
            }

        }
        if (step == -1) {
            System.out.println("Процесс добавления был прерван, вы вернулись к вводу команд");

            return null;
        }else {
            System.out.println("Продукт успешно создан");
            return addedProduct;
        }
    }
}
