
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class UserInterface {
    
    private TodoList list;
    private Scanner scanner;
    
    public UserInterface (TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start(){
        while(true){
            System.out.println("Command: ");
            String command = scanner.nextLine();
            
            if(command.equals("stop")){
                break;
            }
            
            switch (command) {
                case "add":
                    System.out.println("To add:");
                    String task = scanner.nextLine();
                    list.add(task);
                    break;
                case "list":
                    list.print();
                    break;
                case "remove":
                    System.out.println("Which one is removed?");
                    int remove = Integer.valueOf(scanner.nextLine());
                    list.remove(remove);
                    break;
                default:
                    break;
            }
            
            
        }
    }
    
}
