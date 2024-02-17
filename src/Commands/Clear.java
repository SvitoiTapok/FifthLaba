package Commands;

import MainClasses.ProductCollection;

import java.io.InputStream;

public class Clear implements Command{
    public final static Clear CLEAR = new Clear();



    private Clear(){};

    @Override
    public void execute(InputStream inputStream) {
        ProductCollection.PRODUCT_COLLECTION.clearCollection();
        System.out.println("Коллекция очищена");
    }
}
