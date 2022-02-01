
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();


        while (true) {
            System.out.println("First: " + first.toString());
            System.out.println("Second: " + second.toString());

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            
            switch (command) {
                case "add":
                    first.add(amount);
                    break;
                    
                case "remove":
                    second.remove(amount);
                    break;
                    
                case "move":
                    if(amount > 0){
            
                        if(amount > first.contains()){
                        amount = first.contains();                
                           }
                        second.add(amount);
                         first.remove(amount);
                    break;
                    }
                default:
                    break;
            }

        }
    }

}
