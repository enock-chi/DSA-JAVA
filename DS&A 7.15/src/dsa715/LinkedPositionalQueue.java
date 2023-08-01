package dsa715;

import java.util.ArrayList;

public class LinkedPositionalQueue<e> implements Queue<e> {
	private LinkedPositionalList<e> list = new LinkedPositionalList<>();
	private ArrayList<Position<e>> position = new ArrayList<>();
	
	public LinkedPositionalQueue() {}
	
	public int size() { return list.size();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public e first() { return list.first().getData();}
	
	public e dequeue() throws IllegalArgumentException { return dequeue(position.get(list.size() - 1));}
	
	public e dequeue(Position<e> p) throws IllegalArgumentException  { return list.remove(remove(position.indexOf(p),position));}
	
	public void enqueue(e data) { position.add(list.addLast(data));}
	
	public void print() { list.print();}
    
	public static <e> Position<e> remove( int i, ArrayList<Position<e>> pos){
		return pos.remove(i);
	}
}
