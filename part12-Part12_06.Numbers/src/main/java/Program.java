
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many numbers should be printed?");
        int howMany = Integer.valueOf(scanner.nextLine());
        Random r = new Random();
        for(int i = 1; i <= howMany; i++){
            System.out.println(r.nextInt(11));
        }
    }

}
