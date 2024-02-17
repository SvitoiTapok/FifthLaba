package Commands;

import InnerClasses.Coordinates;
import InnerClasses.Person;
import MainClasses.Product;
import MainClasses.ProductCollection;
import enums.Country;
import enums.EyeColor;
import enums.HairColor;
import enums.UnitOfMeasure;

import java.io.InputStream;
import java.util.*;

public class Add implements Command{
    public static final Add ADD = new Add();

    private Add(){};

    @Override
    public void execute(InputStream inputStream) {
        Product product = Product.createProduct(null, inputStream);
        if(product!=null){
            ProductCollection.PRODUCT_COLLECTION.addProduct(product);
        }
    }
}
