
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int rows = 2;
int columns = 3;
int[][] matrix = new int[rows][columns];
matrix[0][1] = 5;
matrix[1][0] = 3;
matrix[1][2] = 7;
System.out.println(arrayAsString(matrix));
    }
    
    public static String arrayAsString(int[][] array){
        
        StringBuilder numbers = new StringBuilder();
        
        for(int x = 0; x < array.length; x++){
            for(int y = 0; y < array[x].length; y++){
                int value = array[x][y];
                numbers.append(value);
            }
            numbers.append("\n");
        }
        return numbers.toString();
    }

}
