package Commands;

import InnerClasses.Coordinates;
import InnerClasses.Person;
import MainClasses.Product;
import MainClasses.ProductCollection;
import enums.Country;
import enums.EyeColor;
import enums.HairColor;
import enums.UnitOfMeasure;

import java.util.*;

public class Add implements Command{
    public static final Add ADD = new Add();

    private Add(){};

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        Product addedProduct = new Product();
        Person productOwner = new Person();
        Coordinates productCoordinates = new Coordinates();
        int step = 0;
        List<String> messages = new ArrayList<>();
        messages.add("Введите наименование товара(ввод не может быть пустым)");
        messages.add("Введите координаты объекта(координаты могут быть не целыми, они вводятся через пробел, значение x должно быть больше -627, y не должен превышать 677, оба они должны существовать");
        messages.add("Введите цену товара(она может быть не целой, но обязательно положительной)");
        messages.add("Введите единицу измерения товара(введите одно из 3-х слов: kilograms, grams, square_meters");
        messages.add("Введите имя владельца");
        messages.add("Введите ID паспорта владельца(не может быть пустым)");
        messages.add("Введите цвет глаз владельца(введите одно из 3-х слов: green, white, brown");
        messages.add("Введите цвет волос владельца(введите одно из 4-х слов: green, black, orange, white");
        messages.add("Введите национальность владельца(введите одно из 5 слов: united_kingdom, usa, spain, italy, north_korea");





        System.out.println("Начат процесс добавления элемента в коллекцию. Если вы хотите прервать ввод и вернуться к другим командам, введите exit. \nТакже вы можете вернуться к предыдущему параметру, введя z(но будьте осторожны! предыдущее значение будет стерто. Для введения в поле значения null просто введите пустую строку");
        String input;
        while (step != -1 && step!=9){
            try {
                System.out.println(messages.get(step));
                input = sc.nextLine();
                if(input.equals("exit")){
                    step = -1;
                    break;
                }
                if(input.equals("z")){
                    step --;
                    continue;
                }
                switch (step) {
                    //product name
                    case (0):
                        if(!addedProduct.setName(input)){
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
                        if(!productCoordinates.setX(Double.parseDouble(separatedInput[0])))
                            throw new Exception();
                        if(!productCoordinates.setY(Float.parseFloat(separatedInput[1])))
                            throw new Exception();
                        addedProduct.setCoordinates(productCoordinates);
                        step++;
                        break;
                    //product price
                    case (2):
                        addedProduct.setPrice(Float.parseFloat(input));
                        step++;
                        break;
                    case (3):
                        addedProduct.setUnitOfMeasure(UnitOfMeasure.valueOf(input.toUpperCase()));
                        step++;
                        break;
                    case (4):
                        if(input.isEmpty()){
                            addedProduct.setOwner(null);
                            ProductCollection.PRODUCT_COLLECTION.addProducts(addedProduct);
                            step = 9;
                        }else {
                            productOwner.setName(input);
                            step++;
                        }
                        break;
                    case (5):
                        if(input.isEmpty()){
                            throw new Exception();
                        }
                        productOwner.setPassportID(input);
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
                        step ++;
                        addedProduct.setOwner(productOwner);
                        ProductCollection.PRODUCT_COLLECTION.addProducts(addedProduct);

                        break;

                }
                }catch (Exception e){
                    System.out.println("некорректный ввод!");
                }

        }if(step == -1)
            System.out.println("Процесс добавления был прерван, вы вернулись к вводу команд");
        if(step == 9)
            System.out.println("Продукт успешно добавлен");


    }
}
