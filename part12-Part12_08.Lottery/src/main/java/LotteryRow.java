
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
        
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        Random r = new Random();
        int balls = 0;
        while(balls != 7){
            int draw = r.nextInt(40)+1;
            if(containsNumber(draw)){
                
            } else {
                this.numbers.add(draw);
                balls++;
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        if(this.numbers.contains(number)){
            return true;
        }
        return false;
    }
}

