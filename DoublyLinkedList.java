package proj5;  // Gradescope needs this.
/**
 * The doubly linked list class gives you access to the beginning and end of a linked
 * list through instance variables firstNode and lastNode.  This class
 * should contain all the methods for general manipulation of linked lists:
 * traversal, insertion, deletion, searching, etc.
 * 
 * @author Theo Scola
 * @version 05/10/2025
 */
public class DoublyLinkedList
{
    private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node
    private ListNode lastNode;  // pointer to last node

    /**
     * Default Constructor
     */
    public DoublyLinkedList()
    {
        length = 0;
        firstNode = null;
        lastNode = null;
    }

    /**
     * Inserts a new ListNode at the beginning of the LinkedList
     * @param newData data of the new ListNode
     */
    public void insertAtHead(String newData)
    {
        ListNode newNode = new ListNode(newData);
        if(!(isEmpty())) {
            firstNode.prev = newNode;
            newNode.next = firstNode;
            firstNode = newNode;
            length++;
        }
        else{
            firstNode= newNode;
            lastNode = newNode;
            length++;
        }
    }

    /**
     * Inserts a new ListNode at the end of the DoublyLinkedList
     * @param newData data for the new ListNode
     */
    public void insertAtTail(String newData)
    {
        ListNode newNode = new ListNode(newData);
        if(!(isEmpty()))
        {
            lastNode.next = newNode;
            newNode.prev = lastNode;
            lastNode = newNode;
            length++;
        }
        else{
            firstNode = newNode;
            lastNode = newNode;
            length++;
        }
    }

    /**
     * Removes the first ListNode in the DoublyLinkedList
     * @return the String of the data in the ListNode or null if the List is empty
     */
    public String removeHead()
    {
        if(!(isEmpty()) && getLength() > 1) {
            String toRemove = firstNode.data;
            firstNode = firstNode.next;
            firstNode.prev = null;
            length--;
            return toRemove;
        }
        else if(!(isEmpty()))
        {
            String toRemove = firstNode.data;
            firstNode = null;
            lastNode = null;
            length--;
            return toRemove;
        }
        else{
            return null;
        }

    }

    /**
     * Removes the ListNode at the end of the DoublyLinkedList
     * @return the data of the removed node or null if the List is empty
     */
    public String removeTail()
    {
       if(!(isEmpty()) && getLength() >1)
       {
           String toRemove = lastNode.data;
           lastNode = lastNode.prev;
           lastNode.next = null;
           length--;
           return toRemove;

       }
       else if(!(isEmpty()))
       {
           String toRemove = lastNode.data;
           lastNode = null;
           firstNode = null;
           length--;
           return toRemove;
       }
       else{
           return null;
       }
    }

    /**
     * search for first occurrence of value and return index where found
     *
     * @param value String to search for
     * @return index where value occurs (first node is index 0).  Return -1 if value not found.
     */
    public int indexOf(String value) {
        length = getLength();
        if(!(isEmpty())){
            ListNode runner = firstNode;
            for(int i = 0; i<length; i++)
            {
                if(runner.data.equals(value))
                {
                    return i;
                }
                runner = runner.next;
            }
        }
        return -1;
    }

    /**
     * Returns a string representation of the DoublyLinkedList
     * @return toReturn, a string of the whole list formatted "(A,B,C)"
     */
    public String toString()
    {
        String toReturn="(";
        ListNode runner=firstNode;
        while (runner!=null)
        {
            toReturn = toReturn + runner;
            runner=runner.next;
            if (runner!=null)
            {
                toReturn = toReturn + ",";
            }
        }
        toReturn = toReturn + ")";
        return toReturn;
    }

    /**
     * getter for the length of the DoublyLinkedList
     * @return length, the amount of items in the DoublyLinkedList
     */
    public int getLength() { return length;}

    /**
     *
     * @return true if DLL empty or false if not
     */
    public boolean isEmpty() {return getLength()==0;}


    /**
     * getter
     * @return the string for the node at index,
     * return null if empty or if index less than zero/greater than or equal to length
     */
    public String getIthData(int index) {
        if(!(isEmpty()) && index < getLength() && index >= 0)
        {
            ListNode runner = firstNode;
            for(int i = 0; i<index; i++)
            {
                runner = runner.next;
            }
            return runner.data;
        }
        else{
            return null;
        }
    }
}