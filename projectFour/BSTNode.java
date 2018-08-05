package projectFour;

/**
 * This class is my implementation of my own BST Node class to be used
 * in my own implementation of a BST.
 * 
 * @author Brandon Herrera
 * @version 04/22/2017
 * 
 * @param <E>
 * 	generic element 
 *
 */

public class BSTNode <E extends Comparable <E>>
						implements Comparable <BSTNode <E>>{
	
	//data fields
	private E data;
	private BSTNode <E> left;
	private BSTNode <E> right;
	
	/**
	 * @param data
	 * 	Data to be stored in BSTNode
	 */
	public BSTNode (E data) {
		this.data = data;
	}
	
	/**
	 * This method overrides the compareTo method. It compares
	 * two BSTNodes based on the elements data type.
	 * 
	 * @param n
	 * 	BSTNode being compared with this BSTNode
	 * @return 
	 * 	0 if Nodes are equal
	 *  1 if this Node > n
	 * -1 if this Node < n
	 * 
	 */
	@Override
	public int compareTo (BSTNode <E> n) {
		return this.data.compareTo(n.data);
	}
	
	/**
	 * This method returns the data stored in this BSTNode.
	 * 
	 * @return data
	 * 	data stored in BSTNode
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * This method sets the data of this BSTNode.
	 * 
	 * @param data
	 * 	data being stored in BSTNode
	 * 
	 */
	public void setData(E data) {
		this.data = data;
	}
	
	/**
	 * This method returns the left child of this BSTNode.
	 * 
	 * @return left
	 * 	left child of BSTNode
	 * 
	 */
	public BSTNode<E> getLeft() {
		return left;
	}
	
	/**
	 * This method sets the left child of this BSTNode.
	 * 
	 * @param left
	 * 	BSTNode being set as left child of this BSTNode
	 * 
	 */
	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}
	
	/**
	 * This method returns the right child of this BSTNode.
	 * 
	 * @return right
	 * 	right child of this BSTNode
	 * 
	 */
	public BSTNode<E> getRight() {
		return right;
	}
	
	/**
	 * This method sets the right child of this BSTNode.
	 * 
	 * @param right
	 * 	BSTNode to be set as right child of this BSTNode
	 * 
	 */
	public void setRight(BSTNode<E> right) {
		this.right = right;
	}
	
}
