package Commands;

import InnerClasses.Month;
import MainClasses.ProductCollection;

import javax.xml.crypto.Data;
import java.io.InputStream;

public class Info implements Command{
    public final static Info INFO = new Info();

    private Info(){}

    @Override
    public void execute(InputStream inputStream){
        String[] data = ProductCollection.PRODUCT_COLLECTION.getData().toString().split(" ");

        System.out.println("Коллекция состоит из элементов типа Product, она была создана " +
                data[2] + " " + Month.getMounthTranslation(data[1]) + " " + data[5] + " года в " + data[3] +
                ". На данный момент она содержит " + ProductCollection.PRODUCT_COLLECTION.getLen() + " различных элементов");
    }
}
