package proj5;

/**
 * WordCounter Class: class for computing word frequencies from a text file
 *
 * Author: Theo Scola
 * Ver: 6/3/25
 */
public class WordCounter {
    /**
     * INVARIANT:
     * BST: internal representation of the WordCounter
     * Words can only be inserted into the WordCounter through findFrequencies.
     * Frequencies of each word can be returned
     */
    private BinarySearchTree<WCEntry> BST;

    /**
     * Default constructor
     */
    public WordCounter()
    {
        BST = new BinarySearchTree<>();
    }

    /**
     * Computes frequency of each word in given file
     * @param file given file
     */
    public void findFrequencies(String file)
    {
        LineReader LR = new LineReader(file, " ");

        String[] tempArray = LR.getNextLine();
        while(tempArray != null) {
            for (int i = 0; i < tempArray.length; i++) {
                if(isLetter(tempArray[i].charAt(0))) {
                    tempArray[i] = stripPunctuation(tempArray[i]);
                    WCEntry newEntry = new WCEntry(tempArray[i]);
                    insert(newEntry);
                }
            }
            tempArray = LR.getNextLine();
        }
    }

    /**
     * Helper for findFrequencies
     * @param entry new word to insert
     */
    private void insert(WCEntry entry)
    {
        if(BST.search(entry))
        {
            WCEntry existing = BST.grabData(entry);
            existing.incrementFrequency();
        }
        else{
            BST.insert(entry);
        }
    }

    /**
     * Helper for findFrequencies
     * @param unStripped String to potentially strip
     * @return stripped or unchanged string
     */
    private String stripPunctuation(String unStripped)
    {
        int length = unStripped.length();
        char lastChar = unStripped.charAt(length-1);
        if(isLetter(lastChar))
        {
            return unStripped;
        }
        else{
            String toReturn = "";
            for(int i =0 ; i< length-1; i++)
            {
                toReturn+=unStripped.charAt(i);
            }
            return toReturn;
        }
    }

    /**
     * Helper for stripPunctuation
     * @param c character to check if it is a letter
     * @return true if is letter, false if not
     */
    private boolean isLetter(char c)
    {
        char[] letters = {'a','b','c','d','e','f','g','h','i','j',
                'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] capitals = {'A','B','C','D','E','F','G','H','I','J',
                'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i = 0; i< letters.length; i++)
        {
            if(c == letters[i] || c == capitals[i])
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the frequency of a given word
     * @param word word to find frequency of
     * @return frequency of word
     */
    public int getFrequency(String word){
        WCEntry toGetFreq = new WCEntry(word);
        if(BST.search(toGetFreq))
        {
            WCEntry entry = BST.grabData(toGetFreq);
            return entry.getFrequency();
        }
        else{
            return 0;
        }

    }

    /**
     * toString
     * For example,
     *  computer: 3
     *  jail: 2
     * @return returns words and their frequencies as a printable String
     */
    public String toString(){
        return BST.toString();
    }
}
