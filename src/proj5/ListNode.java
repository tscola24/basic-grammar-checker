package proj5;
/**
 * The ListNode class is more data-specific than the DoublyLinkedList class.  It
 * details what a single node looks like.  This node has one data field holding
 * a string along with pointers to the node in front of it and the node behind it.
 * This is the only class where I'll let you use public instance variables.
 * 
 * @author Chris Fernandes 
 * @version 4/28/25
 */
public class ListNode
{
    public String data;
    public ListNode next;
    public ListNode prev;

    /**
     * non-default constructor
     * @param newData int to hold
     */
    public ListNode(String newData) {
        data = newData;
        next = null;
        prev = null;
    }

    /**
     * get node contents in string form
     * @return data in string format
     */
    public String toString() {
        return data;
    }

}
