import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;

/**
 *  @description The MoviesMain class is a Java program that reads movie data from CSV files 
 *              and lets users list or search for movies through a simple menu. It uses the 
 *              Movies class to manage movie details.
 * 
 * @author 
 * @author Ryan Hisel-Schneider
 * 
 * @version 12/13/2024
 * @issues : some variables have no accurate declaration, 
 *           lines 41, and 49.
 */
public class MoviesMain {
    public static void main(String[] args) {
        // makes a list with generic type Movies
        List<Movies> myMap = new ArrayList<>();
        // scanners to pull in the values for the rasitings and movie titles
        Scanner movieScanner;
        Scanner ratingScanner;
        if(args[0].equalsIgnoreCase("Large")){
            movieScanner = new Scanner(new File("ml-32m/movies.csv")) ;
            ratingScanner = new Scanner(new File("ml-32m/ratings.csv")) ;
        }
        else{
            movieScanner = new Scanner(new File("ml-latest-small/movies.csv")) ;
            ratingScanner = new Scanner(new File("ml-latest-small/ratings.csv")) ;
        }
        int choice;
        Scanner scanny = new Scanner(System.in);
        choice = scanny.nextInt();
        // start checkinig if theres are more raitings to fetch.
        boolean stillGoing = true;
        while(stillGoing == true){
            switch(choice){
                // TODO# add what case 1 does here
                case 1:
                
                for(int i = 0; i < userNumber; i++){
                    System.out.print(i+1 + ". " + myMap.get(i).toString() );
                }

            break;

            // TODO# <<add what case 2 does here>>
            case 2:
            int count = 1;
                for (int i = 0; i < args.length; i++) {
                    if(myMap.get(i).getMovieName() == userString){
                        System.out.print(count + ". " + myMap.get(i).toString() );
                        count++;
                    }
                }
                break;

            // TODO# <<add what case 3 does here>>
            case 3:
                break;

            // TODO# <<add what case 4 does here>>
            case 4:
                stillGoing = false;
                break;
            }
        }  
        // closure  of the scanner.
        scanny.close();
    }
}