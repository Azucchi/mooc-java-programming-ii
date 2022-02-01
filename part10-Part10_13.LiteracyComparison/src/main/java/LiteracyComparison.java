
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        ArrayList<Literacy> data = new ArrayList<>();
        String file = "literacy.csv";        
       
        try{            
            Files.lines(Paths.get(file))
                    .map(line -> line.split(","))
                    .map(parts -> new Literacy(parts[3], parts[4].trim(), parts[2], Double.valueOf(parts[5])))
                    .forEach(country -> data.add(country));
            
        } catch (IOException e){
            System.out.println("oops");
        }
        
        data.sort((p1, p2) -> Double.compare(p1.getLiteracy(), p2.getLiteracy()));
        data.stream()
                .forEach(country -> System.out.println(country));
        
        

    }
}
