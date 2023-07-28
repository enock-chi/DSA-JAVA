package dsa628;
import java.lang.reflect.Array;
import java.util.*;

public class ArrayQueue<e> implements Queue<e>, Cloneable{
	public static final int CAPACITY = 100;
	private e[] data;
	private int f = 0;
	private int sz = 0;
	
	public ArrayQueue() { this(CAPACITY);}
	
	public ArrayQueue(int cap) { data = (e[]) new Object[cap];}
	
	public int size() { return  sz;}
	
	public boolean isEmpty() { return (sz == 0);}
	
	public void enqueue(e data) throws IllegalStateException {
		if (sz == this.data.length) throw new IllegalStateException("Queue is full");
		int avail = (f+sz) % this.data.length;
		this.data[avail] = data;
		sz++;
	}
	
	public e dequeue() {
		if (isEmpty()) return null;
		e answer = data[f];
		data[f]= null;
		f = (f+1)%data.length;
		sz--;
		return answer;
				
	}
	
	public e first() {
		if (isEmpty()) return null;
		return data[f];
	}
	
	public void print() {
		System.out.println(Arrays.toString(data));
	}
	
	@Override
	public ArrayQueue<e> clone(){
		ArrayQueue<e> other = new ArrayQueue<>(data.length);
		for (int k = 0; k < data.length; k++) {
			other.enqueue(data[k]);
		}
		
		return other;
	}

}
