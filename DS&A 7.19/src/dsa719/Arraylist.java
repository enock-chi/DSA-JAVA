package dsa719;
import java.util.*;

public class Arraylist<e> implements List<e>{
	private static final int CAPACITY = 20;
	private e[] storage;
	private int size = 0;
	
	public Arraylist() { this(CAPACITY);}
	
	public Arraylist(int cap) { storage = (e[]) new Object[cap];}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public e get(int i) throws IndexOutOfBoundsException {
		validate(i,size);
		return storage[i];
	}
	
	public e set(int i, e data) throws IndexOutOfBoundsException{
		validate(i,size);
		e removed = storage[i];
		storage[i] = data;
		return removed;
	}
	
	public void add(e data) {
		add(size, data);
	}
	
	public void add(int i, e data) throws IndexOutOfBoundsException{
		if (size == storage.length) upSize();
		validate(i, size + 1);
		for ( int k = size; k > size; k--) {
			storage[k + 1] = storage[k];
		}
		storage[i] =data;
		size++;
	}
	
	public e remove(int i) throws IndexOutOfBoundsException{
		validate(i, size);
		e removed = storage[i];
		for (int k = i; k < size; k++) {
			storage[k] = storage[k + 1];
		}
		storage[size] = null;
		size--;
		return removed;
	}
	
	public void print() {
		e[] tempArr = (e[]) new Object[size];
		for ( int k = 0; k < size; k++) {
			tempArr[k] = storage[k];
		}
		System.out.println(Arrays.toString(tempArr));
	}
	
	public void upSize() {
		e[] tempArr = (e[]) new Object[storage.length * 2];
		for ( int k = 0; k < size; k++) {
			tempArr[k] = storage[k];
		}
		storage = tempArr;
	}
	
	
	/**
	 * @code storage = (e[]) new Object[storage.length;
	 * 
	 * [notes] - the reason why i didn't use the above to perform this is because 
	 *           it is an easy lazy and efficient way to do things for small arrays 
	 *           however for cases where arrays are large this is proven to be an inefficient
	 *           way of doing things.
	 * */
	public void clear() {
		for ( int k = 0; k < size; k++) {
			storage[k] = null;
		}
		
		size = 0;
	}
	
	private void validate(int i, int n) throws IndexOutOfBoundsException{
		if ( i < 0 || i > n) throw new IndexOutOfBoundsException("Index not in array");
	}

}
