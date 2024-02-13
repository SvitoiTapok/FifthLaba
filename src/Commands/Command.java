package Commands;

public interface Command {
    default public void execute(){
        System.out.println("у этой команды нет реализации выполнения без параметров");
    };
    default public void executeWithParameters(String[] p){
        System.out.println("у этой команды нет реализации выполнения c параметрами");
    };

}
