public class MyWord implements Comparable<MyWord> {
    protected char[] word;
    MyWord(String word){
        this.word = word.toCharArray();
    }
    @Override
    public int compareTo(MyWord o) {
        // TODO: Implement ignore case sensitivity
        int val = 0;
        int i = 0;
        char[] charArray1 = this.getWord();
        char[] charArray2 = o.getWord();
        val = charArray1.length - charArray2.length; 
        while(val == 0){
            if(charArray1[i]!= charArray2[i]){
                val = (charArray1[i]  < charArray2[i]) ? -1 : 1; 
            }
        i++;
        }
        return val;
    }
    public char[] getWord() {
        return word;
    }
    public boolean equals(MyWord word) {
        return this.compareTo(word) == 0 ? true : false;
    }
    @Override
    public int hashCode() {
        return this.hashCode();
         
    }
    public String getString(){
        String reString = "";
        for (char c : word) {
            reString += c;
        }
        return reString;
    }
    
    
}
