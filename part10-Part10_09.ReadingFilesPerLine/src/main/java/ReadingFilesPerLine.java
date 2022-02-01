
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
        String file = scanner.nextLine();
        read(file);
        
        

    }
    
    public static List<String> read(String file){
        List<String> readFile = new ArrayList<>();
        
        try{
            
            Files.lines(Paths.get(file))
                    .forEach(line -> readFile.add(line));
            
            
        } catch (Exception e){
            System.out.println("oops");
        }
        return readFile;
    }
    
    

}
