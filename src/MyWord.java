/**
 * @Description This is the MyWord class that powers the spellchecker classes 
 * 
 * @author
 * @author Ryan Hisel-Schneider
 * 
 * @version 12/10-13/2024
 */
public class MyWord implements Comparable<MyWord> {
    protected char[] word;
    MyWord(String word){
        this.word = word.toCharArray();
    }

    /**
     * Compares this MyWord object with the specified MyWord object for order.
     * The comparison is based on the lexicographical order of the character arrays.
     * 
     * @author
     * @version 12/13/2024
     * 
     * @param o the MyWord object to be compared
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(MyWord o) {
        // TODO: Implement ignore case sensitivity
        int val = 0;
        int i = 0;
        char[] charArray1 = this.getWord();
        char[] charArray2 = o.getWord();
        val = charArray1.length - charArray2.length; 
        // loop while there are elements to index 
        while (val == 0) {
            if (charArray1[i] != charArray2[i]){
                val = (charArray1[i]  < charArray2[i]) ? -1 : 1; 
            }
        i++;
        }
        return val;
    }    public char[] getWord() {
        return word;
    }

    /**
     * Computes the hash code for this MyWord object.
     * 
     * @author Ryan Hisel-Schneider
     * @author
     * @version 12/13/2024
     * 
     * @return the hash code based on the string representation of the word
     */
    // public boolean equals(MyWord word) {
    //     return this.compareTo(word) == 0 ? true : false;
    // }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Converts the character array 'word' into a String.
     * @author
     * @version 12/12/2024
     *
     * @return a String representation of the 'word' character array
     */
    public String getString(){
        String reString = "";
        for (char c : word) {
            reString += c;
        }
        return reString;
    }

    /**
     * Compares this MyWord object with the specified object for equality.
     * 
     * @param obj the object to compare with
     * @return true if the specified object is equal to this MyWord object; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // check the equality of the object after converting to string.
        return this.toString().equals(obj.toString());
    }

    /**
     * this is just a simple to string method.
     * 
     * @author 
     * @version 12/13/2024
     *
     * @return the string representation of the word
     */
    @Override
    public String toString() {
        return this.getString();
    }
}
