package dsa628;

public interface Queue<e> {
	void enqueue(e data);
	
	e dequeue();
	
	e first();
	
	int size();
	
	boolean isEmpty();

}
