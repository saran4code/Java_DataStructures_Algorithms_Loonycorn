package c8_BinarySearchTree;

import c6_BinaryTree.Node;

public class Lookup {
	
	public static Node<Integer> lookup(Node<Integer>head, int data) {
		if (head == null) {  // Base case, If the head is NULL then the node has not been found, therefore returning NULL
			return null;			
		}
		if (head.getData() == data) {
			return head;
		}
		if (data <= head.getData()) {
			return lookup(head.getLeftChild(), data);
		} else {
			return lookup(head.getRightChild(), data);
		}
	}

}
