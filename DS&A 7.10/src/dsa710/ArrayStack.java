package dsa710;
import java.util.*;

public class ArrayStack<e> implements Stack<e>{
	public static final int CAPACITY = 20;
	private e[] data;
	private int size = 0;
	
	public ArrayStack() { this(CAPACITY);}
	
	public ArrayStack( int cap ) { data = (e[]) new Object[cap];}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public void push( e data) {
		if ( size == this.data.length) resize(this.data.length);
		this.data[size] = data;
		size++;
	}
	
	/** 
	 * This all come down to space or time complexity, 
	 * there is a better way to do this using less time 
	 * however just chose this way as it's easier
	 * */
	public e pop() {
		if (isEmpty()) return null;
		e element = data[size - 1];
		for (int k = 0; k < size -1; k++) {
			data[k] = data[k+1];
		}
		data[size - 1] = null;
		size--;
		return element;
	}
	
	public e top() {return data[size];}
	
	public void print() {
		e[] arr = (e[]) new Object[size];
		for ( int k = 0; k < size; k++) {
			arr[k] = data[k];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	protected void resize(int s) {
		e[] arr = (e[]) new Object[s*2];
		for ( int k = 0; k < size; k ++ ) {
			arr[k] = data[k];
		}
		
		data = arr;
	}
	

}
