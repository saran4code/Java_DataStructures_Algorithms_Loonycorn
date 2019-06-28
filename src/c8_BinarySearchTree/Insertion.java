package c8_BinarySearchTree;

import c6_BinaryTree.Node;

public class Insertion {
	
	public static Node<Integer> insert (Node<Integer> head, Node<Integer> node) {
		if (head == null) {
			return node;
		}
		if (node.getData() <= head.getData()) {
			head.setLeftChild(insert(head.getLeftChild(), node));
		} else {
			head.setRightChild(insert(head.getRightChild(), node));
			
		}
		return  head;
	}

}
