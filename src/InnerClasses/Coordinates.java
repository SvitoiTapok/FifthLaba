package InnerClasses;

public class Coordinates {
    private double x; //Значение поля должно быть больше -627
    private Float y; //Максимальное значение поля: 677, Поле не может быть null

    public Coordinates(double x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    public boolean setX(double x) {
        if(x<=-627)
            return false;
        this.x = x;
        return true;
    }
    public boolean setY(Float y) {
        if(y>677 || y==null)
            return false;
        this.y = y;
        return true;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
