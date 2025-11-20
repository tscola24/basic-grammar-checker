package proj5;
/**
 *
 *  Theo Scola
 *  Ver: 06/4/2025
 *  I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus
 *  Deque: Creates an ADT that has two accessible sides, left and right.
 *      The only accessible items in the deque are the first elements in the left and right ends.
 *      Left and right ends can add a new element or remove the current element.
 */


public class Deque {

    /**
     * Invariant:
     * 1. Capacity represents the capacity of the Deque, only changed by trimToSize and ensureCapacity
     * 2. DLL represents how the Data is held in a doublyLinkedList.
     *      It should only be accessed when adding, removing, or getting elements
     */

    private int capacity;
    private DoublyLinkedList DLL;

    private final int INITIAL_CAPACITY = 10;

    /**
     * Creates a new deque with initial capacity 10.
     */
    public Deque() {
        DLL = new DoublyLinkedList();
        capacity = INITIAL_CAPACITY;
    }

    /**
     * Creates a new deque.
     *
     * @param initialCapacity the initial capacity of the deque.
     */
    public Deque(int initialCapacity) {
        DLL = new DoublyLinkedList();
        capacity = initialCapacity;
    }

    /**
     * inserts a String on the left of the deque.
     * If this cannot be done because the deque has
     * reached its capacity, the deque will
     * expand to twice its current capacity plus 1
     * to accommodate the new entry.
     *
     * @param value the String to add.
     */
    public void addLeft(String value) {
        if (size() == getCapacity()) {
            int expandedSize = DLL.getLength() * 2 + 1;
            ensureCapacity(expandedSize);
        }
        DLL.insertAtHead(value);
    }

    /**
     * inserts a String on the right of the deque.
     * If this cannot be done because the deque has
     * reached its capacity, the deque will
     * expand to twice its current capacity plus 1
     * to accommodate the new entry.
     *
     * @param value the String to add.
     */
    public void addRight(String value) {
        if (size() == getCapacity()) {
            int expandedSize = DLL.getLength() * 2 + 1;
            ensureCapacity(expandedSize);
        }
        DLL.insertAtTail(value);
    }

    /**
     * Remove and return the left item from the deque.  Return
     * null if the deque is empty.
     */
    public String removeLeft() {
        if (!(isEmpty())) {
            String temp = leftMost();
            DLL.removeHead();
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Remove and return the right item from the deque.  Return
     * null if the deque is empty.
     */
    public String removeRight() {
        if (!(isEmpty())) {
            String temp = rightMost();
            DLL.removeTail();
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Places the contents of another deque in order at the right
     * end of this deque.  For example, if this deque is {A,B} and
     * the other deque is {B,C,D}, addAll will change this deque
     * to be {A,B,B,C,D}.
     * If adding all elements of the other deque would exceed the
     * capacity of this deque, the capacity is changed to make
     * exactly enough room for all the elements to be added.
     * Postcondition: NO SIDE EFFECTS!  the other deque should be left
     * unchanged.
     *
     * @param otherDeque the deque whose contents should be added.
     */
    public void addAll(Deque otherDeque) {
        ensureCapacity(size() + otherDeque.size());
        Deque tempDeque = otherDeque.clone();
        while (!tempDeque.isEmpty()) {
            addRight(tempDeque.removeLeft());
        }
    }

    /**
     * Make a copy of this deque.  Changes to the copy
     * do not affect the current deque, and vice versa.
     * Postcondition: NO SIDE EFFECTS!  This deque's leftmost
     * and rightmost elements should remain unchanged.
     *
     * @return the copy of this deque.
     */
    public Deque clone() {
        Deque newDeque = new Deque(getCapacity());
        for (int i = 0; i < size(); i++) {
            String removed = removeLeft();
            newDeque.addRight(removed);
            addRight(removed);
        }
        return newDeque;
    }


    /**
     * Change the capacity of this deque to minCapacity
     * if it doesn't already have that much capacity. Does
     * nothing if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the deque
     *                    should now have.
     */
    public void ensureCapacity(int minCapacity) {
        capacity = getCapacity();
        if (capacity < minCapacity) {
            capacity = minCapacity;
        }
    }

    /**
     * Getter for the amount of data this deque can potentially hold.
     *
     * @return the capacity of the deque.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the leftmost element in the deque without
     * altering the deque itself.
     *
     * @return the leftmost element in the deque, or
     * null if deque is empty
     */
    public String leftMost() {
        int head = 0;
        return DLL.getIthData(head);
    }

    /**
     * Returns the rightmost element in the deque without
     * altering the deque itself.
     *
     * @return the rightmost element in the deque, or
     * null if deque is empty
     */
    public String rightMost() {
        int tail = size() - 1;
        return DLL.getIthData(tail);
    }


    /**
     * Getter for the amount of data this deque currently holds.
     *
     * @return the number of elements stored in the deque.
     */
    public int size() {
        return DLL.getLength();
    }


    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize() {
        capacity = size();
    }

    /**
     * Produce a left-to-right string representation of this deque.
     * For example, a deque of three elmts with capacity 5 with "A" as its leftmost elmt,
     * "C" as its rightmost elmt, and "B" in the middle would produce this string:
     * {A, B, C} (capacity = 5)
     * The string you create should be formatted like the above example,
     * with a comma and space following each element, no comma following the
     * last element, and all on a single line. An empty deque
     * should give back "{}" followed by its capacity.
     *
     * @return a string representation of this deque.
     */
    public String toString() {
        String toReturn = "{";
        Deque clone = clone();
        String[] stringList = new String[clone.size()];
        int lastElementIndex = stringList.length - 1;
        for (int i = 0; i < stringList.length; i++) {
            stringList[i] = (String)clone.removeLeft();
            if (i < lastElementIndex) {
                toReturn += stringList[i] + ", ";
            }
        }
        if (stringList.length != 0) {

            toReturn += stringList[lastElementIndex];
        }
        toReturn += "} " + "(capacity = " + getCapacity() + ")";

        return toReturn;

    }

    /**
     * Checks whether another deque is equal to this one.  To be
     * considered equal, both deques must have exactly the same
     * elements in the same order.  The capacity can differ.
     * <p>
     * NO SIDE EFFECTS!  Both this deque and the other deque
     * must be the same at the end of this method as they were
     * at the start of this method.
     *
     * @param other the other Deque with which to compare
     * @return true iff the other Deque is equal to this one. Else false.
     */
    public boolean equals(Deque other) {
        boolean equals = true;
        Deque thisClone = clone();
        Deque otherClone = other.clone();
        int thisSize = thisClone.size();
        int otherSize = otherClone.size();
        if (thisSize != otherSize) {
            return false;
        }
        for (int i = 0; i < thisSize; i++) {
            if (!(thisClone.removeLeft().equals(otherClone.removeLeft()))) {
                equals = false;
            }
        }
        return equals;
    }

    /**
     * @return true if deque empty, else false
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * empty the deque
     */
    public void clear() {
        DLL = new DoublyLinkedList();
    }
}
