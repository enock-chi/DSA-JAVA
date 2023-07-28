package dsa624;

public interface Queue<e> {
	int size();
	
	boolean isEmpty();
	
	void queue(e data);
	
	e dequeue();
	
	e first();
}
