import Commands.Command;
import Commands.CommandInfo;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Map<Integer, Product> products = new HashMap<>();
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("commandInfo", CommandInfo.COMMAND_INFO);


        while (true){
            //String input = sc.nextLine();
            String[] splitedInput = sc.nextLine().split(" ");
            //если команда есть в списке вызываем ее без параметров или с параметрами в зависимости от инпута
            if (commands.containsKey(splitedInput[0])){
                if(splitedInput.length==1) {
                    commands.get(splitedInput[0]).execute();
                }else {
                    commands.get(splitedInput[0]).executeWithParameters(Arrays.copyOfRange(splitedInput, 1, splitedInput.length));
                }
            }else {
                System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите commandInfo для получения доступного списка команд");
            }

        }
    }
}
