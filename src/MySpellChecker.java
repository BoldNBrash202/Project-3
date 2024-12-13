import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @description The MySpellChecker class checks if words are spelled correctly using a dictionary file. 
 *              It reads words from two files, checks them, and lets users correct or ignore mistakes. 
 * '            It can also add new words to the dictionary and save changes.
 * 
 * @author Ryan Hisel-Schneider
 * @author 
 * @version 12/12/2024
 */
    public class MySpellChecker implements SpellChecker{
    protected ArrayList<MyWord> wordsFromFileInMemory;
    protected ArrayList<String> listOfDictionaryWordsToWriteToDisk = new ArrayList<>();
    public static HashSet<MyWord> dictionaryOfCorrectWords = new HashSet<MyWord>();
    private int currentLineCounter = 1;
    private Scanner getUserInput = new Scanner(System.in);


    /**
     * Checks if a given word is present in the dictionary of correct words.
     * @author 
     * @author Ryan Hisel-Schneider
     * @version 12/10/2024
     *
     * @param word The word to be checked.
     * @return true if the word is in the dictionary, false otherwise.
     */
    public MySpellChecker(File F1,File F2) throws FileNotFoundException{
        try{
            Scanner fileScanner = new Scanner(F1);
            while(fileScanner.hasNext()){
                dictionaryOfCorrectWords.add(new MyWord(fileScanner.next()));
            }
            fileScanner = new Scanner(F2);
            int lineNum = 1;
            while(fileScanner.hasNextLine()) {
                String currentLineInFile = fileScanner.nextLine();
                MyWord currentWordInFile;

                //try(Scanner tempScanner = new Scanner(currentLineInFile)) {
                //    currentWordInFileAsMyWord = new MyWord(tempScanner.next());
                //}

                String[] wordsInCurrentLine = currentLineInFile.split(" ");
                for (int i = 0; i < wordsInCurrentLine.length; i++) {
                    currentWordInFile = new MyWord(wordsInCurrentLine[i]);
                    if (!spellCheck(currentWordInFile)) {
                        // this is what prints out the actual user prompt (This should be a 1:1 copy of the handout...)
                        System.out.printf("Line %d: %s\n", currentLineCounter, currentLineInFile);
                        System.out.println("check: " + wordsInCurrentLine[i]);
                        System.out.println("1 - Provide correction");
                        System.out.println("2 - Ignore");
                        System.out.println("3 - Ignore All");
                        System.out.println("4 - Add to dictionary");
                        System.out.print("># ");
                        switch (getUserInput.nextInt()) {
                            case 1:
                                try(FileWriter writer = new FileWriter(F2)){

                                }
                                catch(IOException e){

                                }
                            break;
                            // #TODO check to see if this should be a break or continue
                            case 2:
                                continue;
                            case 4:
                                listOfDictionaryWordsToWriteToDisk.add(currentLineInFile);
                            case 3:
                                dictionaryOfCorrectWords.add(currentWordInFile);    
                                break; 
                        }
                    }
                }
                // TODO# Check this I think its breaking optios 1 and 2...
                //if(!spellCheck(currentWordInFile)) {
                    //System.out.printf("line: %d /ncheck: %s", lineNum , currentWordInFile.getString());
                    int choose = 3;
                    try (Scanner scanny = new Scanner(System.in)){
                        choose = scanny.nextInt();
                    }
                lineNum++;
                } 
        fileScanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Writes spelling corrections to a specified file on disk.
     * @author Ryan Hisel-Schneider
     * @version 12/12/2024
     *
     * @param fileName the name of the file to write the spelling corrections to
     * 
     * / I hate this method specifically 
     */
    public void writeSpellingCorrectionsToDisk(String fileName) {
        // make a print writer to write to a file 
        PrintWriter writeToFile = null;
        try {
            writeToFile = new PrintWriter(new File(fileName));
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        } finally {
            if (writeToFile != null) {
                writeToFile.close();
            }
        }
    }

    /**
     * Adds a new word to the dictionary of correct words if it is not already present.
     * @author Ryan Hisel-Schneider
     * @version 12/12/2024
     *
     * @param s The word to be added to the dictionary.
     */
    public void addToDictionary(String s) {
        if (dictionaryOfCorrectWords.contains(new MyWord(s))) {
        } else {
            dictionaryOfCorrectWords.add(new MyWord(s));
        }
    }

    /**
     * Checks if a given word is present in the dictionary of correct words.
     * @author 
     * @version 12/10/2024
     *
     * @param word The word to be checked.
     * @return true if the word is in the dictionary, false otherwise.
     */
    @Override
    public boolean spellCheck(MyWord word) {
        return dictionaryOfCorrectWords.contains(word);
    }
}
