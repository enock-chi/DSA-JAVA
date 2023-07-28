package dsa79;
import java.util.*;

public class ArrayList<e> implements List<e> {
	public static final int CAPACITY = 20;
    private e[] data;
    private int size;
    
    public ArrayList() { this(CAPACITY);}
    
    public ArrayList(int cap) { data = (e[]) new Object[cap];}
    
    public int size() { return size;}
    
    public boolean isEmpty() { return (size == 0);}
    
    public e get(int i) throws IndexOutOfBoundsException {
    	checkIndex(i,size);
    	return data[i];
    } 
    
    public e set(int i, e data) throws IndexOutOfBoundsException {
    	checkIndex(i,size);
    	e element = this.data[i];
    	this.data[i] = data;
    	return element;
    }
    
    public void add(int i, e data) throws IndexOutOfBoundsException {
    	checkIndex(i,size+1);
    	for ( int k = size; k >= i; k--) {
    		this.data[k+1] = this.data[k];
    	}
    	this.data[i] = data;
    	
    }
    
    public e remove(int i) {
    	checkIndex(i,size);
    	e element = data[i];
    	for ( int k = i; k < size -1; k++) {
    		data[k] = data[k+1];
    	}
    	return element;
    }
    
    public void print() {
    	System.out.println(Arrays.toString(data));
    }
    
    protected void checkIndex(int i, int s) throws IndexOutOfBoundsException{
    	if ( i < 0 || i >= s) throw new IndexOutOfBoundsException("Index out of bounds: "+i);
    }
    
    public void resize
    
    

}
