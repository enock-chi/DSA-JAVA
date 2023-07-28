package dsa72;
import java.util.*;

public interface Stack<e> {
	int size();
	
	boolean isEmpty();
	
	void push(e data);
	
	e pop();
	
	e first();

}
