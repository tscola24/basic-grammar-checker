package proj5;

/** BSTNode class.
 * 
 * @author Theo Scola
 * @version 6/2/25
 */
public class BSTNode<E extends Comparable>{

	public E data;
	public BSTNode<E> llink;
	public BSTNode<E> rlink;
	
	/**
	 * non-default constructor
	 * @param newKey E that node will hold
	 */
	public BSTNode(E newKey)
	{
		data = newKey;
		llink = null;
		rlink = null;
	}
	
	/**
	 * returns key as printable string
	 */
	public String toString()
	{
		return String.valueOf(data);
	}

	/**
	 *CompareTo method
	 * @param otherNode the object to be compared.
	 * @return pos if this greater than other, neg if this less than other, 0 if equal
	 */
	public int compareTo(Object otherNode)
	{
		Object otherData = otherNode;
		E thisData = data;
		return thisData.compareTo(otherData);
	}

	/**
	 * Checks to see if this BSTNode is a leaf or not
	 * @return true if yes, false if no
	 */
	public boolean isLeaf()
	{
		if(llink ==  null && rlink == null)
		{
			return true;
		}
		else{
			return false;
		}
	}
}
