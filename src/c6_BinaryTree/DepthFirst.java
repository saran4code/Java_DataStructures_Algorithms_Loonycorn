package c6_BinaryTree;

public class DepthFirst {

/*
 * --- preOrder method
 * Process the node first before processing the left and right subtree. if any of the children are null, we will
 * hit the base case and return
 */
	public static void preOrder(Node<Character> root) {
		if (root == null) {   //Base case - Nothing to traverse
			return;
		}
		print(root);     
		preOrder(root.getLeftChild());  
		preOrder(root.getRightChild());
	}

/*
 * --- inOrder method
 * Process the left subtree --> the node --> then recurses to the right subtree
 */
	
	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeftChild());
		inOrder(root);
		inOrder(root.getRightChild());
	}
	
/*
 * --- postOrder method
 */
	
	public static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.getLeftChild());
		postOrder(root.getRightChild());
		postOrder(root);
		
	}
}
