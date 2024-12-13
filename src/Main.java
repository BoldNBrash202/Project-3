import java.io.File;
import java.io.FileNotFoundException;
//commented out temp.
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
        File F1 = new File(args[0]);
        File F2 = new File(args[1]);
        MySpellChecker check = new MySpellChecker(F1,F2);
        } catch (FileNotFoundException e) {
            System.out.print("File not found. Please enter a valid file name.");
        } if (ArrayIndexOutOfBoundsException) {
            catch (FileNotFoundException f) {
                System.out.println("Array index is out of bounds. Please enter a valid index and try again.");
            }
        }


    }
}