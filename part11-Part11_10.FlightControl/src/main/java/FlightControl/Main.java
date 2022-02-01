package FlightControl;

import FlightControl.logic.FlightControl;
import FlightControl.ui.TextUI;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
    //TextUI(FlightControl flightControl, Scanner scanner
    FlightControl fc = new FlightControl();
    Scanner s = new Scanner(System.in);
    TextUI ui = new TextUI(fc,s);
    ui.start();
    }
}
