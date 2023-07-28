package dsa73;

public interface Deque<e> {
	int size();
	
	boolean isEmpty();
	
	e first();
	
	e last();
	
	e removeFirst();
	
	e removeLast();
	
	void addFirst(e data);
	
	void addLast(e data);

}
