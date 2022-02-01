
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while(true){
            String input = scanner.nextLine();
            if(input.equals("end")){
                break;
            }
            numbers.add(Integer.valueOf(input));
        }
        
        
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String yn = scanner.nextLine();
        if(yn.equals("n")){
            
            double average = numbers.stream()
                    .mapToInt(a -> a)
                    .filter(b -> b<0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Average of the negative numbers: " + average);
            
        } else if(yn.equals("p")){
            
            double average = numbers.stream()
                    .mapToInt(a -> a)
                    .filter(b -> b>0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Average of the positive numbers: " + average);
        }
        
        
        

    }
}
