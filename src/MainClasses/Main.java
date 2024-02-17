package MainClasses;

import Commands.*;

import java.util.*;


public class Main {
    public static final HashMap<String, Command> commands = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Map<Integer, MainClasses.Product> products = new HashMap<>();
        commands.put("help", Help.HELP);
        commands.put("info", Info.INFO);
        //довести вывод до ума
        commands.put("show", Show.SHOW);
        commands.put("add", Add.ADD);
        commands.put("update", Update.UPDATE);
        commands.put("remove", Remove.REMOVE);
        commands.put("clear", Clear.CLEAR);
        commands.put("save", Save.SAVE);
        commands.put("execute_script", Execute_script.EXECUTE_SCRIPT);


        while (true){
            //String input = sc.nextLine();
            String[] splitedInput = sc.nextLine().split(" ");
            //если команда есть в списке вызываем ее без параметров или с параметрами в зависимости от инпута
            if (commands.containsKey(splitedInput[0])){
                if(splitedInput.length==1) {
                    commands.get(splitedInput[0]).execute(System.in);
                }else {
                    commands.get(splitedInput[0]).executeWithParameters(Arrays.copyOfRange(splitedInput, 1, splitedInput.length), System.in);
                }
            }else {
                System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите help для получения доступного списка команд");
            }

        }

    }

}
