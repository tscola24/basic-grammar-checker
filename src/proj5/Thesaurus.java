package proj5;
/**
 * Thesaurus Class: Data structure that holds words and their associated synonyms.
 * You can look up a word and retrieve a synonym for it.
 *
 * Author: Theo Scola
 * Ver: 6/5/2025
 */
public class Thesaurus {
    /**
     * INVARIANT:
     * BST: BinarySearchTree that holds all the data in the Thesaurus,
     *  only changed with insert() and delete().
     */

    private BinarySearchTree<ThesaurusEntry> BST;

    /**
     * Default Constructor
     */
    public Thesaurus(){
        BST = new BinarySearchTree<>();
    }

    /**
     * Non-default constructor
     * @param file file to build thesaurus off of
     */
    public Thesaurus(java.lang.String file){
        BST = new BinarySearchTree<>();
        LineReader LR = new LineReader(file, ",");

        String[] tempArray = LR.getNextLine();
        while(tempArray != null)
        {
            String keyword = tempArray[0];
            String[] syns = new String[tempArray.length-1];
            for(int i = 1; i< tempArray.length; i++) {
                syns[i-1] = (tempArray[i]);
                //using i-1 because tempArray is 1 larger than syns
            }
            insert(keyword, syns);
            tempArray = LR.getNextLine();
        }
    }

    /**
     * inserts entry and synonyms into thesaurus.
     * If entry does not exist, it creates one.
     * If it does exist, it adds the given synonyms to the entry's synonym list
     * @param entry keyword
     * @param syns synonyms of keyword
     */
    public void insert(String entry, String[] syns)
    {
        StringBag synonymsBag = new StringBag();
        for(String synonym: syns)
        {
            synonymsBag.insert(synonym);
        }
        ThesaurusEntry newEntry = new ThesaurusEntry(entry, synonymsBag);
        if(BST.search(newEntry))
        {
            ThesaurusEntry existing = BST.grabData(newEntry);
            existing.addSynonyms(synonymsBag);
        }
        else {
            BST.insert(newEntry);
        }
    }

    /**
     * Deletes an entry from the Thesaurus
     * @param entry keyword to delete
     */
    public void delete(String entry)
    {
        ThesaurusEntry toDelete = new ThesaurusEntry(entry);
        BST.delete(toDelete);
    }

    /**
     * returns a random synonym for a keyword
     * @param keyword to find a synonym for
     * @return a random synonym from its connected list
     */
    public String getSynonymFor(String keyword){
        ThesaurusEntry toGet = new ThesaurusEntry(keyword);
        ThesaurusEntry entry = BST.grabData(toGet);
        if(entry == null)
        {
            return "";
        }
        else{
            return entry.getSynonym();
        }
    }

    /**
     * toString method:
     * @return returns a string representation of the Thesaurus
     */
    public String toString(){
        return BST.toString();
    }

    /**
     * Checks to see if keyword is in the Thesaurus
     * @param keyword to search for
     * @return true if in, false if not
     */
    public boolean contains(String keyword)
    {
        ThesaurusEntry toFind = new ThesaurusEntry(keyword);
        return BST.search(toFind);
    }
}
