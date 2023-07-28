package dsa622;
import java.util.*;

public class ArrayStack<e> implements Stack<e>{
	private static final int CAPACITY = 100;
	private e[] data;
	private int x = -1;
	private int length;
	
	public ArrayStack() { this(CAPACITY);}
	public ArrayStack(int Capacity) {
		data = (e[]) new Object[Capacity];
		length = Capacity;
	}
	
	@Override
	public int size() { return (x + 1);}
	@Override
	public boolean isEmpty() { return ( x == -1);}
	
	@Override
	public e top() {
		if (isEmpty()) {return null;}
		return data[x];
	}
	
	private e pop() {
		if (isEmpty()) { return null;}
		e answer = data[x];
		data[x] = null;
		x--;
		return answer;
	}
	
	private void push(e data) throws IllegalStateException{
		if (size() == this.data.length) {
			throw new IllegalStateException("Stack is full");
		}
		this.data[++x] = data;
	}
	
	public void print() {
		System.out.println(Arrays.toString(data));
	}
	
	public static void dump(ArrayStack x, ArrayStack y) {
		y.push(x.pop());
	}
	
	public void insert(e data) {
		if (size() == this.data.length) {
			throw new IllegalStateException("Stack is full");
		}
		this.data[++x] = data;
	}
	
	public int length() {
		return length;
	}
		
}
