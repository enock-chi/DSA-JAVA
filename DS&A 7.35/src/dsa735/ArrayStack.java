package dsa735;
import java.util.*;
public class ArrayStack<e> implements Stack<e> {
	  protected final static int CAPACITY = 20; 
      private e[] data;
      private int head;
      private int size;
      
      public ArrayStack() { this(CAPACITY);}
      
      public ArrayStack( int cap) {
    	  data = (e[]) new Object[cap];
    	  head = 0;
    	  size = 0;
      }
      
      public int size() { return size;}
      
      public boolean isEmpty() { return (size == 0);}
      
      public void push( e data) {
    	  resize();
    	  this.data[head] = data;
    	  head++;
    	  size++;
      }
      
      public e first() { return  isEmpty() ?  null :  data[--head];}
      
      public e pop() {
    	  if (isEmpty()) return null;
    	  resize();
    	  e removed = data[head - 1];
    	  data[head - 1] = null;
    	  head--;
    	  size--;
    	  return removed;
      }
      
      public void resize() {
    	  e[] temp = null;
    	  if ( size == data.length) {
    		  temp = (e[]) new Object[data.length * 2];
    	  } else if( size <= (data.length / 2)) {
    		  temp = (e[]) new Object[(int) (data.length * 0.75)];
    	  } else {
    		  return;
    	  }
    	  
    	  for ( int k = 0; k < size ; k++) {
    		  temp[k] = data[k];
    	  }
    	  
    	  data = temp;
    	  
      }
      
      public void print() {
    	  e[] arr = (e[]) new Object[size];
    	  for (int k = 0; k < size; k++) {
    		  arr[k] = data[k];
    	  }
    	  System.out.println(Arrays.toString(arr));
      }
      
      public void fullPrint() {
    	  System.out.println(Arrays.toString(data));
      }
	

}
