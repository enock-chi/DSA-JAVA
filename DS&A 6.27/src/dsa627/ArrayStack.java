package dsa627;
import java.util.*;

public class ArrayStack<e> implements Stack<e>, Cloneable{
	public static final int CAPACITY = 1000;
	private e[] data;
	private int t = -1;
	
	public ArrayStack() { this(CAPACITY);}
	
	public ArrayStack(int cap) { 
		data = (e[]) new Object[cap];
	}
	
	public int size() { return (t+1);}
	
	public boolean isEmpty() { return (t == -1);}
	
	public e top() {
		if (isEmpty()) {
			return null;
		} else {
			return data[t];
		}
	}
	
	public e pop() {
		if (isEmpty()) {
			return null;
		} else {
			e answer = data[t];
			data[t] = null;
			t--;
			return null;
		}
	}
	
	public void push( e data) throws IllegalStateException {
		if (size() == this.data.length ) throw new IllegalStateException("Stack is full");
			this.data[++t] = data;
	}
	
	public void print() {
		System.out.println(Arrays.toString(data));
	}
	
	public ArrayStack<e> clone() throws CloneNotSupportedException {
		ArrayStack<e> other = new ArrayStack<>(data.length);
		if (size() > 0) {
			for (int k = 0; k < size(); k++) {
				other.push(data[k]);
			}
		}
		
		return other;
	}

}
