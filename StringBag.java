package proj5;

import java.util.Random;

/**
 * StringBag ADT
 * Author: Theo Scola
 * Ver: 6/5/2025
 */
public class StringBag {
    /**
     * INVARIANT:
     * deque represents the underlying ADT that will hold all the data in Bag.
     * All of deque's code/Invariant can be seen in the attatched Deque class
     */
    private Deque deque;

    /**
     * Default Constructor
     */
    public StringBag()
    {
        deque = new Deque();
    }

    /**
     * inserts a new String into the bag
     * @param value to insert
     */
    public void insert(String value)
    {
        deque.addRight(value);
    }

    /**
     * grabs(but doesn't remove) a random value
     * @return grabbed value
     */
    public String grab()
    {
        if(!isEmpty())
        {
            shuffle();
        }
        return deque.leftMost();
    }

    /**
     * removes a random value
     * @return removed value
     */
    public String remove()
    {
        if(!isEmpty())
        {
            shuffle();
        }
        return deque.removeLeft();
    }

    /**
     * Returns the number of items in the bag
     * @return size
     */
    public int size()
    {
        return deque.size();
    }

    /**
     * Returns a Boolean of if the bag is empty or not
     * @return if bag is empty or not
     */
    public boolean isEmpty()
    {
        return deque.isEmpty();
    }

    /**
     * Adds all values from otherBag to this bag, does not change otherBag
     * @param otherBag bag to add values from
     */
    public void addAll(StringBag otherBag)
    {
        StringBag clone = otherBag.clone();
        int size = clone.size();
        for(int i = 0; i<size; i++)
        {
            deque.addLeft(clone.remove());
        }
    }

    /**
     * Clone method - clones the current StringBag and returns it
     * @return clone - the cloned Bag
     */
    public StringBag clone()
    {
        Deque cloneDeque = deque.clone();
        StringBag clone = new StringBag();
        int size = cloneDeque.size();
        for(int i = 0; i<size; i++)
        {
            clone.insert(cloneDeque.removeLeft());
        }

        return clone;
    }

    /**
     * Equals method
     * @param otherBag otherBag to check if equal with this bag
     * @return true if equal, false if not
     */
    public boolean equals(StringBag otherBag)
    {
        if(isEmpty() && otherBag.isEmpty())
        {
            return true;
        }
        int thisSize = size();
        int otherSize = otherBag.size();
        if(thisSize == otherSize) {
            StringBag thisClone = clone();
            StringBag otherClone = otherBag.clone();
            String[] thisArray = new String[thisSize];
            String[] otherArray = new String[otherSize];
            boolean found = false;

            for(int i = 0; i<thisSize; i++)
            {
                thisArray[i] = thisClone.remove();
                otherArray[i] = otherClone.remove();
            }
            for(String thisItem: thisArray)
            {
                found = false;
                for(String otherItem: otherArray)
                {
                    if(thisItem != null && otherItem != null) {
                        if (thisItem.equals(otherItem)) {
                            found = true;
                            thisItem = null;
                            otherItem = null;
                        }
                    }
                }
                if(found == false)
                {
                    return false;
                }
            }
            return found;
        }
        else{
            return false;
        }
    }

    /**
     * toString method
     * ex: {A, B, C}
     * @return string representation of the bag
     */
    public String toString()
    {
        if(!isEmpty()) {
            String toReturn = "{";
            StringBag clone = clone();
            int size = clone.size();
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    toReturn += clone.remove() + ", ";
                }
            }
            toReturn += clone.remove() + "}";
            return toReturn;
        }
        else{
            return "{}";
        }
    }


    /**
     * Helper method to randomize the bag
     */
    private void shuffle()
    {
        Random gen = new Random();
        int times = gen.nextInt(deque.size());
        for(int i = 0; i<times; i++)
        {
            deque.addRight(deque.removeLeft());
        }
    }

}
