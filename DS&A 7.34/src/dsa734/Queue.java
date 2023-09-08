package dsa734;

public interface Queue<e> {
    int size();
	
	boolean isEmpty();
	
	void enqueue(e data);
	
	e dequeue();
	
	e first();

}
