package proj5;
/**
 * StringBag Test Class
 *
 * Author: Theo Scola
 * Ver: 6/5/25
 * Note: can't predict the output of some of the functions,
 * so just checked size updates for some of the functions
 */
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class StringBagTests {

    StringBag bag;
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Before
    public void setUp() throws Exception{
        bag = new StringBag();
    }

    @After
    public void tearDown() throws Exception{
        bag = null;
    }

    @Test
    public void testConstruct()
    {
        assertNotNull("testing default constructor constructs a bag",bag);
    }

    @Test
    public void testInsert0()
    {
        bag.insert("A");
        assertEquals("testing insert increases size", 1, bag.size());
    }
    @Test
    public void testInsert1()
    {
        bag.insert("A");
        bag.insert("B");
        assertEquals("testing insert twice works as intended", 2, bag.size());
    }

    @Test
    public void testGrab0()
    {
        assertNull("testing grab when bag is empty returns null", bag.grab());
    }
    @Test
    public void testGrab1()
    {
        bag.insert("A");
        assertEquals("testing grab will return an item in the bag", "A", bag.grab());
    }

    @Test
    public void testGrab2()
    {
        bag.insert("A");
        bag.insert("B");
        bag.grab();
        assertEquals("testing grab does not change the bag size", 2, bag.size());
    }

    @Test
    public void testRemove0()
    {
        assertNull("testing remove when empty returns null", bag.remove());
    }

    @Test
    public void testRemove1()
    {
        bag.insert("A");
        assertEquals("testing remove returns correct value", "A", bag.remove());
    }

    @Test
    public void testRemove2()
    {
        bag.insert("A");
        bag.insert("B");
        bag.remove();
        assertEquals("testing remove changes size", 1, bag.size());
    }

    @Test
    public void testEquals0()
    {
        StringBag bag2 = new StringBag();
        assertTrue("testing that two empty bags are equal",bag.equals(bag2));
    }

    @Test
    public void testEquals1()
    {
        StringBag bag2 = new StringBag();
        bag.insert("A");
        bag2.insert("A");
        assertTrue("testing bags of size 1 are equal", bag.equals(bag2));
    }

    @Test
    public void testEquals2()
    {
        StringBag bag2 = new StringBag();
        bag.insert("A");
        bag.insert("B");
        bag2.insert("A");
        bag2.insert("B");
        assertTrue("testing bags of size2 are equal", bag.equals(bag2));
    }

    @Test
    public void testEquals3()
    {
        StringBag bag2 = new StringBag();
        bag.insert("A");
        bag.insert("B");
        bag2.insert("A");
        bag2.insert("C");
        assertFalse("testing unequal bags are not equal", bag.equals(bag2));
    }

    @Test
    public void testClone0()
    {
        bag.insert("A");
        StringBag clone = bag.clone();
        assertTrue("testing clone is equal to bag", bag.equals(clone));
    }
    @Test
    public void testClone1()
    {
        bag.insert("A");
        bag.insert("B");
        StringBag clone = bag.clone();
        clone.remove();
        assertFalse("testing changes to clone don't affect bag", bag.equals(clone));
    }
    @Test
    public void testClone2()
    {
        bag.insert("A");
        bag.insert("B");
        StringBag clone = bag.clone();
        bag.remove();
        assertFalse("testing changes to bag don't affect clone", bag.equals(clone));

    }

    @Test
    public void testAddAll0()
    {
        StringBag bag2 = new StringBag();
        bag.insert("A");
        bag.insert("B");
        bag2.insert("A");
        bag2.insert("C");
        bag.addAll(bag2);
        assertEquals("testing addAll increases size of bag from 2 to 4", 4, bag.size());
    }

    @Test
    public void testAddAll1()
    {
        StringBag bag2 = new StringBag();
        bag.insert("A");
        bag.insert("B");
        bag2.insert("A");
        bag2.insert("C");
        StringBag clone = bag2.clone();
        bag.addAll(bag2);
        assertTrue("testing no changes to bag2 from addAll", bag2.equals(clone));
    }

    @Test
    public void testToString0()
    {
        assertEquals("test empty toString", "{}", bag.toString());
    }

    @Test
    public void testToString1()
    {
        bag.insert("A");
        assertEquals("testing toString with 1 element", "{A}", bag.toString());
    }
}
