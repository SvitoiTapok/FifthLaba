package Commands;

import InnerClasses.Person;
import MainClasses.Product;
import MainClasses.ProductCollection;

import java.io.InputStream;
import java.util.List;

public class Update implements Command{
    public static final Update UPDATE = new Update();
    private Update(){};


    @Override
    public void executeWithParameters(String[] p, InputStream inputStream) {
        if(p.length>1){
            System.out.println("эта функция принимает только один аргумент");
            return;
        }
        try{
            if(Long.parseLong(p[0]) <= 0)
                throw new Exception();
        }catch (Exception e){
            System.out.println("пожалуйста, введите валентный id элемента(он должен быть натуральным числом)");
            return;
        }
        long id = Long.parseLong(p[0]);
        Product updatedProduct = Product.createProduct(id, inputStream);
        ProductCollection.PRODUCT_COLLECTION.addProduct(updatedProduct);

        //два варианта: id уже существует и id не существует

    }
}
