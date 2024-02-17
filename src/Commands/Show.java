package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

import java.io.InputStream;

public class Show implements Command{
    public final static Show SHOW = new Show();

    private Show(){}

    @Override
    public void execute(InputStream inputStream){
        if(ProductCollection.PRODUCT_COLLECTION.getProducts().isEmpty()){
            System.out.println("На данный момент в коллекции нет элементов");
            return;
        }
        for(Product product: ProductCollection.PRODUCT_COLLECTION.getProducts()){
            System.out.println(product);
        }
        System.out.println();
    }
}
