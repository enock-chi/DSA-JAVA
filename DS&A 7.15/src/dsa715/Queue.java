package dsa715;

public interface Queue<e> {
	int size();
	
	boolean isEmpty();
	
	e first();
	
	e dequeue(Position<e> p);
	
	void enqueue(e data);

}
