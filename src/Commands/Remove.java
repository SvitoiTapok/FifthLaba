package Commands;

import MainClasses.ProductCollection;

import java.io.InputStream;

public class Remove implements Command{
    public final static Remove REMOVE = new Remove();
    private Remove(){}

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
        ProductCollection.PRODUCT_COLLECTION.removeProduct(id);
        System.out.println("объект с id=" + id + "(если такой был) удален");
    }
}
