package projectFour;

import java.util.NoSuchElementException;

/**
 * This class represents my own implementation of a Binary Search Tree.
 * 
 * @author Brandon Herrera
 * @version 04/22/2017
 *
 * @param <E>
 * 	Type of objects to be stored in MyBST.
 * 
 */
public class MyBST <E extends Comparable <E>> {
	
	//data fields
	protected BSTNode <E> root;
	protected int size;
	protected String collec = "";
	
	/**
	 * This method adds the specified element to this BST if it
	 * is not already present.
	 * 
	 * @param e
	 * 	element to be added to this set
	 * @return
	 * 	true if element was added
	 * 	false if element was not added
	 * @throws ClassCastException
	 * 	if the specified object cannot be compared with the
	 *  elements currently in this set
	 * @throws NullPointerException
	 * 	if the specified element is null
	 * 
	 */
	public boolean add (E e) throws ClassCastException {
		//if the element is null throw exception
		if (e == null) {
			throw new NullPointerException("Can not add a null element.");
		}
		//if this is the first element being added 
		if (root == null) {
			//create new node to set as new root
			BSTNode <E> newNode = new BSTNode <E> (e);
			this.root = newNode;
			size+=1;
			return true;
		}
		//otherwise, send to recursive helper method
		return recAdd(this.root, e);
	}
	
	/**
	 * This is a recursive helper method that helps add the specified
	 * element in the right location of the BST.
	 * 
	 * @param node
	 * 	Node currently being looked at
	 * @param newData
	 * 	specified element being added to BST
	 * @return
	 *  true if element was added
	 *  false if element already exists in BST
	 *  
	 */
	private boolean recAdd (BSTNode <E> node, E newData) {
		//if element is already present 
		if(node.getData().compareTo(newData) == 0) {
			return false;
		//compare current node data with newData 
		} else if (newData.compareTo(node.getData()) < 0) {
			//if newData less than current and current.left is empty
			if (node.getLeft()==null) {
				//add element as node left child
				node.setLeft(new BSTNode <E> (newData));
				size += 1;
				return true;
			}
			//otherwise, keep checking
			return recAdd(node.getLeft(), newData);
		//if newData is greater than current.data
		} else {
			//if right child is empty
			if (node.getRight()==null) {
				node.setRight(new BSTNode <E> (newData));
				size += 1;
				return true;
			}
			//otherwise, keep looking
			return recAdd(node.getRight(), newData);
		}
	}
	
	/**
	 * This method removes the specified element if it is present.
	 * 
	 * @param o
	 * 	object to be removed if present
	 * @return
	 * 	true if this BST contained the specified element
	 *  false otherwise
	 * @throws ClassCastException
	 * 	if the specified object cannot be compared with elements currently in BST
	 * @throws NullPointerException
	 * 	if the specified element is null
	 * 
	 */
	public boolean remove (Object o) throws ClassCastException {
		if (o == null) {
			throw new NullPointerException("Can not specify a null element.");
		}
		@SuppressWarnings("unchecked")
		E ob = (E) o;
		//if object was not present in BST
		if (recRemove(this.root, ob) == null) {
			return false;
		} else {
			//send to recursive helper
			root = recRemove(this.root, ob); 
			size-=1;
			return true;
		}
	}
	
	/**
	 * This is a helper method for removing an element.
	 * 
	 * @param node
	 * 	Node currently being looked at
	 * @param item
	 * 	item to be removed from set
	 * @return
	 * 	null if item was not present
	 *  node to be set as new root
	 *  
	 */
	private BSTNode <E> recRemove (BSTNode <E> node, E item) {
		//if item was not present 
		if (node == null) {
			return null;
		//search left if item is less than current node
		} else if (node.getData().compareTo(item) > 0) {
			node.setLeft(recRemove(node.getLeft(), item));
		//search right if item is 
		} else if(node.getData().compareTo(item) < 0) {
			node.setRight(recRemove(node.getRight(), item));
		//found item
		} else {
			//remove data stored in node
			node = nowRemove(node);
		}
		return node;
	}
	
	/**
	 * This method determines which case is present 
	 * and which Node to return.
	 * 
	 * @param node
	 * 	node to be removed 
	 * @return	
	 * 	BSTNode to be set as root
	 * 
	 */
	private BSTNode <E> nowRemove(BSTNode <E> node) {
		//if one child and left is empty
		if (node.getLeft() == null) {
			return node.getRight();
		}
		//if one child and right is empty 
		if (node.getRight() == null) {
			return node.getLeft();
		}
		//if two children present 
		E data = getPredecessor(node);
		node.setData(data);
		node.setLeft(recRemove(node.getLeft(), data));
		return node;
	}
	
	/**
	 * This method returns the data of the rightmost node of the 
	 * specified node's left subtree. This will be used to replace
	 * the element being removed. 
	 * 
	 * @param n
	 * 	item to be removed
	 * @return
	 * 	data of element to replace object being removed
	 * 
	 */
	private E getPredecessor(BSTNode <E> n) {
		//go to left subtree
		BSTNode <E> current = n.getLeft();
		//go to largest element
		while (current.getRight() != null) {
			current = current.getRight();
		}
		//return it
		return current.getData();
	}
	
	/**
	 * This method returns true if this set contains the specified element.
	 * 
	 * @param o
	 * 	object being looked for in set
	 * @return
	 * 	true if object is present
	 *  false otherwise
	 * @throws ClassCastException
	 * 	if the specified object cannot be compared with elements currently present
	 * @throws NulPointerException
	 *  if the specified element is null 
	 *  
	 */
	public boolean contains (Object o) throws ClassCastException {
		if (o == null) {
			throw new NullPointerException("Can not specify a null element.");
		}
		E ob = (E) o;
		//send to recursive method
		return recContains(this.root, ob);
	}
	
	/**
	 * This is a helper method that determines if this set
	 * contains the specfied item.
	 * 
	 * @param n
	 *  node currently being looked at
	 * @param item
	 * 	item being searched for
	 * @return
	 * 	true if item was present
	 *  false otherwise 
	 *  
	 */
	private boolean recContains (BSTNode <E> n, E item) {
		if (n == null) {
			return false;
		//search left
		} else if (n.getData().compareTo(item) > 0) {
			return recContains(n.getLeft(), item);
		//search right
		} else if (n.getData().compareTo(item) < 0) {
			return recContains(n.getRight(), item);
		//if found
		} else {
			return true;
		}
	}
	
	/**
	 * This method returns the first (lowest) element currently in this set.
	 * 
	 * @return
	 * 	the first (lowest) element current in this set
	 * @throws NoSuchElementException
	 * 	if this set is empty
	 * 
	 */
	public E first () {
		if (root == null) {
			throw new NoSuchElementException("The set is empty.");
		}
		BSTNode <E> n = root;
		//search left all the way down
		while (n.getLeft() != null) {
			n = n.getLeft();
		}
		//return lowest element
		return n.getData();
	}
	/**
	 * This method returns the last (highest) element currently in this set.
	 * 
	 * @return
	 *  the last (highest) element currently in this set
	 * @throws NoSuchElementException
	 *  if this set is empty
	 *  
	 */
	public E last () {
		if (root == null) {
			throw new NoSuchElementException("This set is empty.");
		}
		BSTNode <E> n = root;
		//go all the way to the right
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n.getData();
	}
	
	/**
	 * Returns a String representation of this BST.
	 */
	public String toString () {
		//pass to helper
		recInorderTraversal(this.root);
		//enclose list in brackets
		return "[ " + this.collec + " ]";
	}
	/**
	 * This is a helper method to return the 
	 * string representation. 
	 * 
	 * @param n
	 * 	current node being looked at
	 */
	private void recInorderTraversal(BSTNode <E> n) {
		//traverse through BST inorder
		if (n != null) {
			recInorderTraversal(n.getLeft());
			//send to helper
			inorderHelp(n.getData().toString());
			recInorderTraversal(n.getRight());
		} 
 	}
	/**
	 * This method adds the specified element to the 
	 * string representation.
	 * 
	 * @param element
	 * 	element being added
	 * 
	 */
	private void inorderHelp (String element) {
		//if last element being added do not put a comma
		if (element.equals(this.last().toString())) {
			this.collec += element;
		} else {
			this.collec += element + ", ";
		}
	}
}
