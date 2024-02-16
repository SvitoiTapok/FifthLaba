package Commands;

import MainClasses.ProductCollection;

public class Show implements Command{
    public final static Show SHOW = new Show();

    private Show(){}

    @Override
    public void execute(){
        System.out.println(ProductCollection.PRODUCT_COLLECTION.getProducts());
    }
}
