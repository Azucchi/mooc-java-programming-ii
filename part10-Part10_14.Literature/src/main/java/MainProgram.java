
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Book> bookshelf = new ArrayList<>();
        
        while(true){
            System.out.println("Input the name of the book, empty stops: ");
            String input1 = scanner.nextLine();
            if(input1.isEmpty()){
                
                print(bookshelf);
                break;
                
            } else {
                System.out.println("Input the age recommendation: ");
                int input2 = Integer.valueOf(scanner.nextLine());
                bookshelf.add(new Book(input1, input2));
            }
            
        }
        

    }
    
    public static void print(List<Book> bookshelf){
        System.out.println(bookshelf.size() + " books in total.");
        
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getBook);
        
        Collections.sort(bookshelf, comparator);
        
        System.out.println("Books:");
        bookshelf.stream()
                .forEach(book -> 
                        System.out.println(book.getBook() + " (recommended for " + book.getAge() + " year-olds or older)")
                
                );             
        
    }
    
    

}
