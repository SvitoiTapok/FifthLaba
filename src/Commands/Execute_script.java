package Commands;

import InnerClasses.Person;
import MainClasses.Main;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Execute_script implements Command{
    public static final Execute_script EXECUTE_SCRIPT = new Execute_script();
    private Execute_script(){};

    @Override
    public void executeWithParameters(String[] p, InputStream inputStream) {
        if(p.length>1){
            System.out.println("эта функция принимает только один аргумент");
            return;
        }
        String path = System.getenv(p[0]);
        if(path == null){
            System.out.println("системной переменной с именем " + p[0] + " не было найдено");
            return;
        }
        try {
            //FileReader fileReader = new FileReader(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // Создание BufferedReader для буферизации чтения символов
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            HashMap<String, Command> commands = Main.commands;
            String command="";
            while ((command = bufferedReader.readLine())!=null) {
                char letter = (char)inputStreamReader.read();
                if(letter=='\n'){
                    //такой же код, как в main
                    String[] splitedInput = command.substring(0, command.length()-1).split(" ");
                    command = "";
                    if (commands.containsKey(splitedInput[0])){
                        if(splitedInput.length==1) {
                            commands.get(splitedInput[0]).execute(inputStreamReader);
                        }else {
                            commands.get(splitedInput[0]).executeWithParameters(Arrays.copyOfRange(splitedInput, 1, splitedInput.length), inputStreamReader);
                        }
                    }else {
                        System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите help для получения доступного списка команд");
                    }
                }else {
                        command += letter;
                }
                //System.out.print(letter);
            }
            if(!command.equals("")){
                String[] splitedInput = command.split(" ");
                if (commands.containsKey(splitedInput[0])){
                    if(splitedInput.length==1) {
                        commands.get(splitedInput[0]).execute(inputStreamReader);
                    }else {
                        commands.get(splitedInput[0]).executeWithParameters(Arrays.copyOfRange(splitedInput, 1, splitedInput.length), inputStreamReader);
                    }
                }else {
                    System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите help для получения доступного списка команд");
                }
            }

        }catch (IOException e){
            System.out.println("некорректный путь к файлу");
        }catch (SecurityException e){
            System.out.println("пользователь не обладает достаточными правами");
        }
    }
}
//execute_script FIFTH_LAB_PATH
