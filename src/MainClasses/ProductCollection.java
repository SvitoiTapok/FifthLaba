package MainClasses;
import InnerClasses.Coordinates;
import InnerClasses.Person;
import enums.UnitOfMeasure;
import org.json.simple.JSONObject;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class ProductCollection {
    public final static ProductCollection PRODUCT_COLLECTION = new ProductCollection();
    private LinkedHashSet<Product> products = new LinkedHashSet<>();
    private Date data;

    private ProductCollection(){
        data = new Date();
        //возможно здесь будет чтение из файла
        //tests data
        products.add(new Product("Sasha", new Coordinates(100,100f), 100f, UnitOfMeasure.GRAMS, new Person()));

    }

    public LinkedHashSet<Product> getProducts() {
        return products;
    }
    public void addProducts(Collection<Product> p){
        products.addAll(p);
    }
    public void addProducts(Product p){products.add(p);}

    public Date getData() {
        return data;
    }
    public int getLen(){
        return products.size();
    }
}
