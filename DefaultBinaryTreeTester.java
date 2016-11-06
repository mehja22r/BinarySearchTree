import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Junit Tester to check methods in DefaultBianryTree and DefaultBinarySearchTree**/
public class DefaultBinaryTreeTester
{

	/**code taken from cswiki page**/

	public static final int NUM_ELEMENTS = 500;
	private Integer[] randomArray;

	private BinarySearchTree<Integer> randomBST;
	
	/**making a new search tree to test transversals**/
	private BinarySearchTree<Integer> tree;  

	@Before
	public void setUp() throws Exception
	{
		setupRandomArray();
	}

	private void setupRandomArray()
	{
		randomArray = new Integer[NUM_ELEMENTS]; // random integers
		for (int i = 0; i < randomArray.length; i++)
			randomArray[i] = new Integer((int) (Math.random() * 10000) + 1);

		randomBST = new DefaultBinarySearchTree<Integer>();
		for (int i = 0; i < randomArray.length; i++)
			randomBST.insert(randomArray[i]);

		System.out.println("random inorder traversal is: " + randomBST.inorderString());
	}

	/**creating a search tree to test transversals and other methods**/
	@Before
	public void createtree() {
		
		//creating a tree of type Integer
		tree = new DefaultBinarySearchTree<Integer>();
		
		//creating a new node called root
		BinaryTreeNode<Integer> root = new DefaultBinaryTreeNode<Integer>();
		
		//setting the root a value
		root.setData(48);
		
		//setting root as the root of the tree
		tree.setRoot(root);
		
		/**creating new nodes and setting data**/
		BinaryTreeNode<Integer> node =  new DefaultBinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node1 =  new DefaultBinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node2 =  new DefaultBinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node3 =  new DefaultBinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node4 =  new DefaultBinaryTreeNode<Integer>();

		node.setData(8);
		node1.setData(15);
		root.setLeftChild(node);
		node.setRightChild(node1);

		node2.setData(75);
		node3.setData(50);
		node4.setData(88);

		root.setRightChild(node2);
		node2.setLeftChild(node3);
		node2.setRightChild(node4);
	}



	/**testing search in binary search tree
	 * should return null because 77 doesn't exist in tree
	 **/
	@Test
	public void testSearch() {
		assertEquals(null, tree.search(77));
	}

	/**testing minimum search
	 * 8 is the smallest element in tree**/
	@Test
	public void testMinSearch() {
		assertEquals("8", tree.minElement().toString());
	}

	/**test inorder traversal for tree**/
	@Test
	public void testInorderTraversal() {
		assertEquals("8 -> 15 -> 48 -> 50 -> 75 -> 88", tree.inorderTraversal().toString());
		System.out.println(tree.inorderString());
	}

	/**test max search
	 * 88 is the largest element**/
	@Test
	public void testMaxSearch() {
		assertEquals("88", tree.maxElement().toString());
	}

	/**test postorder traversal**/
	@Test
	public void testPostorderTraversal() {
		assertEquals("15 -> 8 -> 50 -> 88 -> 75 -> 48", tree.postorderTraversal().toString());
		System.out.println(tree.postorderString());
	}

	/**test preorder traversal for tree**/
	@Test
	public void testPreorderTraversal() {
		assertEquals("48 -> 8 -> 15 -> 75 -> 50 -> 88", tree.preorderTraversal().toString());
		System.out.println(tree.preorderString());
	}

	/**test insert
	 * insert 26 into tree and search for it
	 */
	@Test
	public void testInsert() {
		tree.insert(26);
		assertEquals("26", tree.search(26).getData().toString());
	}

	/**tests taken from cswiki**/
	@Test
	public void testEltExists()
	{
		int randomIdx = (int) Math.floor(Math.random() * randomArray.length);
		assertEquals("search for element in random tree",
				randomArray[randomIdx],
				randomBST.search(randomArray[randomIdx]).getData());
	}

	@Test
	public void testEltNotExist()
	{
		assertEquals("search for element not in random tree", null,
				randomBST.search(new Integer(0)));
	}

	@Test
	public void testMin()
	{
		System.out.println( "Min in random tree is: " + randomBST.minElement() );
		assertEquals( "Testing min in random tree", findMin(randomArray),
				randomBST.minElement() );
	}


	@Test
	public void testMax()
	{
		System.out.println( "Max in random tree is: " + randomBST.maxElement() );
		assertEquals( "Testing max in random tree", findMax(randomArray),
				randomBST.maxElement() );
	}


	private Integer findMin( Integer[] a )
	{
		// start min at first element
		Integer min = a[0];

		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( min ) < 0 )
				// save it
				min = a[i];

		// return result
		return min;	
	}

	private Integer findMax( Integer[] a )
	{
		// start max at first element
		Integer max = a[0];

		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( max ) > 0 )
				// save it
				max = a[i];

		// return result
		return max;	
	}
}

