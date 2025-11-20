package proj5;

/**
 * WordCounter Test Class
 *
 * Author: Theo Scola
 * Ver: 6/5/25
 *
 */
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class WCTests {
    WordCounter WC;
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Before
    public void setUp() throws Exception{
        WC = new WordCounter();
    }

    @After
    public void tearDown() throws Exception{
        WC = null;
    }

    @Test
    public void testConstruct()
    {
        assertNotNull("test constructor works", WC);
    }

    @Test
    public void testFindFrequencies()
    {
        WC.findFrequencies("src/apartment.txt");
        System.out.println(WC);
    }

    @Test
    public void testGetFrequencies0()
    {
        WC.findFrequencies("src/apartment.txt");
        assertEquals("testing get frequencies returns correct num",
                7, WC.getFrequency("was"));
    }

    @Test
    public void testGetFrequencies1()
    {
        WC.findFrequencies("src/apartment.txt");
        assertEquals("testing get frequencies with word not in WC", 0, WC.getFrequency("awesome"));
    }

    @Test
    public void testGetFrequencies2()
    {
        assertEquals("testing get frequencies with empty WC", 0, WC.getFrequency("awesome"));
    }
}
