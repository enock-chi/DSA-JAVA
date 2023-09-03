package dsa725;
import java.util.*;

public class ArrayBasedList<e> implements List<e>{
	public static int CAPACITY = 20;
	private e[] data;
	private int head;
	private int tail;
	private int size;
	
	public ArrayBasedList() {this(CAPACITY);}
	
    public ArrayBasedList(int cap) {
    	data = (e[]) new Object[cap];
    	head = 0;
    	tail = 0;
    	size = 0;
    }
    
    public int size() { return size;}
    
    public boolean isEmpty() { return (size == 0);}
    
    @SuppressWarnings("unchecked")
    public e get(int i) throws IndexOutOfBoundsException {
    	return data[index(i)];
    }
    
    @SuppressWarnings("unchecked")
    public e set(int i, e data) throws IndexOutOfBoundsException {
    	e removed = this.data[index(i)];
    	this.data[index(i)] = data;
    	return removed;
    }
    
    public void addFront( e data) throws IndexOutOfBoundsException, IllegalStateException {
    	if ( size == this.data.length) throw new IllegalStateException("List is full");
    	head = ( head - 1 + this.data.length  ) % this.data.length;
    	this.data[head] = data;
    	size++;
    }
    
    public void addBack( e data ) throws IndexOutOfBoundsException, IllegalStateException {
    	if ( size == this.data.length) throw new IllegalStateException("List is full");
    	this.data[tail] = data;
    	tail = (tail + 1) % this.data.length;
    	size++;
    	
    }
    
    @SuppressWarnings("unchecked")
    public e removeFront() throws IllegalStateException {
    	if ( isEmpty()) throw new IllegalStateException("List is Empty");
    	e removed = data[head];
    	data[head] = null;
    	head = (head + 1 ) % this.data.length;
    	size--;
    	return removed;
    }
    
    @SuppressWarnings("unchecked")
    public e removeBack() throws IllegalStateException{
    	if (isEmpty()) throw new IllegalStateException("List is Empty");
    	tail = ( tail - 1 + this.data.length) % this.data.length;
    	e removed = data[tail];
    	data[tail] = null;
    	size--;
    	return removed;
    }
    
    public void print() {
    	System.out.println(Arrays.toString(data));
    }
    
    
    public int index(int i) {
    	return ( head + i ) % data.length;
    }
    
    
}
