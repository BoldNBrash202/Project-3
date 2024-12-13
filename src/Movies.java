import java.util.List;
import java.util.Scanner;
/**
 * @description this is the movie class used by the MovieMain class.
 * 
 * @author 
 * @author Ryan Hisel-Schneider
 * @version 12/13/2024
 * 
 */

public class Movies {
    private int numberOfRatings;
    private int id;
    private String name;
    private List<String> genres;
    private double trueRating;
    private double weightedAverageRating;
    
    /**
     * Adds a new rating to the movie, updating the true rating.
     * Increments the number of ratings and recalculates the true rating
     * as the average of all ratings received. If the number of ratings
     * exceeds 5, additional logic can be implemented.
     * @author 
     * @version 12/13/2024
     *
     * @param currentRatting The new rating to be added.
     */
    public Movies(String inputString){
        // Start of the try block, to try  scanning for an id, name, and genera.
        try(Scanner inputScan = new Scanner(inputString);){
        inputScan.useDelimiter(",");
        // is an int
        id = inputScan.nextInt();
        // is a string
        name = inputScan.next();
        inputScan.useDelimiter("|");
        while(inputScan.hasNext()){
            // is also a string (these are just for me to help remember (Ryan..))
            genres.add(inputScan.next());
        }
    }

    /**
     * Adds a new rating to the movie, updating the true rating.
     * Increments the number of ratings and recalculates the true rating
     * as the average of all ratings received. If the number of ratings
     * exceeds 5, additional logic can be implemented.
     *
     * @param currentRatting The new rating to be added.
     */
    }   
    public void addRating(double currentRatting){
        numberOfRatings++;
        trueRating += currentRatting;
        trueRating /= numberOfRatings;
        if (numberOfRatings > 5){
            
        }
    }

    /**
     * Retrieves the unique identifier of the movie.
     * @author
     * @version 12/13/2024
     *
     * @return The movie's ID as an integer.
     */
    public int getId() {
        return id;
    }

    
    /**
     * Retrieves the name of the movie.
     * @author 
     * @version 12/13/2024
     *
     * @return The name of the movie as a String.
     */
    public String getMovieName(){
        return name;
    }

    /**
     * Retrieves the list of genres associated with the movie.
     * @author
     * @version 12/13/2024
     *
     * @return A list of genre names as strings.
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Compares the weighted average rating with the true rating.
     * @author Ryan Hisel-Schneider
     * @version 12/13/2024
     *
     * @param firstRatingRatingPassedIn The first rating value passed in for comparison.
     * @param secondRatingPassedIn The second rating value passed in for comparison.
     * @return An integer result of the comparison between the weighted average rating and the true rating.
     */
    public int compareTo(double firstRatingRatingPassedIn, double secondRatingPassedIn) {
        // returns the comparison result (int) from the weighted average and the true average
        return Double.compare(weightedAverageRating, trueRating);
    }


}
