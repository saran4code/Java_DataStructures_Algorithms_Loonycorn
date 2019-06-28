package c10_Heap;

import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable>{
	
	private static int MAX_SIZE = 40;
	private T[] array;
	private int count = 0;
	
	
	
	public Heap(Class<T>, clazz) {
		this(clazz, MAX_SIZE);
	}
	
	public Heap(Class<T> clazz, int size) {
		array = (T[]) Array.newInstance(clazz, size);
	}
	
	protected void swap(int index1, int index2) {
		T tempValue = array[index1];
		array[index1] = array[index2];
		array[index2] = tempValue;
	 }

/*
 * --- Helper methods to check if heap is full, empty, get number of elements. 
 */
	public int getCount() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == array.length;
	}
	
	public T getElementAtIndex(int index) {
		return array[index];
	}

	

	/*
 * --- getLeftChild
 */
	public int getLeftChildIndex(int index) {
		int leftChildIndex = 2 * index + 1;
		if (leftChildIndex >= count) {
			return -1;
		}
		
		return leftChildIndex;
	} 
/*
 * --- getRightChild
 */
	
	public int getRightChildIndex(int index) {
		int rightChildIndex = 2 * index + 2;
		if (rightChildIndex >= count) {
			return -1;
		}
		
		return rightChildIndex;
	}
/*
 * --- getParentIndex
 */
	
	public int getParentIndex (int index) {
		if (index < 0 || index > count) {
			return -1;
		}	
		return (index -1) /2;
	}
}
