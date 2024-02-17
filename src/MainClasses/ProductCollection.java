package MainClasses;
import InnerClasses.Coordinates;
import InnerClasses.Person;
import enums.UnitOfMeasure;
import java.util.*;

public class ProductCollection {
    public final static ProductCollection PRODUCT_COLLECTION = new ProductCollection();
    private LinkedHashSet<Product> products = new LinkedHashSet<>();
    private Map<Long, Product> productID = new HashMap<>();
    private Date data;

    private ProductCollection(){
        data = new Date();
        //возможно здесь будет чтение из файла
        //tests data
        Product product1 = new Product("Sdafasda", new Coordinates(100,100f), 100f, UnitOfMeasure.GRAMS, new Person());
        Product product2 = new Product("Sasha", new Coordinates(100,100f), 100f, UnitOfMeasure.GRAMS, new Person());
        Product product3 = new Product("Sasha", new Coordinates(100,100f), 100f, UnitOfMeasure.GRAMS, new Person());
        products.add(product1);
        products.add(product2);
        products.add(product3);
        productID.put(product1.getId(), product1);
        productID.put(product2.getId(), product2);
        productID.put(product3.getId(), product3);

    }

    public LinkedHashSet<Product> getProducts() {
        return products;
    }

    public Map<Long, Product> getProductID() {
        return productID;
    }

    public void addProduct(Collection<Product> p){
        products.addAll(p);
        for(Product product: p){
            productID.put(product.getId(), product);
        }
    }

    public void addProduct(Product p){
        products.removeIf(x -> x.getId() == p.getId() && productID.containsKey(x.getId()));
        products.add(p);
        productID.put(p.getId(), p);
    }
    public void removeProduct(long id){
        products.removeIf(x -> x.getId() == id && productID.containsKey(x.getId()));
        productID.remove(id);
    }

    public Date getData() {
        return data;
    }
    public int getLen(){
        return products.size();
    }
    public void clearCollection(){
        products.clear();
        productID.clear();
    }
}
