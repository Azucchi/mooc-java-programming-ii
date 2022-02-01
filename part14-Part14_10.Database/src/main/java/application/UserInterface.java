package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        OUTER:
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");
            System.out.print("> ");
            String command = this.scanner.nextLine();
            switch (command) {
                case "x":
                    break OUTER;
            // implement the functionality here
                case "1":
                    list();
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    markAsDone();
                    break;
                case "4":
                    remove();
                    break;
                default:
                    break;
            }
        }

        System.out.println("Thank you!");
    }
    
    private void list() throws SQLException{
        System.out.println("Listing the database contents");
        List<Todo> thingsToDo = database.list();
        thingsToDo.stream()
                .forEach(task -> {
                    System.out.println(task.toString());
                });
    }
    
    private void add() throws SQLException{
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String nameOfTask = scanner.nextLine();
        System.out.println("Enter description");
        String newTaskDescription = scanner.nextLine();
        
        this.database.add(new Todo(nameOfTask, newTaskDescription, false));
    }
    
    private void markAsDone() throws SQLException{
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        this.database.markAsDone(id);
    }
    
    private void remove() throws SQLException{
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        this.database.remove(id);
    }

}
