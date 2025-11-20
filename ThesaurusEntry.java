package proj5;
/**
 * Thesaurus Entry Class: represents what is inputted into the Thesaurus ADT.
 * Holds data in a String keyword and a StringBag of synonyms.
 * Author: Theo Scola
 * Ver: 6/5/2025
 */
public class ThesaurusEntry implements Comparable{
    /**
     * INVARIANT:
     *  keyword: Main word of the TE. Used for comparing.
     *  sys: StringBag that holds all the synonyms of keyword.(See StringBag Invariant)
     */
    private String keyword;
    private StringBag syns;

    /**
     * Non-Default constructor
     * @param newKey keyword
     * @param newSyns associated synonyms
     */
    public ThesaurusEntry(String newKey, StringBag newSyns)
    {
        keyword = newKey;
        syns = newSyns;
    }

    /**
     * Non-default constructor (for just a keyword)
     * @param newKey keyword
     */
    public ThesaurusEntry(String newKey)
    {
        keyword = newKey;
        syns = null;
    }

    /**
     * CompareTo method -- compares strings lexicographically
     * @param other the object to be compared.
     * @return pos if this greater than other, neg if other greater than this, 0 if equal
     */
    public int compareTo(Object other)
    {
        if(other.getClass() == ThesaurusEntry.class)
        {
            String otherKey = ((ThesaurusEntry)other).getKey();
            return keyword.compareTo(otherKey);
        }
        else if(other.getClass() == String.class){
            return keyword.compareTo((String)other);
        }
        else {
            return -1;
        }
    }

    /**
     * Getter for the keyword
     * @return keyword
     */
    private String getKey()
    {
        return keyword;
    }

    /**
     * toString method
     * Ex: happy - {joyful, gleeful, ecstatic, etc.}
     * @return string representation of the Thesaurus entry
     */
    public String toString()
    {
        return keyword + " - " + syns.toString();
    }

    /**
     * Adds synonyms to an existing bag of synonyms
     * @param newSyns bag to add
     */
    public void addSynonyms(StringBag newSyns)
    {
        syns.addAll(newSyns);

    }

    /**
     * Returns a synonym from the synonym bag
     * @return random synonym
     */
    public String getSynonym()
    {
        return syns.grab();
    }
}
