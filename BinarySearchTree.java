package proj5;

import java.lang.annotation.ElementType;

/**
 * BinarySearchTree class
 * Author: Theo Scola
 * Ver: 6/2/25
 */

public class BinarySearchTree<E extends Comparable>
{
    /**
     * INVARIANT:
     *  root: Original BSTNode in the tree. Essentially is the tree.
     *  BST can be changed using insert and delete. BST can be searched for elements
     *  and the elements internal data can be returned.
     */
    private BSTNode<E> root;

    /**
     * Constructor
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * inserts recursively.
     *
     * @param subroot inserts into subtree rooted at subroot
     * @param newNode node to insert
     * @return the BST rooted at subroot that has newNode inserted
     */
    private BSTNode<E> insert(BSTNode<E> subroot, BSTNode<E> newNode) {
        if (subroot == null) {
            return newNode;
        }
        else if (newNode.compareTo(subroot.data) > 0) {
            subroot.rlink = insert(subroot.rlink,newNode);
            return subroot;
        }
        else {  // newNode.data smaller than subroot.data, so newNode goes on left
            subroot.llink = insert(subroot.llink,newNode);
            return subroot;
        }
    }

    /**
     * inserts recursively.
     *
     * @param value E to insert
     */
    public void insert(E value){
        BSTNode<E> newNode = new BSTNode(value);
        root = insert(root, newNode);
    }

    /**
     * Search for specified element
     * @param target to find
     * @return true or false if found or not found
     */
    public boolean search(E target)
    {
        if(size()>0) {
            return search(target, root);
        }
        else{
            return false;
        }
    }

    /**
     *Recursive search for specified element
     * @param target specified element
     * @param subtree Recursive BSTNode
     * @return true or false if found or not found
     */
    private boolean search(E target, BSTNode<E> subtree)
    {
        if(subtree == null)
        {
            return false;
        }
        else if(subtree.compareTo(target) == 0) {
            return true;
        }
        else{
            if(subtree.compareTo(target)>0)
            {
                return search(target, subtree.llink);
            }
            else{
                return search(target, subtree.rlink);
            }
        }
    }

    /**
     * toString method
     * @return a String representation of the BST
     */
    public String toString()
    {
        return toString(root);
    }

    /**
     * Recursive toString
     * @param subroot Recursive BSTNode
     * @return a String representation of the BST
     */
    private String toString(BSTNode<E> subroot)
    {
        if(subroot == null)
        {
            return "";
        }
        else{
            String toReturn = "";
            toReturn += toString(subroot.llink);
            toReturn += subroot.toString() + "\n";
            toReturn += toString(subroot.rlink);
            return toReturn;
        }
    }

    /**
     * Returns the size of the BST
     * @return int representing how many elements are in BST
     */
    public int size()
    {
        return size(root);
    }

    /**
     * Returns the size of the BST
     * @param subroot Recursive BSTNode
     * @return int representing how many elements are in BST
     */
    private int size(BSTNode<E> subroot)
    {
        if(subroot == null)
        {
            return 0;
        }
        else{
            int size = 1;
            size += size(subroot.llink);
            size += size(subroot.rlink);
            return size;
        }
    }

    /**
     * Recursive delete
     * @param value value to be deleted
     */
    public void delete(E value)
    {
        root = delete(root, value);
    }

    /**
     * Recursive Delete
     * @param subroot recursive BSTNode
     * @param value to be deleted
     * @return a BSTNode that represents the updated tree
     */
    private BSTNode<E> delete(BSTNode<E> subroot, E value){
        if(subroot == null)
        {
            return null;
        }
        else if(subroot.compareTo(value) > 0)
        {
            subroot.llink = delete(subroot.llink, value);
            return subroot;
        }
        else if(subroot.compareTo(value) < 0) {
            subroot.rlink = delete(subroot.rlink, value);
            return subroot;
        }
        else{
            if(subroot.isLeaf())
            {
                return null;
            }
            else if(subroot.rlink != null && subroot.llink == null)
            {
                return subroot.rlink;
            }
            else if(subroot.llink != null && subroot.rlink == null)
            {
                return subroot.llink;
            }
            else{
                BSTNode<E> replacement = findSuccessor(subroot.rlink);
                subroot.data = replacement.data;
                subroot.rlink = delete(subroot.rlink, replacement.data);
                return subroot;
            }
        }
    }

    /**
     * Helper method for Delete.
     * Finds the successor for the deleted node if the node has two children
     * @param subroot recursive BSTNode
     * @return the BSTNode for the successor
     */
    private BSTNode<E> findSuccessor(BSTNode<E> subroot)
    {
        if(subroot.llink == null)
        {
            return subroot;
        }
        else{
            return findSuccessor(subroot.llink);
        }
    }

    /**
     * Recursive method
     * Essentially Search, but returns the data rather than a boolean
     * (only called after target has been confirmed to be in the BST,
     *  don't want to call search again in this method)
     * @param target value to return
     * @return data of target
     */
    public E grabData(E target)
    {
        return grabData(target, root);
    }

    /**
     * Recursive method
     * Essentially Search, but returns the data rather than a boolean
     * @param target value to return
     * @param subtree recursive BSTNode
     * @return data of target
     */
    private E grabData(E target,BSTNode<E> subtree)
    {
        if(subtree == null)
        {
            return null;
        }
        else if(subtree.compareTo(target) == 0) {
            return subtree.data;
        }
        else{
            if(subtree.compareTo(target)>0)
            {
                return grabData(target, subtree.llink);
            }
            else{
                return grabData(target, subtree.rlink);
            }
        }
    }


    /** recursive helper for toStringParen
     * 
     * @param subroot root of subtree to start at
     * @return inorder string of elements in this subtree
     */
    private String toStringParen(BSTNode subroot) {
  	  if (subroot == null) // base case
  		  return "";
  	  else
  		  return "(" + toStringParen(subroot.llink) + " " +
                  subroot.toString() + " " + toStringParen(subroot.rlink) + ")";
    }
    
    /**
     * returns string showing tree structure using parentheses, as shown in class
     */
    public String toStringParen() {
  	  return toStringParen(root);
    }
}