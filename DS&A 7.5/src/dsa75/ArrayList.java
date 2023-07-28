package dsa75;
import java.util.*;

public class ArrayList<e> implements List<e>{
	public static final int CAPACITY = 25;
	private e[] data;
	private int size = 0;
	
	public ArrayList() { this(CAPACITY);}
	
	public ArrayList(int cap) { data = (e[]) new Object[cap];}
	
	public int size() { return size ;}
	
	public boolean isEmpty() { return ( size == 0);}
	
	public e get(int i) throws IndexOutOfBoundsException{
		checkIndex(i,size);
		return data[i];
	}
	
	public e set(int i, e data) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		e temp = this.data[i];
		this.data[i] = data;
		return temp;
	}
	
	public void add(int i, e data) throws IndexOutOfBoundsException {
		checkIndex(i, size +1);
		if (size == this.data.length) resize(this.data.length,"U");
		for (int k = size - 1; k >= i ; k--) this.data[k+1] = this.data[k];
		this.data[i] = data;
		size++;
	}
	
	public e remove(int i) throws IndexOutOfBoundsException{
		checkIndex(i,size);
		if (isEmpty()) return null;
		e element = (e) data[i];
		for (int k = i ; k < size -1; k++) this.data[k] = this.data[k+1];
		this.data[size-1] = null;
		size--;
		if (size <= (data.length/2)) resize((int)(data.length/2),"D");
		return element;
	}
	
	public void print() {
		e[] arr = (e[]) new Object[size];
		for (int k = 0; k < size; k++) {
			arr[k] = data[k];
		}
		System.out.println(data.length);
		System.out.println(Arrays.toString(arr));
	}
	
	public void resize(int s, String direction) {
		e[] temp;
		if ( direction.equals("U")) {
			temp = (e[]) new Object[s*2];
			for ( int k = 0; k < s; k++ ) {
				temp[k] = data[k];
			}
			data = temp;
		} else {
			temp = (e[]) new Object[s];
			for ( int k = 0; k < s; k++ ) {
				temp[k] = data[k];
			}
			data = temp;
		}
		
	}
	
	
	public void trimToSize(int i) {
		checkIndex(i,size);
		while (size > i) {
			remove(size-1);
		}
	}
	
	protected void checkIndex(int i , int s) throws IndexOutOfBoundsException{
		if ( i < 0 || i > s) throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

}
