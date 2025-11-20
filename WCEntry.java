package proj5;
/**
 * WordCounterEntry class:
 * Author: Theo Scola
 * Ver: 6/4/2025
 */
public class WCEntry implements Comparable {
    /**
     * INVARIANT:
     * This represents the data that is put into the WordCounter
     * word: individual word that is found within text files
     * frequency: amount of times that word appears in the text file
     */
    private String word;
    private int frequency;

    /**
     * Non-Default constructor
     *
     * @param newKey word with associated frequency
     */
    public WCEntry(String newKey) {
        word = newKey;
        frequency = 1;
    }

    /**
     * Getter for the frequency of this entry's word
     *
     * @return frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * getter for word
     * @return word
     */
    public String getWord()
    {
        return word;
    }

    /**
     * CompareTo method
     * @param other the object to be compared.
     * @return pos if this greater than other, neg if other greater than this, 0 if equal
     */
    public int compareTo(Object other) {
        if (other.getClass() == WCEntry.class) {
            String otherWord = ((WCEntry)other).getWord();
            return word.compareTo(otherWord);
        } else if (other.getClass() == String.class) {
            return word.compareTo((String)other);
        }
        else{
            return -1;
        }
    }

    /**
     * Setter for frequency, increments by 1
     */
    public void incrementFrequency()
    {
        frequency++;
    }

    /**
     * toString
     * ex:
     * are: 2
     * @return string representation of WCEntry
     */
    public String toString()
    {
        return word + ": " + frequency;
    }
}
