package dsa718;
import java.util.*;

public class Arraylist<e> implements List<e> {
	private static final int capacity = 20;
	private e[] storage;
	private int size = 0;
	
	public Arraylist() { this(capacity);}
	
	public Arraylist(int cap) { storage = (e[]) new Object[cap];} 
	
	public int size() { return size;}
	
	public boolean isEmpty() {return (size == 0);}
	
	public e get(int i) throws IndexOutOfBoundsException{
		validate(i, size);
		return storage[i];
	}
	
	public void add(int i, e data) throws IndexOutOfBoundsException{
		validate(i, size + 1);
		if ( size >= (storage.length )) {
			upSize();
		}
		for ( int k = size; k > size; k--) {
			storage[k + 1] = storage[k];
		}
		storage[i] = data;
		size++;
	}
	
	public e remove(int i) throws IndexOutOfBoundsException{
		validate(i,size);
		e removed = storage[i];
		for ( int k = i; k < size; k++) {
			storage[k] = storage[k + 1];
		}
		storage[size + 1] = null;
		size--;
		return removed;
	}
	
	public e set(int i , e data) throws IndexOutOfBoundsException{
		validate(i,size);
		e temp = storage[i];
		storage[i] = data;
		return temp;
	}
	
	public boolean contains(e data) {
		for ( int k = 0; k < storage.length; k++) {
			if ( storage[k] == data) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		e[] arr = (e[])new Object[size];
		for (int k = 0; k < size; k++) {
			arr[k] = storage[k];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void upSize() {
		e[] tempArr = (e[]) new Object[storage.length * 2];
		for ( int k = 0; k < storage.length; k++) {
			tempArr[k] = storage[k];
		}
		
		storage = tempArr;
	}
	
	protected void validate(int i, int n) throws IndexOutOfBoundsException {
		if ( i < 0 || i > n) throw new IndexOutOfBoundsException(" Index not in set");
	}
	

}
