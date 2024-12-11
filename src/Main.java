import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File F1 = new File(args[0]);
        File F2 = new File(args[1]);
        MySpellChecker check = new MySpellChecker(F1,F2);
    }
}