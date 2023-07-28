package dsa79;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	void add(int i, e data);
	
	e remove(int i);
	
	e set(int i, e data);
	
	e get(int i);

}
