package proj5;
/**
 * Thesaurus Test Class
 *
 * Author: Theo Scola
 * Ver: 6/5/25
 *
 * Note: just checked output for some of the tests rather than assert
 */
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class ThesaurusTests {
    Thesaurus T;
    @Rule
    public Timeout timeout = Timeout.millis(1000);

    @Before
    public void setUp() throws Exception{
        T = new Thesaurus();
    }

    @After
    public void tearDown() throws Exception{
        T = null;
    }

    @Test
    public void testDefaultConstructor()
    {
        assertNotNull("Testing that the constructor makes a Thesaurus", T);
    }

    @Test
    public void testNonDefaultConstructor()
    {
        Thesaurus newT = new Thesaurus("src/smallThesaurus.txt");
        assertNotNull("Testing that nondefault constructor makes a Thesaurus", newT);
        System.out.println(newT);
    }

    @Test
    public void testGeneral()
    {
        //Just making sure that it prints correctly
        String[] syns1 = new String[2];
        syns1[0] = "gleeful";
        syns1[1] = "joyful";
        T.insert("happy",syns1);
        String[] syns2 = new String[3];
        syns2[0] = "glum";
        syns2[1] = "depressing";
        syns2[2] = "melancholy";
        T.insert("sad",syns2);
        System.out.println(T);
    }

    @Test
    public void testDelete0()
    {
        String[] syns1 = new String[2];
        syns1[0] = "gleeful";
        syns1[1] = "joyful";
        T.insert("happy",syns1);
        String[] syns2 = new String[3];
        syns2[0] = "glum";
        syns2[1] = "depressing";
        syns2[2] = "melancholy";
        T.insert("sad",syns2);
        T.delete("sad");
        System.out.println(T);
    }

    @Test
    public void testInsertWhenExisting()
    {
        String[] syns1 = new String[2];
        syns1[0] = "gleeful";
        syns1[1] = "joyful";
        T.insert("happy",syns1);
        String[] syns2 = new String[1];
        syns2[0] = "joyous";
        T.insert("happy", syns2);
        System.out.println(T);
    }

    @Test
    public void testGetSynonymFor0()
    {
        assertEquals("testing getSynonym for empty thesaurus returns empty String", "",T.getSynonymFor("happy"));
    }

    @Test
    public void testGetSynonymFor1()
    {
        String[] syns1 = new String[1];
        syns1[0] = "gleeful";
        T.insert("happy",syns1);
        assertEquals("testing getSynonym returns a synonym", "gleeful", T.getSynonymFor("happy"));
    }

    @Test
    public void testGetSynonymFor2()
    {
        String[] syns1 = new String[1];
        syns1[0] = "gleeful";
        T.insert("happy",syns1);
        assertEquals("testing getSynonym for a non-empty Thesaurus with incorrect entry returns empty string"
               ,"", T.getSynonymFor("sad"));
    }

}
