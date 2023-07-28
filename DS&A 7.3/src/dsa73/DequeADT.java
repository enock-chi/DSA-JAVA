package dsa73;
import java.util.*;

public class DequeADT<e> implements Deque<e> {
	ArrayList<e> deque = new ArrayList<>();
	
	public DequeADT() {}
	
	public int size() { return deque.size();}
	
	public boolean isEmpty() { return (deque.size() == 0);}
	
	public e removeLast() { return deque.remove(0);}
	
	public e removeFirst() { return deque.remove(deque.size()-1);}
	
	public void addFirst(e data) { deque.add(data);}
	
	public void addLast(e data) { deque.add(0,data);}
	
	public void print() { System.out.println(deque.toString());}
	
	public e last() { return deque.get(0);}
	
	public e first() {return deque.get(deque.size()-1);}

}
