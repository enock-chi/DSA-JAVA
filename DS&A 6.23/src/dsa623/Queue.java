package dsa623;

public interface Queue<e> {
	int size();
	
	void queue(e data);
	
	e dequeue();
	
	e first();
	
	boolean isEmpty();

}
