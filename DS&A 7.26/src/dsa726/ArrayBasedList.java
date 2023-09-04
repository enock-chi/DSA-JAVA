package dsa726;
import java.util.*;

public class ArrayBasedList<e> implements List<e> {
	private ArrayList<e> data;
	private int size;
	
	
    public ArrayBasedList() { 
    	data = new ArrayList<>();
    	size = 0;
    }
    
    public int size() { return size;}
    
    public boolean isEmpty() { return (size == 0);}
    
    public void addFront( e data) {
    	this.data.add(0,data);
    	size++;
    }
    
    public void addBack( e data) {
    	this.data.add(data);
    	size++;
    }
    
    public e removeFront() throws IllegalStateException{
    	if (isEmpty()) throw new IllegalStateException("List is Empty");
    	e removed = data.remove(0);
    	size--;
    	return removed;
    }
    
    public e removeBack() throws IllegalStateException{
    	if (isEmpty()) throw new IllegalStateException("List is Empty");
    	e removed = data.remove(size - 1 );
    	size--;
    	return removed;
    }
    
    public e set(int i, e data) throws IllegalStateException{
    	if (isEmpty()) throw new IllegalStateException("List is Empty");
    	e removed = this.data.set(index(i), data);
    	return removed;
    }
    
    public e get(int i) throws IllegalStateException{
    	if (isEmpty()) throw new IllegalStateException("List is Empty");
    	return data.get(index(i));
    }
    
    public void print() {
    	System.out.println(data.toString());
    }
    
    public int index(int i) {
    	return (i + size) % size ;
    }
}
