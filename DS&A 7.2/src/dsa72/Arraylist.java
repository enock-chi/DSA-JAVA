package dsa72;
import java.util.*;

public class Arraylist<e> implements List<e> {
	public static final int CAPACITY = 20;
	private e[] data;
	private int size = 0;
	
	public Arraylist() { this(CAPACITY);}
	
	public Arraylist(int cap) { data = (e[]) new Object[cap];}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public e get(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		return data[i];
	}
	
	public e set(int i, e data) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		e element = this.data[i];
		this.data[i] = data;
		return element;
	}
	
	public void add(int i, e data) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		if ( size == this.data.length) resize(this.data.length);
		for (int k = size - 1; k > i; k--) {
			this.data[k+1] = this.data[k];
		}
		this.data[i] = data;
		size++;
	}
	
	public e remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		e element = data[i];
		
		for ( int k = i; k < size - 1 ; k++ ) {
			data[k] = data[k+1];
		}
		data[size] = null;
		size--;
		return element;
	}
	
	protected void resize(int s) {
		e[] arr = (e[]) new Object[s*2];
		for ( int k = 0; k < s; k++) {
			arr[k] = data[k];
		}
		data = arr;
	}
	
	public void print() {
		e[] arr = (e[]) new Object[size];
		for ( int k = 0; k < size; k++) {
			arr[k] = data[k];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	protected void checkIndex(int i, int s) throws IndexOutOfBoundsException {
		if ( i < 0 || i >= s) throw new IndexOutOfBoundsException("");
	}
 
}
