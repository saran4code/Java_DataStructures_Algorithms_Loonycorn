package c5_Stack;



public class Stack<T> {   // A Generic class that can be instantiated with any data type - stack can hold any data type
	
	private static int MAX_SIZE = 40;
	
	private Element<T> top;  // Points to the top most element in the stack. can be popped or peeked
	private int size = 0;    // Track the size of the stack at every push,pop. To make the stack size operation O(1)
	
	
/*
 * --- Push method
 * Create a new element to hold the data and point 	Top to it. Make sure you increment the size of the stack. 
 */
	
	public void push(T data) throws StackOverflowException {
		if (size == MAX_SIZE) {
			throw new StackOverflowException();
			}
		Element elem = new Element(data, top);
		top = elem;
		size++;
	}
	
/*
 * --- Pop method
 * 	Remove the top element from the stack and return it's data
 */
	
	public T pop() throws StackUnderflowException {
		if (size == 0) {
			throw new StackUnderflowException();
		}
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;
	}
	
/*
 * --- Peek method
 * Just return the data of the top element, do not remove it
 */
	public T peek() throws StackUnderflowException {
		if (size == 0 ) {
			throw new StackUnderflowException();
		}
		return top.getData();
	}
	
/*
 * --- IsEmpty, IsFull, Size - Code snippet
 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public int getSize() {
		return size;
	}

}
