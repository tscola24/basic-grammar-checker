package proj5;
/**
 * WordCounterEntry Test Class
 *
 * Author: Theo Scola
 * Ver: 6/5/25
 *
 */
import org.junit.*;
import org.junit.After;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class WCEntryTests {
    WCEntry WCE1;
    WCEntry WCE2;

    @Rule
    public Timeout timeout =  Timeout.millis(100);

    @After
    public void tearDown(){
        WCE1 = null;
        WCE2 = null;
    }

    @Test
    public void testCompareTo0()
    {
        WCE1 = new WCEntry("happy");
        WCE2 = new WCEntry("sad");
        assertTrue("testing compareTo returns correctly",  WCE1.compareTo(WCE2) < 0);
    }

    @Test
    public void testCompareTo1()
    {
        WCE1 = new WCEntry("zinc");
        String word = "gang";
        assertTrue("testing compareTo when inputting a string", WCE1.compareTo((Object)word) > 0);
    }

    @Test
    public void testToString0()
    {
        WCE1 = new WCEntry("burger");
        assertEquals("testing toString", "burger: 1", WCE1.toString());
    }

}
