package c8_BinarySearchTree;

import c6_BinaryTree.Node;

public class BstProblems {
	
	
/*
* --- Minimum value in BST	
* -Base case,if the head is null then the tree has no nodes to return the minimum integer values
* -Follow the left child for every node, if the left child is NULL then this is the minimum value node
* -Recurse till a left child is available (minimumValue)
*/

public static int minimumValue(Node<Integer> head) {
	if (head == null) {
		return Integer.MIN_VALUE;
	}
	
	if (head.getLeftChild() == null) {
		return head.getData();
	}
	
	return minimumValue(head.getLeftChild());
}
/*
* --- Maximum depth of a binary tree
* -Base case,if the head is null then the tree has no nodes , the max depth is 0
* -If both left and right child of the node is NULL then this is a leaf and has a depth of 0
* -Find the max depth on the left and the right sub-trees - Add 1 to account for the current depth of the tree
* -Find the max depth between the left and right sub-trees	
*/

public static int maxDepth(Node root) {
	if (root == null) {
		return 0;
	}
	if (root.getLeftChild() == null && root.getRightChild() == null) {
		return 0;
	}
	
	int leftMaxDepth = 1 + maxDepth(root.getLeftChild());
	int rightMaxDepth = 1 + maxDepth(root.getRightChild());
	
	return Math.max(leftMaxDepth, rightMaxDepth);
}

/*
* --- Mirror a Binary Tree
* -Base case,if the head is null then the tree has no nodes and there is nothing to mirror
* -Call mirror recursively on every node in the left and right sub trees
*/
public static void mirror(Node<Integer> root) {
	if (root == null) {
		return;
	}
	
	mirror(root.getLeftChild());
	mirror(root.getRightChild());
	
	//Swap the left and the right child of each node
	Node<Integer> temp = root.getLeftChild();
	root.setLeftChild(root.getRightChild());
	root.setRightChild(temp);
}

	
/*
 * --- count Trees
 * - When the number of nodes is 1, there is just one possible tree - this is the base case
 * - Consider that every node can be root - the nodes before it will be on the left and the nodes after it on the right. 
 * - nodes on the left and right form their own subtree
 * - This is the number of possible trees with this root - the combination of right and left trees
 * - Every structurally unique left subtree can be combined with every structurally unique right subtree
 */
	public static int countTrees(int numNodes) {
		if (numNodes <= 1) {
			return 1;
		}
		int sum=0;
		for (int i = 1; i <= numNodes; i++) {
			int countLeftTrees = countTrees(i - 1);
			int countRightTrees = countTrees(numNodes -1);
			
			sum = sum + (countLeftTrees * countRightTrees);
		}
		return sum;
		
	}
/*
 * --- printRange 
 * - The constructor is pass in the min and max indicating the range we care about
 * - Base case, nothing to do for a null root
 * - If the range low value is less than the current node, run the operation on the left subtree
 * - check the node value to see if it's within the range  - if yes, print.
 * - If the range high value is greater than the current node, run the operation on the right subtree
 */
	
	public static void printRange(Node<Integer> root, int low, int high) {
		if (root == null) {
			return;
		}
		
		if (low <= root.getData()) {
			printRange(root.getLeftChild(), low, high);
		}
		
		if (low <= root.getData() && root.getData() <= high) {
			System.out.println(root.getData());
		}
		
		if (high > root.getData()) {
			printRange(root.getRightChild(), low, high);
		}
	}
	
/* 
 * -- Is Binary search tree?
 * - Constructor - passing the minimum and maximum range for the subtree
 * - A null node is valid Binary tree
 * - If any node lies outside the range then the best constraint has been violated and we return false
 * - check the left and right subtrees to see if they're valid search trees - note how the range for the checks change
 * - For the left subtree, the current node's value should be max. For right subtree, the current node's value must be min. 
 */
	
	public static boolean isBinarySearchTree(Node<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if (min <= root.getData() || root.getData() > max) {
			return false;
		}
		return isBinarySearchTree(root.getLeftChild(), min, root.getData())
				&& isBinarySearchTree(root.getRightChild(), root.getData(), max);
	}
}
