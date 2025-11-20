package proj5;

/**
 * BinarySearchTree Test Class
 * Author: Theo Scola
 * Ver: 6/5/25
 *
 */
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class BSTTests {
    private BinarySearchTree BST;
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Before
    public void setUp() throws Exception {
        BST = new BinarySearchTree<>();
    }

    @After
    public void tearDown() throws Exception {
        BST = null;
    }

    @Test
    public void testSize0()
    {
        assertEquals("Testing size when size is 0", 0, BST.size());
    }

    @Test
    public void testSize1()
    {
        BST.insert("A");
        assertEquals("Testing size when size is 1", 1, BST.size());
    }

    @Test
    public void testSize2()
    {
        BST.insert("B");
        BST.insert("A");
        BST.insert("C");
        assertEquals("Testing size when size is more than 1", 3, BST.size());
    }

    @Test
    public void testSearch0(){
        assertFalse("Testing search with no elements returns false", BST.search("A"));
    }

    @Test
    public void testSearch1()
    {
        BST.insert("B");
        BST.insert("A");
        BST.insert("C");
        assertTrue("Testing search with correct element returns true", BST.search("A"));
    }

    @Test
    public void testSearch3()
    {
        BST.insert("B");
        BST.insert("A");
        BST.insert("C");
        assertFalse("Testing search with incorrect returns false", BST.search("D"));
    }

    @Test
    public void testToString0()
    {
        assertEquals("Testing toString with no elements", "", BST.toString());
    }

    @Test
    public void testToString1()
    {
        BST.insert("A");
        assertEquals("Testing toString with 1 element", "A\n", BST.toString());
    }

    @Test
    public void testToString2()
    {
        BST.insert("B");
        BST.insert("A");
        BST.insert("C");
        assertEquals("Testing toString with 3 elements", "A\nB\nC\n", BST.toString());
    }

    @Test
    public void testInsert0()
    {
        BST.insert("A");
        assertEquals("Testing inserting with no elements work", "A\n", BST.toString());
    }

    @Test
    public void testInsert1()
    {
        BST.insert("B");
        BST.insert("A");
        BST.insert("C");
        assertEquals("Testing insert correctly inserts 3 elements","A\nB\nC\n", BST.toString());
    }

    @Test
    public void testSearchNonLeafInRightSubtree()
    {
        BST.insert("M");
        BST.insert("V");
        BST.insert("P");
        BST.insert("D");
        BST.insert("N");
        BST.insert("F");
        BST.insert("B");
        BST.insert("C");
        BST.insert("Q");
        BST.insert("R");
        assertTrue("Testing search for Q returns true", BST.search("Q"));
    }

    @Test
    public void testDelete1()
    {
       BST.insert("A");
       BST.delete("A");
       assertEquals("Testing delete works on leaf", "",BST.toString());
    }

    @Test
    public void testDelete2()
    {
        BST.insert("A");
        BST.delete("B");
        assertEquals("Testing delete does not delete incorrect value", "A\n", BST.toString());
    }

    @Test
    public void testDelete3()
    {
        BST.insert("A");
        BST.insert("B");
        BST.insert("C");
        BST.delete("B");
        assertEquals("Testing delete with value with right child", "A\nC\n", BST.toString());
    }

    @Test
    public void testDelete4()
    {
        BST.insert("A");
        BST.insert("C");
        BST.insert("B");
        BST.delete("C");
        assertEquals("Test delete with value with left child", "A\nB\n", BST.toString());
    }

    @Test
    public void testDelete5()
    {
        BST.insert("M");
        BST.insert("D");
        BST.insert("F");
        BST.insert("B");
        BST.insert("C");
        BST.delete("D");
        assertEquals("Test delete with value with two children", "B\nC\nF\nM\n", BST.toString());
    }

    @Test
    public void testGrabData0()
    {
        BST.insert("B");
        BST.insert("A");
        BST.insert("C");
        assertEquals("testing grab data", "A", BST.grabData("A"));
    }

}
