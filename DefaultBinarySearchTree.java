/**
 * DeafultBinarySearchTree is the class for a basic binary search tree.
 * The binary search tree contains Comparable objects as data with
 * the invariant that all data in the left subtree of a node is
 * less than the data at the node, and all data in the right subtree
 * is greater than or equal to the data at the node.
 */
public class DefaultBinarySearchTree<T extends Comparable<T>> extends
DefaultBinaryTree<T> implements BinarySearchTree<T> {


	/**
	 * Insert the data into the tree, maintaining the
	 * search tree invariant.
	 */  
	@Override
	public void insert(T data) {

		if (root == null) {

			//create a new node
			BinaryTreeNode<T> tempRoot =  new DefaultBinaryTreeNode<T>();

			//set data to the new node
			tempRoot.setData(data);

			//set root equal to new node
			root = tempRoot;
		}

		else {

			//if root is not null call recusion
			insertRecursion(data, root);
		}
	}

	/**a method that uses recursion to insert the data in the correct place,
	 * data is inserted as a right child if it's greater than node
	 * or data is inserted as a left child if it's less than node
	 */
	public void insertRecursion(T data, BinaryTreeNode<T> node) {
		//create a data that stores value of the node passed in in the paramter
		T tempData = (T) node.getData();

		//if the data is greater or equal to the node and the node doesn't have a ight child
		if (tempData.compareTo(data) < 0 && node.getRightChild() == null) {

			BinaryTreeNode<T> tempNode = new DefaultBinaryTreeNode<T>();

			tempNode.setData(data);

			//set the data as a rightChild node
			node.setRightChild(tempNode);
		}

		//if data is smaller or equal to node and there is no left child
		else if (tempData.compareTo(data) >= 0 && node.getLeftChild() == null) {

			BinaryTreeNode<T> tempNode = new DefaultBinaryTreeNode<T>();

			tempNode.setData(data);

			//set the data to the leftChild
			node.setLeftChild(tempNode);
		}

		//recursive case
		else {

			//if the data is smaller or equal to node
			if (tempData.compareTo(data) >= 0) {

				//insert data to the left
				insertRecursion(data, node.getLeftChild());
			}

			//if the data is greater than node
			else if (tempData.compareTo(data) < 0) {

				//insert it to the right
				insertRecursion(data, node.getRightChild());
			}
		}
	}

	/**
	 * Search for data in the tree, finding the node
	 * containing it, or null if the data is not present
	 * in the tree.
	 * @return the node containing data or null if none exists.
	 */
	@Override
	public BinaryTreeNode<T> search(T data) {
		return searchRecursion(data, root);
	}
	
	/**searchRecursion takes in the data we are searching for 
	 * and a BinaryTreeNode for comparison**/
	public BinaryTreeNode<T> searchRecursion(T data, BinaryTreeNode<T> node) {
		
		//base case, if there is no node to compare to
		if (node == null) {
			return null;
		}
		
		//2nd base case, if the node we are comparing to matches the data
		if (node.getData().compareTo(data) == 0) {
			return node;
		}
		
		//recursive case
		else {
			
			//if the node data is greater than data 
			if (node.getData().compareTo(data) > 0) {
				
				//search in the leftChild for the data
				return searchRecursion(data, node.getLeftChild());
			}
			
			//the only option left is for the data to be greater than node data
			//check the rightChild
			return searchRecursion(data, node.getRightChild());
		}
	}

	/**
	 * Find the minimum element in the tree.
	 */
	@Override
	public T minElement() {
		return minElementRecursion(root);
	}

	/**find the minimum element through a recursive method**/
	public T minElementRecursion(BinaryTreeNode<T> node) {
		
		//base case, if there is no leftChild
		if (node.getLeftChild() == null) {
			
			//that means we found the minimum value in the tree
			return node.getData();
		}
		
		//recursive case
		else {
			
			//if there are still left children, keep going
			return minElementRecursion(node.getLeftChild());
		}
	}


	/**
	 * Find the maximum element in the tree.
	 */
	@Override
	public T maxElement() {
		return maxElementRecursion(root);
	}

	/**recursive method to find the max element in a tree**/
	public T maxElementRecursion(BinaryTreeNode<T> node) {
		
		//base case, if there are no right children
		if (node.getRightChild() == null) {
			
			//we found max element in the tree
			return node.getData();
		}
		
		//recursive case
		else {
			//keep searching through right children
			return maxElementRecursion(node.getRightChild());
		}
	}

}
