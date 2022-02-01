
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();
        
        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            
            if (input < 0){
                printer(inputs);
                break;
            }
            
            inputs.add(input);
        }
        

    }
    
    public static void printer(ArrayList<Integer> inputs){
        inputs.stream()
                .filter(number -> number > 0 && number < 6)
                .forEach(number -> System.out.println(number));
    }
}
