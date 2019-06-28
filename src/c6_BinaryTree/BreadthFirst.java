package c6_BinaryTree;

import java.util.Queue;
/*
 * Enqueue and Dequeue representation
+---+---+---++---+---+---++---+---+---+
enqueue -> | 3 | 2 | 1 | -> dequeue
+---+---+---++---+---+---++---+---+---+
*/

public class BreadthFirst {
	
	public static void breadthFirst(Node root) throws 
			Queue.QueueUnderflowException, Queue.QueueOverflowException {
		if (root == null) {  // null root indicates nothing to traverse
			return;
		}
		
		Queue<Node> queue = new Queue<>(Node.class);
		queue.enqueue(root);   // setup a queue and start by enqueuing (push into the queue) the root node
		while (!queue.isEmpty()) {        // As long as the queue is not empty, process the node at the head of the queue
			Node node = queue.dequeue();
			print(node);
			
			if (node.getLeftChild() != null) {        // Adding the left child first ensures that the nodes at the same level are processed
				queue.enqueue(node.getLeftChild());	  // from left to right. 		
			}
			if (node.getRightChild() != null) {		  // And add it's left and right child to the queue
				queue.enqueue(node.getRightChild());
			}
		}
	
	}

}
