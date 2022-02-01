
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        
        while(true){
            String a = scanner.nextLine();
            if(a.isEmpty()){
                printer(inputs);
                break;
            }
            inputs.add(a);
        }      
        
    }
    
    public static void printer(ArrayList<String> source){
        
        source.stream()
                .forEach(name -> System.out.println(name));
        
    }
}