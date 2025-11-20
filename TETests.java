package proj5;
/**
 * ThesaurusEntry Test Class
 *
 * Author: Theo Scola
 * Ver: 6/5/25
 *
 */
import org.junit.*;
import org.junit.After;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class TETests {
    ThesaurusEntry TE1;
    ThesaurusEntry TE2;

    @Rule
    public Timeout timeout =  Timeout.millis(100);

    @After
    public void tearDown(){
        TE1 = null;
        TE2 = null;
    }

    @Test
    public void testCompareTo0()
    {
        TE1 = new ThesaurusEntry("happy");
        TE2 = new ThesaurusEntry("sad");
        assertTrue("testing compareTo returns correctly",  TE1.compareTo(TE2) < 0);
    }

    @Test
    public void testCompareTo1()
    {
        StringBag bag1 = new StringBag();
        bag1.insert("joyful");
        TE1 = new ThesaurusEntry("happy", bag1);
        TE2 = new ThesaurusEntry("sad");
        assertTrue("testing compareTo returns correctly",  TE1.compareTo(TE2) < 0);
    }

    @Test
    public void testCompareTo2()
    {
        StringBag bag1 = new StringBag();
        bag1.insert("joyful");
        StringBag bag2 = new StringBag();
        bag2.insert("glum");
        TE1 = new ThesaurusEntry("happy", bag1);
        TE2 = new ThesaurusEntry("sad", bag2);
        assertTrue("testing compareTo returns correctly",  TE2.compareTo(TE1) > 0);
    }

    @Test
    public void testCompareTo3()
    {
        TE1 = new ThesaurusEntry("zinc");
        String word = "gang";
        assertTrue("testing compareTo when inputting a string", TE1.compareTo((Object)word) > 0);
    }

    @Test
    public void testToString0()
    {
        StringBag bag1 = new StringBag();
        bag1.insert("sandwich");
        TE1 = new ThesaurusEntry("burger", bag1);
        assertEquals("testing toString", "burger - {sandwich}", TE1.toString());
    }

}
