package Commands;

import java.io.InputStream;

public interface Command {
    default public void execute(InputStream inputStream){
        System.out.println("у этой команды нет реализации выполнения без параметров");
    };
    default public void executeWithParameters(String[] p, InputStream inputStream){
        System.out.println("у этой команды нет реализации выполнения c параметрами");
    };

}
