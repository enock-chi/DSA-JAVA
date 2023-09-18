package dsa735;
import java.util.*;
public class ArrayStack<e> implements Stack<e> {
	  protected final static int CAPACITY = 20; 
      private e[] data;
      private int head;
      private int tail;
      private int size;
      
      public ArrayStack() { this(CAPACITY);}
      
      public ArrayStack( int cap) {
    	  data = (e[]) new Object[cap];
    	  head = 0;
    	  tail = 0;
    	  size = 0;
      }
      
      public int size() { return size;}
      
      public boolean isEmpty() { return (size < 0);}
      
      public void push( e data) {
    	  this.data[head] = data;
    	  head++;
    	  size++;
      }
      
      public e first() { return  isEmpty() ?  null :  data[--head];}
      
      public e pop() {
    	  if (isEmpty()) return null;
    	  e removed = data[tail];
    	  data[head] = null;
    	  head--;
    	  size--;
    	  return removed;
      }
      
      public void print() {
    	  e[] arr = (e[]) new Object[size];
    	  for (int k = tail; k < size; k++) {
    		  arr[k] = data[k];
    	  }
    	  System.out.println(Arrays.toString(arr));
      }
	

}
