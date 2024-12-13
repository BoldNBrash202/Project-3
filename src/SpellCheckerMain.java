import java.io.File;
import java.io.FileNotFoundException;
//commented out temp.
//import java.util.Scanner;

/**
 * @Description The SpellCheckerMain class is a Java program that checks spelling 
 *              using two files: a dictionary and an input text. If no files are 
 *              specified, it defaults to "dictionary.txt" and "input.txt". It 
 * '            creates a MySpellChecker object to perform the spell check. If 
 *              files are missing, it asks for valid file names.
 * 
 * @author Ryan Hisel-Schneider
 * @author
 * @version 12/11-13/2024
 */
public class SpellCheckerMain {
    public static void main(String[] args) {
        String fileOne;
        String fileTwo;
        // import the two files from the project into the program.
        // This was a major difficulty because I couldn't figure out 
        // why there were no files being imported.. 
        // they were in the wrong file...
        if (args.length == 0) {
            fileOne = "dictionary.txt";
            fileTwo = "input.txt";
        } else {
            fileOne = args[0];
            fileTwo = args[1];
        }
        MySpellChecker check = null;
        // checks if the file exists, if it doesn't, throw an exception "File not found."
        try {
            File F1 = new File(fileOne);
            File F2 = new File(fileTwo);
            
            check = new MySpellChecker(F1,F2);
        } catch (FileNotFoundException e) {
            System.out.print("File not found. Please enter a valid file name.");
        } finally {
            if (check != null) {
                
            }
        }
    }
}