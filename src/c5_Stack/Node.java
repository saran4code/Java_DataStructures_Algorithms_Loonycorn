package c5_Stack;

public class Node <T extends Comparable <T>> {   
	
	
/*
 *   Diagrammatic representation
 *   --------------
 *   |data | next |   --> 
 *   --------------
 *            |_  pointer to the next node. Generally set to "NULL"
 *            
 *            
 */
	
/* 
 * --- About this class
 * The data should be comparable. This is for equality checks so you can do things like find what index a particular element is located
 * at in a list 
 * 
 */
	
// variables
	private T data;
	private Node<T> next;
	private Node<T> head = null;

/*
 * --- About countNodes	
 */
	public int countNodes() {
		
		if (head == null) {
			return 0;
		} else {
			
			Node<T> curr = head;
			int count = 0;
			while (curr != null) {
				curr = curr.getNext();
				count++;
			}
			return count;
	}
}
	

/*
 * --- About pop AKA find and replace first element
 *  Access the first element and delete it. Updating the head reference so the second next takes its position.
 */
	public T popElement() {
		if (head != null) {
			T topElement = head.getData();  // Read the data from the head element
			head = head.getNext();   //to move the head pointer to reference the new element
			return topElement;
		}
		return null;
	}
	
/*
 * --- About addNode
 * If this is the first node in the linked list. create a new node and assign the head reference to that node. 
 * The while loop follow the linked elements till we get to the very last element of the current list. 
 * Create a new node and point the very last element to it. 
 * curr.setNext(new Node<T>(data)) --> create a new node and point the very last element to it. 
 */

	public void addNode(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> curr = head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node<T>(data));
		}
	}
	
	public Node(T data) {
		this.data = data;
		setNext(null);
	}	
	/*
	 * --- About this method
	 * through the above method, we are setting next (pointer portion of the node) to null
	 */
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	@Override 
	public String toString() {
		return String.valueOf(data);
	}


	
	
}
