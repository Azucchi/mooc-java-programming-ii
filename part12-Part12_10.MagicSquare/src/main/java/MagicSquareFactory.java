
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        
        //put 1 in center upper square:
        square.placeValue(size/2, 0, 1);
        //tracks current position as well as current number to be placed:
        int xPosition = size/2;
        int yPosition = 0;
        int nextNumber = 2;
        //loop until done:
        int numbersPlaced = 1;
        while(numbersPlaced != size*size){
            //move up, move right:
            xPosition++;
            yPosition--;
            //respect square boundaries:
            if(xPosition > square.getWidth()-1){
                xPosition = 0;
            }
            if(yPosition < 0){
                yPosition = square.getHeight()-1;
            }            
            //check if next position has value already
            boolean contains = square.readValue(xPosition, yPosition) != 0;
            //if next position contains value already, revert position and go down.
            if(contains){
                yPosition++;
                xPosition--;
                //if out of bounds, go to original position
                if(yPosition > square.getHeight()-1){
                    yPosition = 0;
                }
                if(xPosition < 0){
                    xPosition = square.getWidth()-1;
                }
                //go down once;
                yPosition++;                
                //place value in below box:
                square.placeValue(xPosition, yPosition, nextNumber);
                //increment next number by 1 then continue loop
                nextNumber++;
                numbersPlaced++;
            } else {
                //if next position is empty:
                square.placeValue(xPosition, yPosition, nextNumber);
                nextNumber++;
                numbersPlaced++;
            }          
            
        }

        return square;
    }

}
