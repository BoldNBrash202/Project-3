import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public class MySpellChecker implements SpellChecker{
    protected MyWord[] words;
    public static HashSet<MyWord> dictionary;

    public MySpellChecker(File F1,File F2) throws FileNotFoundException{
        try(Scanner dictionScan = new Scanner(F1); Scanner fileScan = new Scanner(F2)){
            while(dictionScan.hasNext()){
                dictionary.add(new MyWord(dictionScan.next()));
            }
            int lineNum = 1;
            while(fileScan.hasNextLine()){
                String tempString = fileScan.nextLine();
                MyWord tempMyWord;
                try(Scanner tempScanner = new Scanner(tempString)){
                    tempMyWord = new MyWord(tempScanner.next());
                }
                if(!spellCheck(tempMyWord)){
                    System.out.printf("line: %d /ncheck: %s", lineNum , tempMyWord.getString());

                    
                    System.out.println("1 - Provide correction");
                    System.out.println("2 - Ignore");
                    System.out.println("3 - Ignore All");
                    System.out.println("4 - Add to dictionary");
                    int choose = 3;
                    try (Scanner scanny = new Scanner(System.in)){
                        choose = scanny.nextInt();
                    }

                    switch (choose) {
                        case 1:
                            try(FileWriter writer = new FileWriter(F2)){

                            }
                            catch(IOException e){

                            }
                                break;
                                                
                            case 2:
                                break;
                            case 3:
                                                    
                                break;
                            case 4:
                                dictionary.add(tempMyWord);
                                try( FileWriter dictionWriter = new FileWriter(F1);){

                                }
                                catch(IOException e){
                                    
                                }
                                

                                 break;
                                                    
                        }
                     }
                lineNum++;
             }
         }
                            
     }
    @Override
    public boolean spellCheck(MyWord word) {
        return dictionary.contains(word);
    }

    
}
