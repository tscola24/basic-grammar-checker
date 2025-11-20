package proj5;
/**
 * GrammarChecker Class: Uses a thesaurus and word frequencies to
 *  replace overused words in a text document with random synonyms.
 *
 * Author: Theo Scola
 * Ver: 6/3/25
 *  I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 *  accordance with the Union College Honor Code and the course syllabus.
 *
 */
public class GrammarChecker {
    private Thesaurus T;
    private WordCounter WC;
    private int maximum;


    /**
     * Non-default constructor
     * @param thesaurusFile file to feed to the thesaurus
     * @param threshold maximum frequency of words that the get replaced
     */
    public GrammarChecker(String thesaurusFile, int threshold)
    {
        T = new Thesaurus(thesaurusFile);
        WC = new WordCounter();
        maximum = threshold;
    }

    /**
     * Given a text file, replaces overused words with synonyms.
     * Finished text is printed to the console.
     * @param textfile file to improve
     */
    public void improveGrammar(String textfile)
    {
        WC.findFrequencies(textfile);
        LineReader LR = new LineReader(textfile, " ");

        String[] words = LR.getNextLine();
        String toPrint = "";
        String punctuation;
        while(words != null) {
            for (int i = 0; i < words.length; i++) {
                if(isLetter(words[i].charAt(0))) {
                    punctuation = "";
                    char lastChar = words[i].charAt(words[i].length()-1);
                    if(!isLetter(lastChar)) {
                        punctuation = String.valueOf(lastChar);
                        words[i] = stripPunctuation(words[i]);
                    }
                    if(WC.getFrequency(words[i]) > maximum)
                    {
                        if(T.contains(words[i]))
                        {
                            words[i] = T.getSynonymFor(words[i]);
                        }
                        toPrint += words[i] + punctuation + " ";
                    }
                    else{
                        toPrint += words[i] + punctuation + " ";
                    }
                }
                else{
                    toPrint += words[i] + " ";
                }
            }
            words = LR.getNextLine();
        }
        System.out.println(toPrint);

    }

    /**
     * Helper for grammar checker
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
}
